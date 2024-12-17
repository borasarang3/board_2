package com.example.board.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardDTO {
    //Entity에 있는 변수들(사용)만 복사
    //공통 삽입, 수정, 목록, 상세보기
    //DTO로 삽입, 수정, 목록 등 개별적으로 작업
    private Integer id;
    private String subject;
    private String content;
    private String author;
    private LocalDateTime regdate;
    private LocalDateTime modDate;
}
