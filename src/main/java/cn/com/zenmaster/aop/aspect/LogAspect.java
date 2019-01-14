package cn.com.zenmaster.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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

	@Around(value = "execution(* cn.com.zenmaster..*.*(..)) && @annotation(cn.com.zenmaster.aop.annotation.Log)")
	public Object process(ProceedingJoinPoint pjp) throws Throwable {
		log.info("current time:{}", System.currentTimeMillis());
		return pjp.proceed();
	}


}
