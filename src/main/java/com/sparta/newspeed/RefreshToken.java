package com.sparta.newspeed;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class RefreshToken extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    private String refreshTokenValue;

    public String getRefreshToken() {
        return this.refreshTokenValue;
    }

}
