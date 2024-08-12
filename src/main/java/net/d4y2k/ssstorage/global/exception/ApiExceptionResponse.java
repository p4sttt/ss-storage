package net.d4y2k.ssstorage.global.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
@JsonPropertyOrder({"code", "error_code", "message"})
public class ApiExceptionResponse {

    @JsonProperty("code")
    private final int code;

    @JsonProperty("reason")
    private final String reason;

    @JsonProperty("message")
    private final String message;

}
