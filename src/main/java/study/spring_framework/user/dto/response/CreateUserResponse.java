package study.spring_framework.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CreateUserResponse {

    private Long id;

    @Builder
    public CreateUserResponse(Long id) {
        this.id = id;
    }
}
