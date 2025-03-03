package study.spring_framework.common.mapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import study.spring_framework.common.dto.ErrorResponse;
import study.spring_framework.common.exception.ClientException;

import java.time.LocalDateTime;
import java.util.Map;

@Component
public class ExceptionResponseMapper {

    public ResponseEntity<ErrorResponse> toResponseEntity(ClientException ex, String path) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(ex.getHttpStatus().value())
                .error(ex.getHttpStatus().getReasonPhrase())
                .message(ex.getMessage())
                .path(path)
                .build();
        return ResponseEntity.status(ex.getHttpStatus()).body(errorResponse);
    }

    public ResponseEntity<ErrorResponse> toResponseEntity(Map<String, String> errors, String path) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(errors.toString())
                .path(path)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
