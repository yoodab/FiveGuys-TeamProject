package com.sparta.newspeed.dto;

import com.sparta.newspeed.entity.Peed;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PeedResponseDto {
    private Long id;
    private String username;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PeedResponseDto(Peed savepeed) {
        this.id = savepeed.getId();
        this.username = savepeed.getUsername();
        this.contents = savepeed.getContents();
        this.createdAt = savepeed.getCreatedAt();
        this.modifiedAt = savepeed.getModifiedAt();
    }
}
