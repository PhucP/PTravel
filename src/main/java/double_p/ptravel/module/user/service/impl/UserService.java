package double_p.ptravel.module.user.service.impl;

import double_p.ptravel.module.user.dto.CreateUserDto;
import double_p.ptravel.module.user.dto.LoginUserDto;
import double_p.ptravel.module.user.dto.SearchUserDto;
import double_p.ptravel.module.user.dto.UpdateUserDto;
import double_p.ptravel.module.user.entity.User;
import double_p.ptravel.module.user.repository.IUserRepository;
import double_p.ptravel.module.user.service.IUserService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(Long userId) {
        return  userRepository.findById(userId);
    }

    @Override
    public User create(CreateUserDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setUsername(dto.getUserName());

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(Long userId, UpdateUserDto dto) {
        User user = userRepository.findById(userId).orElse(null);
        //check if author is current user
        if(user != null) {
            user.setEmail(dto.getEmail());
            user.setPhone(dto.getPhone());
            user.setFullName(dto.getFullName());
            user.setEmail(dto.getEmail());

            return userRepository.save(user);
        }
        return null;
    }
    
    @Override
    public String remove(Long userId) {
        userRepository.deleteById(userId);
        return "User with id " + userId + " has been deleted";
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> searchUser(SearchUserDto dto, Pageable pageable) {
       return userRepository.searchUser(dto, pageable);
    }

    @Override
    public void login(LoginUserDto dto) {
        //login
    }
}
