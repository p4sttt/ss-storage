package net.d4y2k.ssstorage.global.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private final ErrorType errorType;

    public ApiException(final ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

}
