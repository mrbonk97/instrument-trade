package com.mrbonk.instrumenttrade.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "토큰이 유효하지 않음"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 유저 없음"),
    MEMORY_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 기록 없음"),
    FRIEND_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 친구 없음"),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "잘못된 패스워드"),
    INVALID_EMAIL_PATTERN(HttpStatus.UNAUTHORIZED, "잘못된 이메일 형식"),
    DUPLICATED_EMAIL(HttpStatus.CONFLICT, "이메일 중복"),
    INVALID_PERMISSION(HttpStatus.UNAUTHORIZED, "유저에게 권한이 없음"),
    DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "데이터베이스 에러");

    private final HttpStatus status;
    private final String message;
}
