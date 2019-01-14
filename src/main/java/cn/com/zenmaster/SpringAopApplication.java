package cn.com.zenmaster;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tianyu
 */
@Slf4j
@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Bean
	public JedisCluster JedisClusterFactory() {
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		jedisClusterNodes.add(new HostAndPort("192.168.0.131", 6379));
		jedisClusterNodes.add(new HostAndPort("192.168.0.132", 6379));
		jedisClusterNodes.add(new HostAndPort("192.168.0.133", 6379));
		jedisClusterNodes.add(new HostAndPort("192.168.0.134", 6379));
		jedisClusterNodes.add(new HostAndPort("192.168.0.135", 6379));
		jedisClusterNodes.add(new HostAndPort("192.168.0.136", 6379));
		JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes);
		return jedisCluster;
	}

}

