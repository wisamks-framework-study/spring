package study.spring_framework.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring_framework.user.domain.User;
import study.spring_framework.user.domain.UserRepository;
import study.spring_framework.user.dto.request.CreateUserRequest;
import study.spring_framework.user.dto.request.UpdateUserRequest;
import study.spring_framework.user.dto.response.CreateUserResponse;
import study.spring_framework.user.dto.response.UserListResponse;
import study.spring_framework.user.dto.response.UserResponse;
import study.spring_framework.user.exception.UserEmailConflictException;
import study.spring_framework.user.exception.UserNotFoundException;
import study.spring_framework.user.mapper.UserEntityMapper;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponse getUserInfo(Long id) {
        return userEntityMapper.toUserResponse(getUser(id));
    }

    public UserListResponse getUserList() {
        return userEntityMapper.toUserListResponse(getUsers());
    }

    public CreateUserResponse createUser(CreateUserRequest dto) {
        checkDuplicateEmail(dto.getEmail());
        User user = userEntityMapper.toUser(dto, passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
        return userEntityMapper.toCreateUserResponse(user);
    }

    public void updateUserInfo(UpdateUserRequest dto, Long id) {
        User user = getUser(id);
        if (dto.getEmail() != null) {
            checkDuplicateEmail(dto.getEmail());
            user.updateEmail(dto.getEmail());
        }
        if (dto.getPassword() != null) {
            user.updatePassword(passwordEncoder.encode(dto.getPassword()));
        }
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = getUser(id);
        user.delete();
        userRepository.save(user);
    }

    private User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    private List<User> getUsers() {
        return userRepository.findAll();
    }

    private void checkDuplicateEmail(String email) {
        userRepository.findByEmail(email)
                .ifPresent(_ -> {
                    throw new UserEmailConflictException(email);
                });
    }
}
