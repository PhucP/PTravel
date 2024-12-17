package double_p.ptravel.module.user.dto;

import lombok.Data;

@Data
public class CreateUserDto {
    private String userName;
    private String email;
    public String password;
}
