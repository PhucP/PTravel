package double_p.ptravel.module.user.service;

import java.util.List;
import java.util.Optional;

import double_p.ptravel.module.user.dto.CreateUserDto;
import double_p.ptravel.module.user.dto.LoginUserDto;
import double_p.ptravel.module.user.dto.SearchUserDto;
import double_p.ptravel.module.user.dto.UpdateUserDto;
import double_p.ptravel.module.user.entity.User;

public interface IUserService {

    public Optional<User> findById(Long userId);

    public User create(CreateUserDto dto);

    public User update(Long userId, UpdateUserDto dto);

    public String remove(Long userId);

    public List<User> getAllUsers();

    public List<User> searchUser(SearchUserDto dto);

    public void login(LoginUserDto dto);
}
