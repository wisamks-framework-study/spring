package study.spring_framework.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.spring_framework.user.domain.User;

import java.util.List;

@NoArgsConstructor
@Getter
public class UserListResponse {

    private List<User> users;

    @Builder
    public UserListResponse(List<User> users) {
        this.users = users;
    }
}
