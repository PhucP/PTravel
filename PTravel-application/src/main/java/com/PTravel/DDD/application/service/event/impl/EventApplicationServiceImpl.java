package com.PTravel.DDD.application.service.event.impl;

import com.PTravel.DDD.application.service.event.EventAppService;
import com.PTravel.DDD.domain.service.HiDomainService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class EventApplicationServiceImpl implements EventAppService {
    @Resource
    private HiDomainService hiDomainService;
    @Override
    public String sayHi(String who) {
        return hiDomainService.sayHi(who);
    }
}
