package com.sparta.newspeed.cotroller;

import com.sparta.newspeed.dto.SignupReqDto;
import com.sparta.newspeed.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public String signup (SignupReqDto signupRequestDto) {
        String signupMessage = userService.signup(signupRequestDto);
        return signupMessage;
    } //회원 가입


    @PutMapping("/withdraw")
    public String withdraw () {
        // @AuthenticationPrincipal UserDetailsImpl userDetails 객체에서 userId 받아서 넣기
        String username = "";
        String withdrawMessage =userService.withdraw(username);
        return withdrawMessage;
    } // 회원 탈퇴


}
