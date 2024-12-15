package com.PTravel.DDD.domain.service;

import com.PTravel.DDD.domain.model.entity.User;

import java.util.Optional;

public interface UserDomainService {
    Optional<User> findById(Long id);
    User createUser(User user);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
