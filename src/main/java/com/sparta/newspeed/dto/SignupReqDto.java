package com.sparta.newspeed.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupReqDto {
    private String userId; // 사용자 ID
    private String password; // 비밀번호
    private String userName; // 사용자 이름

    private String userEmail; // 사용자 이메일
    private String userInfo; // 사용자 한 줄 소개



}
