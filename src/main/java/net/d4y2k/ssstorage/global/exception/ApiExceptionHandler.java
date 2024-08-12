package net.d4y2k.ssstorage.global.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiExceptionResponse> handleApiException(ApiException exception) {
        ErrorType errorType = exception.getErrorType();
        ApiExceptionResponse response = new ApiExceptionResponse(
                errorType.getHttpStatus().value(),
                errorType.getHttpStatus().getReasonPhrase(),
                exception.getMessage()
        );

        return ResponseEntity.status(response.getCode()).body(response);
    }

}
