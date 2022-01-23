package org.example.global.common.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    // auth
    EMAIL_NOT_FOUND(400, "a001", "Email not found"),

    ;
    private final int status;
    private final String code;
    private final String message;
}
