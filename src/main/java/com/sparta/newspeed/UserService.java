package com.sparta.newspeed;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.patterns.ConcreteCflowPointcut;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private JwtUtil jwtUtil;

//    public String signup () {} //회원 가입

    public void login(UserServiceReqDto userServiceDto, HttpServletResponse res) {
        User user = findUserByUserId(userServiceDto.getUserId());

        if (!user.getPassword().equals(userServiceDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        } else if (user.getUserStatus().equals(UserStatusEnum.NORMAL)) {
            throw new IllegalArgumentException("탈퇴한 회원입니다.");
        }

        String accessToken = jwtUtil.createAccessToken(user.getUserName(), user.getUserStatus());
        String refreshToken = jwtUtil.createRefreshToken();

        jwtUtil.addAccessJwtToHeader(accessToken, res);
        jwtUtil.addRefreshJwtToHeader(refreshToken, res);

    }

    public String logout(HttpServletRequest req

    ) {
        String logoutAccessToken = jwtUtil.getAccessTokenFromHeader(req);

        return null;

    } // 로그아웃

    public String withdraw() {
        return null;
    } // 회원 탈퇴


    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("등록된 회원이 아닙니다."));
    } // 유저 ID로 유저 찾기

    public User findUserByUserId(String id) {
        return userRepository.findByUserId(id).orElseThrow(() -> new IllegalArgumentException("등록된 회원이 아닙니다."));
    } // 유저 ID로 유저 찾기
} // 로그인




