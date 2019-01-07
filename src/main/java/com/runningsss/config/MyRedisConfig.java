package com.runningsss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * @author liqings
 * @date 2018-12-04
 */
@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, Object> myRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        GenericJackson2JsonRedisSerializer ser = new GenericJackson2JsonRedisSerializer();
        template.setDefaultSerializer(ser);
        return template;
    }

    @Bean
    public RedisCacheManager myCacheManager(RedisTemplate<Object, Object> myRedisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(myRedisTemplate);
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }
}
