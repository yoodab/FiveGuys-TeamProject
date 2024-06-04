package com.sparta.newspeed;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;





    public RefreshToken findByRefreshToken(String refreshTokenValue) {

        return refreshTokenRepository.findByREfreshTokenValue(refreshTokenValue);
    }

    public String updateRefreshToken(RefreshToken newrefreshToken) {

    }
}
