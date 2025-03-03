package study.spring_framework.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring_framework.security.dto.request.RegisterRequest;
import study.spring_framework.security.dto.response.RegisterResponse;
import study.spring_framework.security.mapper.SecurityDtoMapper;
import study.spring_framework.user.dto.response.CreateUserResponse;
import study.spring_framework.user.service.UserService;

@Service
@Transactional
@RequiredArgsConstructor
public class SecurityService {

    private final UserService userService;
    private final SecurityDtoMapper securityDtoMapper;

    public RegisterResponse registerUser(RegisterRequest dto) {
        CreateUserResponse result = userService.createUser(securityDtoMapper.toCreateUserRequest(dto));
        return securityDtoMapper.toRegisterResponse(result);
    }

    public void leaveUser(Long id) {
        userService.deleteUser(id);
    }
}
