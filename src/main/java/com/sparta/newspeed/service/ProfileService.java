package com.sparta.newspeed.service;

import com.sparta.newspeed.dto.UserReqDto;
import com.sparta.newspeed.dto.UserResDto;
import com.sparta.newspeed.entity.User;
import com.sparta.newspeed.repository.UserRepository;
import com.sparta.newspeed.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final UserRepository userRepository;

    public UserResDto getProfile(UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        UserResDto userResDto = new UserResDto(user);
        return userResDto;
    }

}


