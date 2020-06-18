package com.jack.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudServer02Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudServer02Application.class,args);
    }
}
