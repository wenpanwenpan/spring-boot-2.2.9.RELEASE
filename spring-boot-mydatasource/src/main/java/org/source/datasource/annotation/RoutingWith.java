package org.source.datasource.annotation;

import java.lang.annotation.*;

/**
 * 动态路由注解
 *
 * @author Mr_wenpan@163.com 2022/04/05 16:57
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RoutingWith {

	String value() ;
}
