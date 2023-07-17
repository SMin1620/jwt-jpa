package com.jwt.jwt.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Tag(name = "기본 객체",description = "서버측에서 클라이언트 쪽으로 데이터를 보낼 때의 객체")
public class BaseResponse<T> {

    private String status;
    private String message;
    private T data;
}
