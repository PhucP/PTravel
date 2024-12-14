package com.PTravel.DDD.domain.repository;

import com.PTravel.DDD.domain.model.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
}
