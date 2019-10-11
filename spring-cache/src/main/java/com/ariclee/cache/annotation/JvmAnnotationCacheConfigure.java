package com.ariclee.cache.annotation;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;

//@Configuration
public class JvmAnnotationCacheConfigure implements CachingConfigurer {

    @Bean
    @Override
    public CacheManager cacheManager() {
        // 使用 JVM 内存
        return new ConcurrentMapCacheManager("books");
    }

    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
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
