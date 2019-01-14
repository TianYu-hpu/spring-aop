package cn.com.zenmaster.service;

/**
 * @Author: tianyu
 * @Date: 2019/1/14 21:15
 * @Description:
 */
public interface LockService {

	/**
	 * 加锁 (Redis挂掉降级为加锁成功)
	 *
	 * @param key 锁的 key
	 * @return 锁
	 */
	void lock(String key);

	/**
	 * 加锁, 指定失效时间 (Redis挂掉降级为加锁成功)
	 *
	 * @param key     锁的 key
	 * @param seconds 有效秒数
	 * @return 锁
	 */
	void lock(String key, int seconds);

	/**
	 * 解锁 (Redis挂掉降级为解锁成功)
	 *
	 * @param key 锁的 key
	 * @return true - 成功; false - 锁不存在
	 */
	boolean unlock(String key);

}
