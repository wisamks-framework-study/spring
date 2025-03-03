package study.spring_framework.user.mapper;

import org.springframework.stereotype.Component;
import study.spring_framework.user.domain.User;
import study.spring_framework.user.dto.request.CreateUserRequest;
import study.spring_framework.user.dto.response.CreateUserResponse;
import study.spring_framework.user.dto.response.UserListResponse;
import study.spring_framework.user.dto.response.UserResponse;

import java.util.List;

@Component
public class UserEntityMapper {

    public User toUser(CreateUserRequest dto) {
        return User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }

    public UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public UserListResponse toUserListResponse(List<User> users) {
        return UserListResponse.builder()
                .users(users.stream().map(this::toUserResponse).toList())
                .build();
    }

    public CreateUserResponse toCreateUserResponse(User user) {
        return CreateUserResponse.builder()
                .id(user.getId())
                .build();
    }
}
