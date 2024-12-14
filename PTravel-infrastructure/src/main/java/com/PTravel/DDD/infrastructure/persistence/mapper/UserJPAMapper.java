package com.PTravel.DDD.infrastructure.persistence.mapper;

import com.PTravel.DDD.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPAMapper extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
}
