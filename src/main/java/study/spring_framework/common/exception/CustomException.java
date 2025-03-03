package study.spring_framework.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
abstract public class CustomException extends RuntimeException {

    private HttpStatus httpStatus;

    public CustomException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
