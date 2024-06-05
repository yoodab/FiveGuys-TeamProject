package com.sparta.newspeed.service;

import com.sparta.newspeed.dto.SignupReqDto;
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

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RefreshTokenService refreshTokenService;
    private final LogoutAccessTokenService LogoutAccessTokenService;
    private final JwtUtil jwtUtil;


    public String signup(SignupReqDto requestDto) {

        String nickName = requestDto.getNickname();

        // 회원 중복 확인
        Optional<User> checkNickName = userRepository.findByNickname(nickName);
        if (checkNickName.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }


        // 사용자 등록
        User user = new User(requestDto);
        userRepository.save(user);



        return "회원가입 성공";
    }

    @Transactional
    public String withdraw(String nickname) {

        User user = userRepository.findByNickname(nickname)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        ;
        user.delete();

        return "회원 탈퇴 성공";
    } // 회원 탈퇴


    public void login(UserServiceReqDto userServiceDto, HttpServletResponse res) {
        User user = findUserByUserId(userServiceDto.getNickname());

        if (!user.getPassword().equals(userServiceDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        } else if (!user.getUserStatus().equals(UserStatusEnum.NORMAL)) {
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
        refreshToken = jwtUtil.substringRefreshToken(refreshToken);


    } // 로그아웃


    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("등록된 회원이 아닙니다."));
    } // 유저 ID로 유저 찾기

    public User findUserByUserId(String id) {
        return userRepository.findByNickname(id).orElseThrow(() -> new IllegalArgumentException("등록된 회원이 아닙니다."));
    } // 유저 ID로 유저 찾기
} // 로그인