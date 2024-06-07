package com.sparta.newspeed.entity;

import com.sparta.newspeed.Timestamped;
import com.sparta.newspeed.dto.SignupReqDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본키
    @Column(nullable = false, unique = true)
    private String nickname; // 사용자 ID
    @Column(nullable = false)
    private String password; // 비밀번호
    @Column(nullable = false)
    private String userName; // 사용자 이름
    @Column(nullable = false)
    private String email; // 사용자 이메일
    @Column(nullable = false)
    private String introduce; // 한줄소개
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatusEnum userStatus; // 회원 상태코드
    @Column(nullable = true)
    private String refreshToken = null;
    @OneToMany(mappedBy="user")
    private List<Peed> peedlist = new ArrayList<>();


    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public User(SignupReqDto requestDto) {
        this.nickname = requestDto.getNickname();
        this.password = requestDto.getPassword();
        this.userName = requestDto.getUserName();
        this.email = requestDto.getEmail();
        this.introduce = requestDto.getIntroduce();
        this.userStatus = UserStatusEnum.NORMAL;
    }

    public void withdraw() {
        this.userStatus = UserStatusEnum.WITHDREW;
    }
}

//    private RefreshToken refreshToken; // 리프레쉬 토큰
//
//    private Content Content; // 게시물 외래키




