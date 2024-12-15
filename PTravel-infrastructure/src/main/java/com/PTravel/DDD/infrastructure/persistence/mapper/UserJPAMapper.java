package com.PTravel.DDD.infrastructure.persistence.mapper;

import com.PTravel.DDD.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPAMapper extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
    User save(User user);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<User> findByConditions(String username, String email, String phone, String fullName);
}
