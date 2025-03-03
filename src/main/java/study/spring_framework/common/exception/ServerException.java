package study.spring_framework.common.exception;

import org.springframework.http.HttpStatus;

public class ServerException extends CustomException {

    public ServerException(HttpStatus httpStatus, String message) {
        super(httpStatus, message);
    }
}
