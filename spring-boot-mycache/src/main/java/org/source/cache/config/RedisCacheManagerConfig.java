package org.source.cache.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * Redis缓存管理器配置类
 *
 * @author Mr_wenpan@163.com 2022/04/06 18:01
 */
@Configuration
public class RedisCacheManagerConfig {

	@Bean
	public RedisCacheManager createManager(RedisConnectionFactory redisConnectionFactory){

		// 分别创建key和value的序列化器
		StringRedisSerializer keySerializer = new StringRedisSerializer();
		Jackson2JsonRedisSerializer<Object> valueSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);

		// 解决查询缓存转换异常的问题
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		valueSerializer.setObjectMapper(objectMapper);

		// 定制缓存数据 序列化方式 及 时效
		RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofDays(1))
				.serializeKeysWith(RedisSerializationContext
						.SerializationPair
						.fromSerializer(keySerializer))
				.serializeValuesWith(RedisSerializationContext
						.SerializationPair
						.fromSerializer(valueSerializer))
				.disableCachingNullValues();
		return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(config).build();
	}

}
