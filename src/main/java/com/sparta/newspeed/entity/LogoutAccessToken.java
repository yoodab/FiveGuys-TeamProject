package com.sparta.newspeed.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
public class LogoutAccessToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String logoutAccessToken;
    boolean expired = false;

    public LogoutAccessToken(String accessToken) {
        this.logoutAccessToken = accessToken;
    }
}
