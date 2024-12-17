package double_p.ptravel.module.user.service;

import double_p.ptravel.module.user.dto.CreateUserDto;
import double_p.ptravel.module.user.dto.UpdateUserDto;
import double_p.ptravel.module.user.entity.User;
import double_p.ptravel.module.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<User> findById(Long userId) {
        return  userRepository.findById(userId);
    }

    public User create(CreateUserDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setUsername(dto.getUserName());

        return userRepository.save(user);
    }

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
}
