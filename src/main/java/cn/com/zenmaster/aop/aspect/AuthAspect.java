package cn.com.zenmaster.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: tianyu
 * @Date: 2019/1/14 17:13
 * @Description: 认证授权
 */
@Component
@Aspect
@Slf4j
public class AuthAspect {

	@Around(value = "execution(* cn.com.zenmaster..*.*(..)) && @annotation(cn.com.zenmaster.aop.annotation.Auth) && args(name,..)")
	public Object process(ProceedingJoinPoint pjp, String name) throws Throwable {
		log.info("current time:{}, name:{}", System.currentTimeMillis(), name);
		if(!StringUtils.isEmpty(name)) {
			return pjp.proceed();
		} else {
			HttpServletRequest request = (HttpServletRequest) pjp.getArgs()[1];
			String ip = request.getRemoteAddr();

			log.info(" 非法访问:IP:{}, time:{}", ip, System.currentTimeMillis());
			throw new RuntimeException("非法访问");
		}
	}

}
