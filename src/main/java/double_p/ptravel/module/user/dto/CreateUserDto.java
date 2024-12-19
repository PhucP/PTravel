package double_p.ptravel.module.user.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateUserDto {
    @NonNull
    private String userName;

    @NonNull
    private String email;

    @NonNull
    public String password;
}
