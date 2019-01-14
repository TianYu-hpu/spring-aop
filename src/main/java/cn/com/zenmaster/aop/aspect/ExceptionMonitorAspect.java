package cn.com.zenmaster.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author: tianyu
 * @Date: 2019/1/14 17:13
 * @Description:  异常监控
 */
@Component
@Aspect
@Slf4j
public class ExceptionMonitorAspect {

	@Around(value = "execution(* cn.com.zenmaster..*.*(..)) && @annotation(cn.com.zenmaster.aop.annotation.ExceptionMonitor)")
	public Object process(ProceedingJoinPoint pjp) throws Throwable {
		try{
			return pjp.proceed();
		} catch(Throwable e) {
			String className = pjp.getTarget().getClass().getName();
			String methodName = pjp.getSignature().getName();
			log.info("抛出异常:className:{}, methodName:{}, time:{}", className, methodName, System.currentTimeMillis());
			return null;
		}
	}

}
