package com.jwt.jwt.exception;

import lombok.Getter;

public enum ExceptionCode {

    INVALID_REFRESH_TOKEN(401,"Invalid Refresh Token"),
    INVALID_ACCESS_TOKEN(401,"Invalid Access Token"),
    MEMBER_UNAUTHORIZED(403,"Member Unauthorized"),
    BOOK_NOT_FOUND(404, "Book Not Found"),
    EMAIL_NOT_FOUND(404, "Email Not Found"),
    BOARD_NOT_FOUND(404, "Board Not Found"),
    MEMBER_NOT_FOUND(404, "Member Not Found"),
    FAILED_TO_UPDATE_MEMBER(500, "Failed Update Member"),
    FAILED_TO_DELETE_MEMBER(500, "Failed Delete Member"),
    WRONG_PASSWORD(400,"Wrong Password"),
    NOT_AUTHORIZED_USER(403,"Not Authorized User"),
    EMAIL_ALREADY_EXISTS(409, "Email Already Exists"),
    FAILED_TO_WRITE_BOARD(500, "Failed Write Board"),
    FAILED_TO_DELETE_BOARD(500, "Failed Delete Board");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message){
        this.status = code;
        this.message = message;
    }

}
