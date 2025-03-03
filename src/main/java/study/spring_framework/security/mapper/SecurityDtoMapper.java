package study.spring_framework.security.mapper;

import org.springframework.stereotype.Component;
import study.spring_framework.security.dto.request.RegisterRequest;
import study.spring_framework.user.dto.request.CreateUserRequest;
import study.spring_framework.user.dto.response.CreateUserResponse;

@Component
public class SecurityDtoMapper {

    public CreateUserRequest toCreateUserRequest(RegisterRequest dto) {
        return CreateUserRequest.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }
}
