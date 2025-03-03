package study.spring_framework.common.exception;

import org.springframework.http.HttpStatus;

public class ClientException extends CustomException {

    public ClientException(HttpStatus httpStatus, String message) {
        super(httpStatus, message);
    }
}
