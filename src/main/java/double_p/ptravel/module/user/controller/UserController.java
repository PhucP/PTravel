package double_p.ptravel.module.user.controller;

import double_p.ptravel.module.user.dto.CreateUserDto;
import double_p.ptravel.module.user.dto.LoginUserDto;
import double_p.ptravel.module.user.dto.SearchUserDto;
import double_p.ptravel.module.user.dto.UpdateUserDto;
import double_p.ptravel.module.user.entity.User;
import double_p.ptravel.module.user.service.IUserService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public Optional<User> findById(@PathVariable("userId") Long userId) {
        return userService.findById(userId);
    }

    @PostMapping("/register")
    public User register(@RequestBody CreateUserDto dto) {
        return userService.create(dto);
    }

     @PatchMapping("/update/{userId}")
     public User update(
             @PathVariable("userId") Long userId,
             @RequestBody UpdateUserDto dto) {
         return userService.update(userId, dto);
     }

     @DeleteMapping("/delete/{userId}")
     public String remove(@PathVariable("userId") Long userId) {
         return userService.remove(userId);
     }

     @GetMapping("/all")
     public List<User> getAllUser() {
         return userService.getAllUsers();
     }
     
     @GetMapping("/search")
     public List<User> getMethodName(@RequestBody SearchUserDto dto) {
         return userService.searchUser(dto);
     }

     @PostMapping("/login")
     public void login(@RequestBody LoginUserDto dto) {
         userService.login(dto);
     }
     
}
