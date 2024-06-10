package com.sparta.newspeed.dto;

import com.sparta.newspeed.entity.Peed;
import com.sparta.newspeed.like.Likes;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class PeedResponseDto {
    private Long id;
    private String nickname;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private int likeCount;


    public PeedResponseDto(Peed savepeed) {
        this.id = savepeed.getId();
        this.nickname = savepeed.getNickname();
        this.contents = savepeed.getContents();
        this.createdAt = savepeed.getCreatedAt();
        this.modifiedAt = savepeed.getModifiedAt();
        this.likeCount = savepeed.getLikesCount();

    }
}
