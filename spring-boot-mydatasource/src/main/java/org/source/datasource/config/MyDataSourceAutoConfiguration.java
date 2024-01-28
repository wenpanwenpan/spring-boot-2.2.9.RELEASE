package org.source.datasource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义多数据源自动配置
 *
 * @author Mr_wenpan@163.com 2022/04/05 16:23
 */
@Configuration
public class MyDataSourceAutoConfiguration {

	/**
	 * master数据源
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.druid.datasource.master")
	public DataSource masterDataSource(){

		return DataSourceBuilder.create().build();
	}

	/**
	 * slave数据源
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.druid.datasource.slave")
	public DataSource slaveDataSource(){

		return DataSourceBuilder.create().build();
	}

	/**
	 * 主数据源
	 */
	@Bean
	@Primary
	public DataSource primaryDataSource(@Autowired @Qualifier("masterDataSource") DataSource masterDataSource,
										@Autowired @Qualifier("slaveDataSource") DataSource slaveDataSource){
		RoutingDataSource routingDataSource = new RoutingDataSource();
		Map<Object, Object> map = new HashMap<>();
		map.put("master",masterDataSource);
		map.put("slave",slaveDataSource);
		routingDataSource.setTargetDataSources(map);

		return routingDataSource;
	}

}
