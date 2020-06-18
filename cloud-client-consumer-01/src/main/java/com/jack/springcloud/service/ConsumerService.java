package com.jack.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE")
public interface ConsumerService {

    @GetMapping("/feignMethod/{id}")
    public String feignMethod(@PathVariable("id") int id);
}
