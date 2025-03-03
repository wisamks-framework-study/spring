package study.spring_framework.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class UserListResponse {

    private List<UserResponse> users;

    @Builder
    public UserListResponse(List<UserResponse> users) {
        this.users = users;
    }
}
