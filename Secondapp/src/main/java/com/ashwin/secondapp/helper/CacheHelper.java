package com.ashwin.secondapp.helper;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

public class CacheHelper {

    private CacheManager cacheManager;
    private Cache<Integer, Integer> squareNumberCache;

    public CacheHelper() {
        cacheManager = CacheManagerBuilder
                .newCacheManagerBuilder().build();
        cacheManager.init();

        squareNumberCache = cacheManager
                .createCache("squaredNumber", CacheConfigurationBuilder
                        .newCacheConfigurationBuilder(
                                Integer.class, Integer.class,
                                ResourcePoolsBuilder.heap(10)));
        System.out.println("cache has been started");


    }

    public Cache<Integer, Integer> getSquareNumberCacheFromCacheManager() {
        return cacheManager.getCache("squaredNumber", Integer.class, Integer.class);
    }

    public CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public Cache<Integer, Integer> getSquareNumberCache() {
        return squareNumberCache;
    }

    public void setSquareNumberCache(Cache<Integer, Integer> squareNumberCache) {
        this.squareNumberCache = squareNumberCache;
    }
}
