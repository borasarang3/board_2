package com.example.board.Entity;

import jakarta.persistence.*;
import lombok.*;

//게시판 테이블
//번호, 제목, 내용, 작성자, 작성일, 수정일
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@ToString //테이블 join을 사용할 때는 2개 Entity중에 하나에는 toString이 없어야 함
@Builder
@Entity //테이블용 클래스
@Table(name = "board") //사용할 테이블명
//일련번호를 board_seq 일련번호를 1로 시작해서 1씩 증가되는 값을 저장
@SequenceGenerator(
        name = "board_seq",
        sequenceName = "board_seq",
        initialValue = 1,
        allocationSize = 1
)
public class BoardEntity extends BaseEntity { //공통필드 상속
    @Id //기본키, 중복불가능, 생략불가능
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq")
    private Integer id; //id int primary key not null auto_increment

    @Column(name = "subject", nullable = false, length = 50)
    private String subject; //subject varchar(50) not null

    @Column(name = "content", length = 100)
    private String content; //content varchar(100)

    @Column(name = "author", length = 30)
    private String author; //author varchar(30)

    //생성 및 수정날짜 필드가 추가
}
