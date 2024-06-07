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

    public CommentResDto(Comment comment) {
        this.nickname = comment.getUser().getNickname();
        this.PeedId = comment.getPeed().getId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
