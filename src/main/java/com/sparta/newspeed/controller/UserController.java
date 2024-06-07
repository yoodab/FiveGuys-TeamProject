package com.sparta.newspeed.controller;

import com.sparta.newspeed.dto.SignupReqDto;
import com.sparta.newspeed.dto.UserServiceReqDto;
import com.sparta.newspeed.security.UserDetailsImpl;
import com.sparta.newspeed.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public String signup(@RequestBody SignupReqDto signupRequestDto) {
        String signupMessage = userService.signup(signupRequestDto);
        System.out.println(signupRequestDto.getEmail());
        return signupMessage;
    } //회원 가입


    @PutMapping("/withdraw")
    public String withdraw(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        // @AuthenticationPrincipal UserDetailsImpl userDetails 객체에서 userId 받아서 넣기
        String nickname = userDetails.getUser().getNickname();
        String withdrawMessage = userService.withdraw(nickname);
        return withdrawMessage;
    } // 회원 탈퇴


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserServiceReqDto userServiceDto, HttpServletResponse res) {
        userService.login(userServiceDto, res);
        return new ResponseEntity<>("로그인 완료", HttpStatus.OK);
    } // 로그인

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest req, UserDetailsImpl userDetailsImpl) {
        userService.logout(req, userDetailsImpl);
        return new ResponseEntity<>("로그아웃 완료", HttpStatus.OK);
    } // 로그아웃


}
