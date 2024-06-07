package com.sparta.newspeed.dto;

import com.sparta.newspeed.entity.User;
import lombok.Getter;

@Getter
public class UserResDto {
    private String nickname; // 사용자 ID
    private String userName; // 사용자 이름
    private String email; // 사용자 이메일
    private String introduce; // 한줄소개



    public UserResDto(User user) {
        this.nickname = getNickname();
        this.userName = user.getUsername();
        this.email = user.getEmail();
        this.introduce = user.getIntroduce();
    }
    // 직렬화 : 객체 데이터를 스트림으로 변형을 한다? 이게 좀 맞는 말은 아닌데 결국 객체로 제이슨을 만든다.
    // 직렬화 = 제이슨(스트림형식으로 변환) -> 제이슨 -> 객체로 역직렬화다.
    // 키 값이 필드다.
}
