package cn.com.zenmaster.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author: tianyu
 * @Date: 2019/1/14 17:13
 * @Description:
 */
@Component
@Aspect
@Slf4j
public class AuthAspect {

	/*@Around(value = "execution(* cn.com.zenmaster..*.*(..)) && @annotation(cn.com.zenmaster.aop.annotation.Auth)")
	public Object process(ProceedingJoinPoint pjp) throws Throwable {
		String name = pjp.getSignature().getName();
		if(name.equals("hello")) {
			throw new RuntimeException("没有权限");
		}
		return pjp.proceed();
	}*/

	@Before(value = "execution(* cn.com.zenmaster..*.*(..)) && @annotation(cn.com.zenmaster.aop.annotation.Auth)")
	public void process(JoinPoint pjp) throws Throwable {
		String name = pjp.getSignature().getName();
		if(name.equals("hello")) {
			throw new RuntimeException("没有权限");
		}
	}

}
