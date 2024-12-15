package com.PTravel.DDD.domain.repository;

import com.PTravel.DDD.domain.model.entity.User;
import com.PTravel.DDD.domain.model.valueobject.UserSearchCriteria;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    User save(User user);
    Optional<User> findByInfo(UserSearchCriteria userSearchCriteria);
}
