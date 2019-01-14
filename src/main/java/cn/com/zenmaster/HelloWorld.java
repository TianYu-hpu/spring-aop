package cn.com.zenmaster;

import cn.com.zenmaster.aop.annotation.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: tianyu
 * @Date: 2019/1/14 16:36
 * @Description:
 */
@Controller
@ResponseBody
public class HelloWorld {

	//@Auth
	@Log
	@GetMapping("/hello")
	public Object hello() {
		return "hello";
	}

}
