package study.spring_framework.common.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends ClientException {

    public ForbiddenException(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }
}
