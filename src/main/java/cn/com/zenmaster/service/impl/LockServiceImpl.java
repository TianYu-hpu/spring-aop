package cn.com.zenmaster.service.impl;

import cn.com.zenmaster.service.LockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;

/**
 * @Author: tianyu
 * @Date: 2019/1/14 21:16
 * @Description:
 */
@Service
@Slf4j
public class LockServiceImpl implements LockService {

	@Resource
	private JedisCluster jedisCluster;


	private static final String LOCK_CATEGORY = "distribute_lock";
	private static final Integer DEFAULT_TIMEOUT_SECONDS = 300;

	@Override
	public void lock(String key) {
		 lock(key, DEFAULT_TIMEOUT_SECONDS);
	}

	@Override
	public void lock(String key, int seconds) {
		try {
			if (jedisCluster.setnx(LOCK_CATEGORY + key, "") > 0) {
				log.info("加锁成功,key:{}", key);
			} else {
				log.info("加锁失败,key:{}", key);
			}
		} catch (Exception e) {
			/**
			 * Redis失败锁降级
			 */
			log.error("REDIS连接失败，加锁降级。key:{}", key, e);
		}
	}

	@Override
	public boolean unlock(String key) {
		try {
			if (jedisCluster.del(LOCK_CATEGORY + key) > 0) {
				log.info("解锁成功,key:{}", key);
				return true;
			} else {
				log.error("Redis锁超时,key:{}", key);
			}
		} catch (Exception e) {
			log.error("REDIS连接失败，解锁降级。key:{}", key, e);
		}
		return true;
	}

}
