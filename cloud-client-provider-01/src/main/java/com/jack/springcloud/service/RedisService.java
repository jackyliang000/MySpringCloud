package com.jack.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 默认过期时长，单位：秒
     */
    public static final long DEFAULT_EXPIRE = 60 * 60 * 24;

    /**
     * 不设置过期时长
     */
    public static final long NOT_EXPIRE = -1;

    public void setKey(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    public long decrementKey(String key){
        return redisTemplate.opsForValue().decrement(key);
    }
}
