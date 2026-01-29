package com.example.kidslearning.dto;

import com.example.kidslearning.enums.ProgressStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProgressDto {
    private Long id;
    private Long kidId;
    private Long chapterId;
    private ProgressStatus status;
    private Integer score;
    private LocalDateTime updatedAt;
}


