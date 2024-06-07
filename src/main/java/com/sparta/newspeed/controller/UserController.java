package com.sparta.newspeed.controller;

import com.sparta.newspeed.dto.SignupReqDto;
import com.sparta.newspeed.dto.UserServiceReqDto;
import com.sparta.newspeed.dto.WithdrawReqDto;
import com.sparta.newspeed.security.UserDetailsImpl;
import com.sparta.newspeed.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody SignupReqDto signupRequestDto) {
        String signupMessage = userService.signup(signupRequestDto);
        System.out.println(signupRequestDto.getEmail());
        return new ResponseEntity<>(signupMessage, HttpStatus.OK);
    } //회원 가입


    @PutMapping("/withdraw")
    public ResponseEntity<String> withdraw(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody WithdrawReqDto withdrawReqDto) {
        String withdrawMessage = userService.withdraw(userDetails.getUser(),withdrawReqDto);
        return new ResponseEntity<>(withdrawMessage, HttpStatus.OK);
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
