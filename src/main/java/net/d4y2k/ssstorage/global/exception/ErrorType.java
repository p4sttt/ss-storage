package net.d4y2k.ssstorage.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {

//    <-------------------------COMMON ERRORS------------------------->
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "Validation Error"),

//    <-------------------------FILE ERROR------------------------->
    EMPTY_FILE(HttpStatus.BAD_REQUEST, "Empty File Error"),
    FILE_NOT_IMAGE(HttpStatus.BAD_REQUEST, "File Not Image"),
    IMAGE_NOT_FOUND(HttpStatus.BAD_REQUEST, "Image Not Found"),
    FAILED_UPLOAD_FILE(HttpStatus.INTERNAL_SERVER_ERROR, "Failed Upload File"),
    FAILED_GET_FILE(HttpStatus.INTERNAL_SERVER_ERROR, "Failed Get File"),
    ;

    private final HttpStatus httpStatus;
    private final String message;

    ErrorType(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

}
