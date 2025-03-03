package study.spring_framework.common.mapper;

import org.springframework.http.ResponseEntity;
import study.spring_framework.common.dto.ErrorResponse;
import study.spring_framework.common.exception.ClientException;

import java.time.LocalDateTime;

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
}
