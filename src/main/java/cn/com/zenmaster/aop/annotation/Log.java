package cn.com.zenmaster.aop.annotation;

import java.lang.annotation.*;

/**
 * @Author: tianyu
 * @Date: 2019/1/14 16:23
 * @Description:  权限验证
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
}
