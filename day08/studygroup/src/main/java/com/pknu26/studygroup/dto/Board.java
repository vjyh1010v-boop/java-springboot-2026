package com.pknu26.studygroup.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data -> @Getter/@Setter/@ToString/@RequiredArgsConstructor/...
@Data
@NoArgsConstructor  // 없는 것보단 있는 것이 낫다..
@AllArgsConstructor  // 필요없으면 지우면 됨
public class Board {

    private Long boardId;  // DB board_id
    private String title;
    private String content;
    private String Writer;
    private LocalDateTime createdAt; // DB, created_at
    private LocalDateTime updatedAt; // DB, updated_at
}
