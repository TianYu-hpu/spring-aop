package cn.com.zenmaster.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: tianyu
 * @Date: 2019/1/14 16:10
 * @Description:
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

	/*@Around(value = "execution(* cn.com.zenmaster..*.*(..)) && @annotation(cn.com.zenmaster.aop.annotation.Log)")
	public Object process(ProceedingJoinPoint pjp) throws Throwable {
		log.info("current time:{}", System.currentTimeMillis());
		return pjp.proceed();
	}*/

	@Before(value = "execution(* cn.com.zenmaster..*.*(..)) && @annotation(cn.com.zenmaster.aop.annotation.Log)")
	public void beforeExecute(JoinPoint pjp) throws Throwable {
		log.info("before execute time:{}", System.currentTimeMillis());
	}

	@After(value = "execution(* cn.com.zenmaster..*.*(..)) && @annotation(cn.com.zenmaster.aop.annotation.Log)")
	public void afterExecute(JoinPoint pjp) throws Throwable {
		log.info("after execute time:{}", System.currentTimeMillis());
	}

	@AfterThrowing(value = "execution(* cn.com.zenmaster..*.*(..)) && @annotation(cn.com.zenmaster.aop.annotation.Log)")
	public void afterThrowingExecute(JoinPoint pjp) throws Throwable {
		log.info("after throwing execute time:{}", System.currentTimeMillis());
	}

	@AfterReturning(value = "execution(* cn.com.zenmaster..*.*(..)) && @annotation(cn.com.zenmaster.aop.annotation.Log)")
	public void afterReturningExecute(JoinPoint pjp) throws Throwable {
		log.info("after returning execute time:{}", System.currentTimeMillis());
	}


}
