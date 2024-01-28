package org.source.datasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

/**
 * 多数据源路由
 *
 * @author Mr_wenpan@163.com 2022/04/05 16:27
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {

		return RoutingDataSourceContext.getDataSourceRoutingKey();
	}
}
