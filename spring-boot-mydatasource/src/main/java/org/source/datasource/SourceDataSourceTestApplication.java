package org.source.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 数据源源码测试
 *
 * @author Mr_wenpan@163.com 2022/04/04 19:01
 */
@MapperScan("org.source.datasource.mapper")
// 排除spring-boot-starter-jdbc的自动配置类
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
public class SourceDataSourceTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SourceDataSourceTestApplication.class, args);
	}
}
