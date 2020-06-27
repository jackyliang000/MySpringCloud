package com.jack.springcloud.controller;

import com.jack.springcloud.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("provider")
public class RedisController {

    private static final Logger logger=LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisService redisService;

    @GetMapping("redis/string/{key}/{value}")
    public String setKey(@PathVariable("key") String key,
                         @PathVariable("value") String value){
        redisService.setKey(key,value);
        logger.info("redis: set key-value success");
        return "redis: set key-value success";
    }

    @GetMapping("redis/decrement/{key}")
    public String setKey(@PathVariable("key") String key){
        long result=redisService.decrementKey(key);
        logger.info("decrement success!! key="+result);
        return "decrement success!! key="+result;
    }
}
