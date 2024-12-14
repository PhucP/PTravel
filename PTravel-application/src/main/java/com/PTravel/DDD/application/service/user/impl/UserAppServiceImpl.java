package com.PTravel.DDD.application.service.user.impl;

import com.PTravel.DDD.application.service.user.UserAppService;
import com.PTravel.DDD.domain.model.entity.User;
import com.PTravel.DDD.domain.service.impl.UserDomainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserAppServiceImpl implements UserAppService {
    private final UserDomainServiceImpl userDomainService;

    public UserAppServiceImpl(UserDomainServiceImpl userDomainService) {
        this.userDomainService = userDomainService;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDomainService.findById(id);
    }
}
