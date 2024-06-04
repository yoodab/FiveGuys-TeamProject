package com.sparta.newspeed.entity;

import com.sparta.newspeed.dto.PeedRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@NoArgsConstructor
@Table(name = "newspeed")// 매핑할 테이블의 이름을 지정
public class Peed extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "user_id", nullable = false, length = 500)// 유저테이블에서 id만 가져오기
   // private String user_id;
    @Column(length = 500)
    private String username;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;

    public Peed(PeedRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(PeedRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.username = requestDto.getUsername(); // 이름과 내용만 일단 수정되게
    }
}

