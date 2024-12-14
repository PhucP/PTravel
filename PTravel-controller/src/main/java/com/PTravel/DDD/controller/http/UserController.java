package com.PTravel.DDD.controller.http;

import com.PTravel.DDD.application.service.user.UserAppService;
import com.PTravel.DDD.domain.model.entity.User;
import com.PTravel.DDD.domain.model.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserAppService userAppService;

    public UserController(UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    @GetMapping("/{userId}")
    public User findUserById(@PathVariable("userId") Long userId) {
        return userAppService.findById(userId).orElse(null);
    }
}
