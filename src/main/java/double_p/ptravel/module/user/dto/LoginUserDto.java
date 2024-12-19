package double_p.ptravel.module.user.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class LoginUserDto {
    @NonNull
    private String email;

    @NonNull
    private String password;
}
