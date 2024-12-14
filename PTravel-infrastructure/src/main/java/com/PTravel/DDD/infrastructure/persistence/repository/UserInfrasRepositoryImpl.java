package com.PTravel.DDD.infrastructure.persistence.repository;

import com.PTravel.DDD.domain.model.entity.User;
import com.PTravel.DDD.domain.repository.UserRepository;
import com.PTravel.DDD.infrastructure.persistence.mapper.UserJPAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfrasRepositoryImpl implements UserRepository {
    private final UserJPAMapper userJPAMapper;

    public UserInfrasRepositoryImpl(UserJPAMapper userJPAMapper) {
        this.userJPAMapper = userJPAMapper;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userJPAMapper.findById(id);
    }
}
