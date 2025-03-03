package study.spring_framework.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring_framework.user.domain.User;
import study.spring_framework.user.domain.UserRepository;
import study.spring_framework.user.dto.request.CreateUserRequest;
import study.spring_framework.user.dto.response.UserListResponse;
import study.spring_framework.user.dto.response.UserResponse;
import study.spring_framework.user.mapper.UserEntityMapper;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserResponse getUserInfo(Long id) {
        return userEntityMapper.toUserResponse(getUser(id));
    }

    public UserListResponse getUserList() {
        return userEntityMapper.toUserListResponse(getUsers());
    }

    public UserResponse createUser(CreateUserRequest dto) {
        User user = userEntityMapper.toUser(dto);
        userRepository.save(user);
        return userEntityMapper.toUserResponse(user);
    }

    private User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }

    private List<User> getUsers() {
        return userRepository.findAll();
    }
}
