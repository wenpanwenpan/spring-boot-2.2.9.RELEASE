package org.source.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 自定义缓存启动类
 *
 * @author Mr_wenpan@163.com 2022/04/06 11:20
 */
@EnableCaching
@MapperScan("org.source.cache.mapper")
@SpringBootApplication
public class MyCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCacheApplication.class, args);
	}
}
