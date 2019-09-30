package com.ariclee.cache.annotation;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class RedisConfigure {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("172.17.1.32");
        factory.setPassword("2940184");
        factory.setPort(6379);
        factory.setTimeout(2000);
        factory.setUsePool(false);
        factory.setPoolConfig(new JedisPoolConfig());
        factory.setDatabase(1);
        factory.setConvertPipelineAndTxResults(false);
        return factory;
    }

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate temp = new RedisTemplate();
        temp.setConnectionFactory(this.jedisConnectionFactory());
        return temp;
    }
}
