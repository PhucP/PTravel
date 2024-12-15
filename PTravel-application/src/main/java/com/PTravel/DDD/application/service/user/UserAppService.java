package com.PTravel.DDD.application.service.user;

import com.PTravel.DDD.application.dto.user.CreateUserDto;
import com.PTravel.DDD.domain.model.entity.User;

import java.util.Optional;

public interface UserAppService {
    Optional<User> findById(Long id);
    User createUser(CreateUserDto createUserDto);
    Optional<User> findByInfo(String username);
}
