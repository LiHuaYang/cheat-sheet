package com.ariclee.cache.annotation;

import com.ariclee.cache.xml.CustomKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collections;

@EnableCaching
@Configuration
public class AnnotationCacheConfigure implements CachingConfigurer {

    @Autowired
    RedisTemplate redisTemplate;

    @Bean
    @Override
    public CacheManager cacheManager() {
        // 使用 JVM 内存
//        return new ConcurrentMapCacheManager("books");
        // 使用 Redis
        RedisCacheManager manager = new RedisCacheManager(redisTemplate, Collections.singletonList("books"));
        manager.setUsePrefix(true);
        return manager;
    }

    @Override
    public KeyGenerator keyGenerator() {
//        return new SimpleKeyGenerator();
        return new CustomKeyGenerator();
    }

    @Override
    public CacheResolver cacheResolver() {
        return null;
    }
    @Override
    public CacheErrorHandler errorHandler() {
        return null;
    }
}
