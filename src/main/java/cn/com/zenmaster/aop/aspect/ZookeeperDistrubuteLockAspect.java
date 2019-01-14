package cn.com.zenmaster.aop.aspect;

import cn.com.zenmaster.zk.ZooKeeperSession;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: tianyu
 * @Date: 2019/1/14 17:13
 * @Description: 基于Zookeeper实现的分布式锁
 */
@Component
@Aspect
@Slf4j
public class ZookeeperDistrubuteLockAspect {

	@Resource
	private ZooKeeperSession zooKeeperSession;

	@Around(value = "execution(* cn.com.zenmaster..*.*(..)) && @annotation(cn.com.zenmaster.aop.annotation.ZookeeperDistrubuteLock) && args(name,..)")
	public Object process(ProceedingJoinPoint pjp, String name) throws Throwable {
		zooKeeperSession.lock(name);
		Object result = pjp.proceed();
		zooKeeperSession.unlock(name);
		return result;
	}

}
