package com.jack.springcloud.service.impl;

import com.jack.springcloud.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class HystrixServiceImpl implements HystrixService {


    @Override
    public String normalMethod(Integer id) {
        return "线程: "+Thread.currentThread().getName()+",   id:"+id+", normal method success!! ";
    }

    @Override
    public String errorMethod() {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "sleepFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String sleepMethod(Integer id) {
        int millis=3000;
        try {
            Thread.sleep(millis);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程: "+Thread.currentThread().getName()+",   id:"+id+", sleep method success!! 耗时"+millis+"ms";
    }

    public String sleepFallbackMethod(Integer id){
        return "线程: "+Thread.currentThread().getName()+",   id:"+id+", sleep method failure!!! fallback";
    }
}
