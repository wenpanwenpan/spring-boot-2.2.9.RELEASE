package org.source.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * druid连接池配置
 *
 * @author Mr_wenpan@163.com 2022/04/04 20:17
 */
//@Configuration
public class DruidConfig {

	/**
	 * 将配置文件中以spring.datasource为前缀的属性值绑定到DruidDataSource中
	 */
	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	public DataSource dataSource(){
		return new DruidDataSource();
	}
}
