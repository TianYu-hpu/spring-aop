package cn.com.zenmaster.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author: tianyu
 * @Date: 2019/1/14 17:13
 * @Description: 性能分析
 */
@Component
@Aspect
@Slf4j
public class TimerAspect {

	@Around(value = "execution(* cn.com.zenmaster..*.*(..)) && @annotation(cn.com.zenmaster.aop.annotation.Timer)")
	public Object process(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Object result =  pjp.proceed();
		long end = System.currentTimeMillis();
		log.info("操作计时:{}ms", end - start);
		return result;
	}

}
