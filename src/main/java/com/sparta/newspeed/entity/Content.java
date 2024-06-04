package com.sparta.newspeed.entity;


import com.sparta.newspeed.dto.ContentRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "newspeed")
public class Content extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "user_id", updatable = false)
    private Long userId;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Builder
    public Content(ContentRequestDto requestDto) {
        this.userId = requestDto.getUserId();
        this.content = requestDto.getContent();
    }
}