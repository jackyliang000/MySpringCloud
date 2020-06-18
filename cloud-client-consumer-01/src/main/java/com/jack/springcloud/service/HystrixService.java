package com.jack.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-01")
public interface HystrixService {

    @GetMapping("/hystrix/normal/{id}")
    public String normalMethod(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/sleep/{id}")
    public String sleepMethod(@PathVariable("id") Integer id);
}
