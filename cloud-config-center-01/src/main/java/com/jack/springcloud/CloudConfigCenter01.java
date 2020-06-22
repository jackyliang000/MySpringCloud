package com.jack.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudConfigCenter01 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigCenter01.class,args);
    }
}
