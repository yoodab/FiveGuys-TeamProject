package com.sparta.newspeed.controller;

import com.sparta.newspeed.dto.UserResDto;
import com.sparta.newspeed.security.UserDetailsImpl;
import com.sparta.newspeed.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")

public class ProfileController {

    private final ProfileService profileService;

        @GetMapping("/profile")
    public UserResDto getProfile(UserDetailsImpl userDetails) {
        return profileService.getProfile(userDetails);
    }

    }

