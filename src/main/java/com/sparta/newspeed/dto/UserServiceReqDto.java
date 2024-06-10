package com.sparta.newspeed.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "로그인 요청 DTO")
public class UserServiceReqDto {

    @Schema(description = "사용자 닉네임", example = "user123")
    private String nickname;

    @Schema(description = "비밀번호", example = "password123")
    private String password;
}
