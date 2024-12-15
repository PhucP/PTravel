package com.PTravel.DDD.application.service.user.impl;

import com.PTravel.DDD.application.dto.user.CreateUserDto;
import com.PTravel.DDD.application.dto.user.FindUserDto;
import com.PTravel.DDD.application.service.user.UserAppService;
import com.PTravel.DDD.domain.model.entity.User;
import com.PTravel.DDD.domain.model.valueobject.UserSearchCriteria;
import com.PTravel.DDD.domain.service.impl.UserDomainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public User createUser(CreateUserDto createUserDto) {
        //check for username and email
        if(userDomainService.existsByEmail(createUserDto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        if(userDomainService.existsByUsername(createUserDto.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        User newUser = new User();
        newUser.setUsername(createUserDto.getUsername());
        newUser.setEmail(createUserDto.getEmail());
        //hash password before save
        String newPassword = createUserDto.getPassword();
        newUser.setPassword(newPassword);
        return userDomainService.createUser(newUser);
    }

    @Override
    public Optional<User> findByInfo(FindUserDto findUserDto) {
        UserSearchCriteria criteria = new UserSearchCriteria.Builder()
                .username(findUserDto.getUsername())
                .email(findUserDto.getEmail())
                .phone(findUserDto.getPhone())
                .fullName(findUserDto.getFullName())
                .build();
        return userDomainService.findByInfo(criteria);
    }
}
