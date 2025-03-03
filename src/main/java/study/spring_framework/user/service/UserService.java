package study.spring_framework.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring_framework.user.domain.User;
import study.spring_framework.user.domain.UserRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUserList() {
        return getUsers();
    }

    private User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }

    private List<User> getUsers() {
        return userRepository.findAll();
    }
}
