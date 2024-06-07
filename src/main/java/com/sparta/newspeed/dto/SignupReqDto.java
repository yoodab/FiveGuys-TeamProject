package com.sparta.newspeed.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupReqDto {
    @NotBlank(message = "username은 필수입니다.")
    @Size(min = 10, max = 20, message = "nickname은 최소 10자 이상, 20자 이하여야합니다.")
    @Pattern(regexp = "^[a-z0-9]+$", message = "nickname은 알파벳 소문자(a~z), 숫자(0~9)로 구성되야합니다.")
    private String nickname; // 사용자 ID
    @Size(min = 10,  message = "password는 최소 10자 이상이어야합니다.")
    @Pattern(regexp = "^[a-z0-9]+$", message = "password는 알파벳 소문자(a~z), 숫자(0~9)로 구성되야합니다.")
    private String password; // 비밀번호
    private String username; // 사용자 이름
    private String email; // 사용자 이메일
    private String introduce; // 사용자 한 줄 소개

}
