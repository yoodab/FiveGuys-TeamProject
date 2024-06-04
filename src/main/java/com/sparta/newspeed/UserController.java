package com.sparta.newspeed;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    public String signup () {} //회원 가입


//    public String withdraw () {} // 회원 탈퇴

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody UserServiceReqDto userServiceDto, HttpServletResponse res) {
        userService.login(userServiceDto, res);
        return new ResponseEntity<>("회원가입 완료", HttpStatus.OK );
    } // 로그인

    @PostMapping("/logout")
    public ResponseEntity<String> logout (HttpServletResponse res) {
        userService.logout(res);
        return new ResponseEntity<>("로그아웃 완료", HttpStatus.OK );
    } // 로그아웃


}
