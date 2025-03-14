package study.spring_framework.security.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse registerUser(
            @Valid @RequestBody RegisterRequest dto
    ) {
        return securityService.registerUser(dto);
    }

    @DeleteMapping("/leave/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void leaveUser(
            @PathVariable("id") Long id
    ) {
        securityService.leaveUser(id);
    }
}
