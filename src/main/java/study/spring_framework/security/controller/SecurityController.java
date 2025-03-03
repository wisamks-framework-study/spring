package study.spring_framework.security.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.spring_framework.security.dto.request.RegisterRequest;
import study.spring_framework.security.dto.response.RegisterResponse;
import study.spring_framework.security.service.SecurityService;

@RestController
@RequestMapping("/api/security")
@RequiredArgsConstructor
public class SecurityController {

    private final SecurityService securityService;

    @PostMapping("/register")
    public RegisterResponse registerUser(
            @Valid @RequestBody RegisterRequest dto
    ) {
        return securityService.registerUser(dto);
    }
}
