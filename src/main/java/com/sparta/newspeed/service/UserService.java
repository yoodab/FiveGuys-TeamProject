package com.sparta.newspeed.service;

import com.sparta.newspeed.dto.SignupReqDto;
import com.sparta.newspeed.entity.Profile;
import com.sparta.newspeed.entity.User;
import com.sparta.newspeed.repository.ProfileRepository;
import com.sparta.newspeed.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public String signup(SignupReqDto requestDto) {

        String username = requestDto.getUserId();

        // 회원 중복 확인
        Optional<User> checkUsername = userRepository.findByUserId(username);
        if (checkUsername.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }


        // 사용자 등록
        User user = new User(requestDto);
        User saveUser = userRepository.save(user);

        // 사용자 프로필 등록
        Profile profile = new Profile(requestDto,saveUser);
        profileRepository.save(profile);


        return "회원가입 성공";
    }
    @Transactional
    public String withdraw(String userId) {

        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));;
        user.delete();

        return "회원 탈퇴 성공";
    } // 회원 탈퇴
}
