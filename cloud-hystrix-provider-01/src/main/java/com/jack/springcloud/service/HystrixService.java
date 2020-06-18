package com.jack.springcloud.service;

public interface HystrixService {

    public String normalMethod(Integer id);

    public String errorMethod();

    public String sleepMethod(Integer id);

}
