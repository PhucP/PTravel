package com.PTravel.DDD.application.dto.user;

import lombok.Data;

@Data
public class FindUserDto {
    private String username;
    private String email;
    private String phone;
    private String fullName;
}
