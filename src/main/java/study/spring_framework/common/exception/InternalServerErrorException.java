package study.spring_framework.common.exception;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends ServerException {
    public InternalServerErrorException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
