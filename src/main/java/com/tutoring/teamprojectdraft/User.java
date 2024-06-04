package com.tutoring.teamprojectdraft;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본키
    @Column(nullable = false)
    private String UserId; // 사용자 ID
    @Column(nullable = false)
    private String Password; // 비밀번호
    @Column(nullable = false)
    private String userName; // 사용자 이름
    @Column(nullable = false)
    private String email; // 사용자 이메일
    @Column(nullable = false)
    private String introduce; // 한줄소개
    @Column(nullable = false)
    private UserStatusEnum userStatus; // 회원 상태코드

//    private RefreshToken refreshToken; // 리프레쉬 토큰
//
//    private Content Content; // 게시물 외래키
//
//    private Comment Comment; // 댓글 외래키

//    private Profile profile; // 프로필 외래키
//


}
