package com.tutoring.teamprojectdraft;

import com.tutoring.teamprojectdraft.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.parser.Entity;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

private final UserService userService;

//    public String signup () {} //회원 가입


//    public String withdraw () {} // 회원 탈퇴

   @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody UserServiceDto userServiceDto) {
        userService.login(userServiceDto);
        return new ResponseEntity<>("회원가입 완료", HttpStatus.OK );
    } // 로그인

    public String logout () {
       return null;
    } // 로그아웃


}
