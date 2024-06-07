package com.sparta.newspeed.dto;

import lombok.Getter;
import org.springframework.security.core.userdetails.User;

@Getter
public class UserResDto {
    private String UserId; // 사용자 ID
    private String Password; // 비밀번호
    private String userName; // 사용자 이름
    private String email; // 사용자 이메일
    private String introduce; // 한줄소개

    public UserResDto(User user) {
        this.getUserId();
        this.userName = user.getUsername();
        this.getEmail();
        this.getIntroduce();
    }
}
