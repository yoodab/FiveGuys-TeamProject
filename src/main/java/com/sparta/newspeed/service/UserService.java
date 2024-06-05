package com.sparta.newspeed.service;

import com.sparta.newspeed.entity.User;
import com.sparta.newspeed.repository.UserRepository;
import com.sparta.newspeed.security.JwtUtil;
import com.sparta.newspeed.dto.UserServiceReqDto;
import com.sparta.newspeed.entity.UserStatusEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RefreshTokenService refreshTokenService;
    private final com.sparta.newspeed.service.LogoutAccessTokenService LogoutAccessTokenService;
    private JwtUtil jwtUtil;

//    public String signup () {} //회원 가입


    public String withdraw() {
        return null;
    } // 회원 탈퇴










































































    public void login(UserServiceReqDto userServiceDto, HttpServletResponse res) {
        User user = findUserByUserId(userServiceDto.getNickname());

        if (!user.getPassword().equals(userServiceDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        } else if (user.getUserStatus().equals(UserStatusEnum.NORMAL)) {
            throw new IllegalArgumentException("탈퇴한 회원입니다.");
        }

        String accessToken = jwtUtil.createAccessToken(user.getUserName(), user.getUserStatus());
        String refreshToken = refreshTokenService.createRefreshToken(user);

        jwtUtil.addAccessJwtToHeader(accessToken, res);
        jwtUtil.addRefreshJwtToHeader(refreshToken, res);

    }

    @Transactional
    public void logout(HttpServletRequest req) {
        String accessToken = jwtUtil.getAccessTokenFromHeader(req);
        accessToken = jwtUtil.substringAccessToken(accessToken);
        LogoutAccessTokenService.saveLogoutAccessToken(accessToken);

        String refreshToken = jwtUtil.getRefreshTokenFromHeader(req);
        refreshToken  = jwtUtil.substringRefreshToken(refreshToken);


    } // 로그아웃









    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("등록된 회원이 아닙니다."));
    } // 유저 ID로 유저 찾기

    public User findUserByUserId(String id) {
        return userRepository.findByNickname(id).orElseThrow(() -> new IllegalArgumentException("등록된 회원이 아닙니다."));
    } // 유저 ID로 유저 찾기
} // 로그인




