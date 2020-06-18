package com.jack.springcloud.controller;

import com.jack.springcloud.service.ConsumerService;
import com.jack.springcloud.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("consumer")
public class ConsumerController {

    private static final String Provider_Url="http://CLOUD-PROVIDER-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ConsumerService consumerService;

    @Resource
    private HystrixService hystrixService;

    @GetMapping("/method1/{id}")
    public String method1(@PathVariable("id") int id){
       return restTemplate.getForObject(Provider_Url+"/provider/method1/"+id,String.class);
    }

    @GetMapping("/feignMethod/{id}")
    public String feignMethod(@PathVariable("id") int id){
        return consumerService.feignMethod(id);
    }

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

}
