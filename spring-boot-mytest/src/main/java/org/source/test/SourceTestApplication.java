package org.source.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;

/**
 * spring boot源码测试主启动类
 *
 * @author wenpan 2022/4/2 5:36 PM
 */
@SpringBootApplication(exclude = FreeMarkerAutoConfiguration.class)
public class SourceTestApplication {

	public static void main(String[] args) {
		 SpringApplication.run(SourceTestApplication.class, args);
	}
}
