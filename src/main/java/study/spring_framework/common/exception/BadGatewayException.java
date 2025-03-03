package study.spring_framework.common.exception;

import org.springframework.http.HttpStatus;

public class BadGatewayException extends ServerException {
    public BadGatewayException(String message) {
        super(HttpStatus.BAD_GATEWAY, message);
    }
}
