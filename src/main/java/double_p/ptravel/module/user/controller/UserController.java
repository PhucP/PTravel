package double_p.ptravel.module.user.controller;

import double_p.ptravel.module.user.dto.CreateUserDto;
import double_p.ptravel.module.user.dto.UpdateUserDto;
import double_p.ptravel.module.user.entity.User;
import double_p.ptravel.module.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
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
}
