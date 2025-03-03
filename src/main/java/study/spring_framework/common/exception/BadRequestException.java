package study.spring_framework.common.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ClientException {

    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
