package com.pknu26.webboard.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/* class Board는 DB 테이블 Board 로 생성      ///// jpl 사용법
클래스 멤버필드가 전부 테이블 컬럼으로 생성
어노테이션 이 역할을 수행
*/

@Entity  // JPA 테이블 매핑 선언
@Getter  // getter 메서드를 필드별로 자동 생성
@Setter  // setter 메서드를 자동 생성
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bno;  // 테이블 board의 PK(=number=id), bno

    @Column(length = 250)
    private String title;  // 게시판 제목

    @Column(length = 8000)
    private String content;  // 게시글 내용

    @CreatedDate  // 생성일자
    @Column(updatable = false)
    private LocalDateTime createDate;  // 게시글 작성일

    @LastModifiedDate  // 수정될때마다 날짜
    private LocalDateTime modifyDate;  // 게시글 수정일
}
