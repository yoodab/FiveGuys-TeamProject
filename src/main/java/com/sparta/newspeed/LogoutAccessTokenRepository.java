package com.sparta.newspeed;

import org.springframework.stereotype.Repository;

@Repository
public interface LogoutAccessTokenRepository {
    void save(LogoutAccessToken logoutAccessToken);
}
