package com.sparta.newspeed.dto;

import com.sparta.newspeed.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResDto {

    private String nickname;
    private Long PeedId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private int likesCount;

    public CommentResDto(Comment comment) {
        this.nickname = comment.getUser().getNickname();
        this.PeedId = comment.getPeed().getId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
        this.likesCount = comment.getLikesCount();
    }
}
