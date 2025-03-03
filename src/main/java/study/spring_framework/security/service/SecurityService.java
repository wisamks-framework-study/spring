package study.spring_framework.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring_framework.user.service.UserService;

@Service
@Transactional
@RequiredArgsConstructor
public class SecurityService {

    private final UserService userService;
}
