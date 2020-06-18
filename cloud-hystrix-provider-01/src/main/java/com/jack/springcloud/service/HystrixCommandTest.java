package com.jack.springcloud.service;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class HystrixCommandTest extends HystrixCommand<String> {

    private final String name;

    public HystrixCommandTest(String name){
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        Thread.sleep(3000);
        return "hello, "+name;
    }

    @Override
    protected String getFallback() {
        return "failure, "+name;
    }
}
