package double_p.ptravel.module.user.dto;

import lombok.Data;

@Data
public class UpdateUserDto {
    private String username;
    private String phone;
    private String fullName;
    private String email;
}
