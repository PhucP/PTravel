package com.PTravel.DDD.domain.service.impl;

import com.PTravel.DDD.domain.model.entity.User;
import com.PTravel.DDD.domain.repository.UserRepository;
import com.PTravel.DDD.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDomainServiceImpl implements UserDomainService {
    private final UserRepository userRepository;

    public UserDomainServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
