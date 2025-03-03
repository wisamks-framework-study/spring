package study.spring_framework.user.exception;

import study.spring_framework.common.exception.ConflictException;

public class UserEmailConflictException extends ConflictException {

    public UserEmailConflictException(String email) {
        super("중복된 이메일입니다. email: [" + email + "]");
    }
}
