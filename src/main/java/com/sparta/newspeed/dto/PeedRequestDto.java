package com.sparta.newspeed.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PeedRequestDto {

    private String username;
    private String contents;
}
