package study.spring_framework.common.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends ClientException {
    public ConflictException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}
