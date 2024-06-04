package com.tutoring.teamprojectdraft;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


//    public String signup () {} //회원 가입

    public void login(UserServiceDto userServiceDto) {
        User user = findUserByUserId(userServiceDto.getUserId());

        if (!user.getPassword().equals(userServiceDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        } else if (user.getUserStatus().equals(UserStatusEnum.Normal)) {
            throw new IllegalArgumentException("탈퇴한 회원입니다.");
        }




    }
    public String logout() {
    } // 로그아웃

    public String withdraw() {
    } // 회원 탈퇴


    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("등록된 회원이 아닙니다."));
    } // 유저 ID로 유저 찾기

    public User findUserByUserId(String id) {
        return userRepository.findByUserId(id).orElseThrow(() -> new IllegalArgumentException("등록된 회원이 아닙니다."));
    } // 유저 ID로 유저 찾기
} // 로그인


}
