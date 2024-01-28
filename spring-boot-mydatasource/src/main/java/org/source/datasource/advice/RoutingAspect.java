package org.source.datasource.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.source.datasource.annotation.RoutingWith;
import org.source.datasource.config.RoutingDataSourceContext;
import org.springframework.stereotype.Component;

/**
 * 动态路由切面
 *
 * @author Mr_wenpan@163.com 2022/04/05 17:00
 */
@Aspect
@Component
public class RoutingAspect {

	/**
	 * 为标注了 RoutingWith 注解的方法创建aop切面增强
	 */
	@Around("@annotation(routingWith)")
	public Object routingWithDataSource(ProceedingJoinPoint joinPoint,
										RoutingWith routingWith) throws Throwable {

		String lookUpKey = routingWith.value();
		RoutingDataSourceContext.setThreadLocal(lookUpKey);

		// 执行原方法
		return joinPoint.proceed();
	}
}
