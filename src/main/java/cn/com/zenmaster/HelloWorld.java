package cn.com.zenmaster;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: tianyu
 * @Date: 2019/1/14 16:36
 * @Description:
 */
@Controller
public class HelloWorld {

	@Log
	@GetMapping("/hello")
	public Object hello() {
		return "hello";
	}
}
