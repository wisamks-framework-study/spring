package study.spring_framework.security.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @DeleteMapping("/leave/{id}")
    public void leaveUser(
            @PathVariable("id") Long id
    ) {
        securityService.leaveUser(id);
    }
}
