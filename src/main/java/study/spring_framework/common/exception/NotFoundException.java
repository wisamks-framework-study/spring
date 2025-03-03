package study.spring_framework.common.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ClientException {

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
