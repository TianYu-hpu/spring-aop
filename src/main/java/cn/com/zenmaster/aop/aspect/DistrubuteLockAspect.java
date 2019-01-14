package cn.com.zenmaster.aop.aspect;

import cn.com.zenmaster.service.LockService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: tianyu
 * @Date: 2019/1/14 17:13
 * @Description: 分布式锁
 */
@Component
@Aspect
@Slf4j
public class DistrubuteLockAspect {

	@Resource
	private LockService lockService;

	@Around(value = "execution(* cn.com.zenmaster..*.*(..)) && @annotation(cn.com.zenmaster.aop.annotation.DistrubuteLock) && args(name,..)")
	public Object process(ProceedingJoinPoint pjp, String name) throws Throwable {
		lockService.lock(name);
		Object result = pjp.proceed();
		lockService.unlock(name);
		return result;
	}

}
