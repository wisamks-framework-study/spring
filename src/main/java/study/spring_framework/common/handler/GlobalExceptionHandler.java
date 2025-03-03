package study.spring_framework.common.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import study.spring_framework.common.dto.ErrorResponse;
import study.spring_framework.common.exception.ClientException;
import study.spring_framework.common.mapper.ExceptionResponseMapper;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private final ExceptionResponseMapper exceptionResponseMapper;

    @ExceptionHandler(ClientException.class)
    public ResponseEntity<ErrorResponse> handleClientException(ClientException ex, HttpServletRequest request) {
        logger.warn("클라이언트 에러 발생: {}", ex.getMessage());
        return exceptionResponseMapper.toResponseEntity(ex, request.getRequestURI());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Map<String, String> errors = new HashMap<>();
        for (FieldError error: fieldErrors) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        logger.warn("유효성 검증 에러 발생: {}", errors);
        return exceptionResponseMapper.toResponseEntity(errors, request.getRequestURI());
    }
}
