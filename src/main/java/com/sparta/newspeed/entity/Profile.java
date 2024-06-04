package com.sparta.newspeed.entity;

import com.sparta.newspeed.dto.SignupReqDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Profile extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본키

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    private String userName;
    private String userEmail;
    private String userInfo;


    public Profile(SignupReqDto requestDto, User user) {
        this.user = user;
        this.userName = requestDto.getUserName();
        this.userEmail = requestDto.getUserEmail();
        this.userInfo = requestDto.getUserInfo();
    }
}
