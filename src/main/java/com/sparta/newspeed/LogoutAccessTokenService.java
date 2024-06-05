package com.sparta.newspeed;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutAccessTokenService {
  private final LogoutAccessTokenRepository logoutAccessTokenRepository;

    public void saveLogoutAccessToken(String accessToken) {
        logoutAccessTokenRepository.save(new LogoutAccessToken(accessToken));
    }
}
