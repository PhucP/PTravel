package com.PTravel.DDD.infrastructure.persistence.repository;

import com.PTravel.DDD.domain.model.entity.User;
import com.PTravel.DDD.domain.model.valueobject.UserSearchCriteria;
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

    @Override
    public boolean existsByUsername(String username) {
        return userJPAMapper.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userJPAMapper.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        return userJPAMapper.save(user);
    }

    @Override
    public Optional<User> findByInfo(UserSearchCriteria userSearchCriteria) {
        return userJPAMapper.findByConditions(
                userSearchCriteria.getUsername(),
                userSearchCriteria.getEmail(),
                userSearchCriteria.getPhone(),
                userSearchCriteria.getFullName()
        );
    }
}
