package com.sparta.newspeed.entity;

import com.sparta.newspeed.dto.SignupReqDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본키
    @Column(nullable = false)
    private String userId; // 사용자 ID
    @Column(nullable = false)
    private String password; // 비밀번호
    @Column(nullable = false)
    private String userName; // 사용자 이름

    @Column(nullable = false)
    private UserStatusEnum userStatus; // 회원 상태코드

    public User(SignupReqDto requestDto) {
        this.userId = requestDto.getUserId();
        this.password = requestDto.getPassword();
        this.userName = requestDto.getUserName();
        this.userStatus = UserStatusEnum.NORMAL;
    }

    public void delete() {
        this.userStatus = UserStatusEnum.WITHDREW;
    }

//    private RefreshToken refreshToken; // 리프레쉬 토큰
//
//    private Content Content; // 게시물 외래키
//
//    private Comment Comment; // 댓글 외래키

//    private Profile profile; // 프로필 외래키
//


}
