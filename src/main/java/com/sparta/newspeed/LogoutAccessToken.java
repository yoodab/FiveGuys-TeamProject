package com.sparta.newspeed;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class LogoutAccessToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String logoutAccessToken;

    public LogoutAccessToken(String accessToken) {
        this.logoutAccessToken = accessToken;
    }
}
