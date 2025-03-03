package study.spring_framework.common.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ClientException {

    public UnauthorizedException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
