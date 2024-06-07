package com.sparta.newspeed.service;

import com.sparta.newspeed.dto.UserResDto;
import com.sparta.newspeed.entity.User;
import com.sparta.newspeed.repository.UserRepository;
import com.sparta.newspeed.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final UserRepository userRepository;

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User)authentication.getPrincipal();

    //    public UserResDto getProfile(Long id) {
//        User user = userRepository.findById(id).orElseThrow(() -> new ApplicationContextException());
//        return new UserResDto(user);

    public UserResDto getProfile(UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        UserResDto userResDto = new UserResDto(user);
        return userResDto;
    }



}


