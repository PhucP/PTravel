package com.PTravel.DDD.application.dto.user;

import lombok.Data;

@Data
public class UpdateUserDto {
    private String username;
    private String password;
    private String phone;
    private String fullName;
}
