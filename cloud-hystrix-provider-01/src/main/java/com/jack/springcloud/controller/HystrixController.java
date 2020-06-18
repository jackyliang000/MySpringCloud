package com.jack.springcloud.controller;

import com.jack.springcloud.service.HystrixCommandTest;
import com.jack.springcloud.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("provider")
public class HystrixController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private HystrixService hystrixService;

    @GetMapping("/hystrix/normal/{id}")
    public String normalMethod(@PathVariable("id") Integer id){
        String result=hystrixService.normalMethod(id);
        System.out.println("result:"+result);
        return result;
    }

    @GetMapping("/hystrix/sleep/{id}")
    public String sleepMethod(@PathVariable("id") Integer id){
        String result=hystrixService.sleepMethod(id);
        System.out.println("result:"+result);
        return result;
    }

    @GetMapping("/hystrix/command/{name}")
    public String hystrixCommandMethod(@PathVariable("name") String name){
        String result=new HystrixCommandTest(name).execute();
        return result;
    }
}
