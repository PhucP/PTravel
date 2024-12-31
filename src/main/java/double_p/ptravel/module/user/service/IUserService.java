package double_p.ptravel.module.user.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import double_p.ptravel.module.user.dto.CreateUserDto;
import double_p.ptravel.module.user.dto.SearchUserDto;
import double_p.ptravel.module.user.dto.UpdateUserDto;
import double_p.ptravel.module.user.entity.User;

public interface IUserService {

    public Optional<User> findById(Long userId);

    public User findByEmail(String email);

    public User create(CreateUserDto dto);

    public User update(Long userId, UpdateUserDto dto);

    public String remove(Long userId);

    public Page<User> findAll(Pageable pageable);

    public Page<User> searchUser(SearchUserDto dto, Pageable pageable);
}
