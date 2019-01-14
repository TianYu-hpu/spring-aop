package cn.com.zenmaster;

import java.lang.annotation.*;

/**
 * @Author: tianyu
 * @Date: 2019/1/14 16:23
 * @Description:
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
}
