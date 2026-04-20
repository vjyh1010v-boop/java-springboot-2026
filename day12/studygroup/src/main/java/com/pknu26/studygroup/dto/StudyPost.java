package com.pknu26.studygroup.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 기본생성자
@AllArgsConstructor  // 모든... 해결...
public class StudyPost {
private Long postId;
    private Long userId;
    private Long categoryId;
    private String title;
    private String content;
    private Integer maxMembers;
    private String status;
    private Integer viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 조인 조회용
    private String writerName;
    private String categoryName;
}
