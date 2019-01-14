package cn.com.zenmaster.aop.annotation;

import java.lang.annotation.*;

/**
 * @Author: tianyu
 * @Date: 2019/1/14 17:12
 * @Description:
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExceptionMonitor {
}
