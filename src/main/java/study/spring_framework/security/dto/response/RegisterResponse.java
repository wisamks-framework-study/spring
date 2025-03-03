package study.spring_framework.security.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RegisterResponse {

    private Long id;

    @Builder
    public RegisterResponse(Long id) {
        this.id = id;
    }
}
