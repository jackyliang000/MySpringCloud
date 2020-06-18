package com.jack.springcloud.controller;

import com.jack.springcloud.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/method1/{id}")
    public String provideMethod1(@PathVariable("id") int id){
        return "port: "+port+","+providerService.provideMethod(id);
    }

    @GetMapping("/feignMethod/{id}")
    public String feignMethod(@PathVariable("id") int id){
        return "this is a feignMethod! port: "+port+","+providerService.provideMethod(id);
    }
}
