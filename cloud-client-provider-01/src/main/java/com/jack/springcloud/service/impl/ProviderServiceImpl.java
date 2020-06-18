package com.jack.springcloud.service.impl;

import com.jack.springcloud.service.ProviderService;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String provideMethod(int id) {
        return "result: "+id;
    }
}
