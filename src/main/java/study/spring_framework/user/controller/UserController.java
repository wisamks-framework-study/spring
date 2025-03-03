package study.spring_framework.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.spring_framework.user.dto.request.UpdateUserRequest;
import study.spring_framework.user.dto.response.UserListResponse;
import study.spring_framework.user.dto.response.UserResponse;
import study.spring_framework.user.service.UserService;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserResponse getUserInfo(
            @PathVariable("id") Long id
    ) {
        return userService.getUserInfo(id);
    }

    @GetMapping({"", "/"})
    public UserListResponse getUserList() {
        return userService.getUserList();
    }

    @PutMapping("/{id}")
    public void updateUserInfo(
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdateUserRequest dto
    ) {
        userService.updateUserInfo(dto, id);
    }
}
