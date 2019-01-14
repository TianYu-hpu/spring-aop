package cn.com.zenmaster;

import cn.com.zenmaster.aop.annotation.Auth;
import cn.com.zenmaster.aop.annotation.ExceptionMonitor;
import cn.com.zenmaster.aop.annotation.Log;
import cn.com.zenmaster.aop.annotation.Timer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @Author: tianyu
 * @Date: 2019/1/14 16:36
 * @Description:
 */
@Controller
@ResponseBody
public class HelloWorldController {

	@Timer
	@ExceptionMonitor
	@Auth
	@Log
	@GetMapping("/hello")
	public Object hello(String name) throws InterruptedException {
		//这里进行一系列复杂的操作
		Random random = new Random(1000);
		Thread.sleep(random.nextInt(500));
		return "hello" + name;
	}
}
