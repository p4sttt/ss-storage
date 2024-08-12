package net.d4y2k.ssstorage.global.success;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@JsonPropertyOrder({"code", "timestamp", "message", "data"})
public class SuccessResponse {

    @JsonProperty("code")
    @Builder.Default
    private int code = 200;

    @JsonProperty("timestamp")
    @JsonFormat(pattern = "yy-MM-dd HH:mm:ss")
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();

    @JsonProperty("message")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonProperty("data")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public SuccessResponse(Object data) {
        this.code = 200;
        this.timestamp = LocalDateTime.now();
        this.data = data;
    }

    public SuccessResponse(String message) {
        this.code = 200;
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }

    public SuccessResponse(Object data, String message) {
        this.data = data;
        this.message = message;
        this.code = 200;
        this.timestamp = LocalDateTime.now();
    }

}
