package study.spring_framework.security.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RegisterRequest {
    @NotNull(message = "email은 필수값입니다.")
    @Email(message = "email 형식에 맞지 않습니다.")
    private String email;

    @NotNull(message = "password는 필수값입니다.")
    @Size(min = 4, max = 20, message = "password는 4~20글자입니다.")
    private String password;
}
