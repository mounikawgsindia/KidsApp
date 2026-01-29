package com.example.kidslearning.service;

import com.example.kidslearning.dto.ProgressDto;
import com.example.kidslearning.enums.ProgressStatus;

import java.util.List;

public interface ProgressService {

    ProgressDto upsertProgress(ProgressDto progressDto);

    List<ProgressDto> getProgressForKid(Long kidId);

    List<ProgressDto> getProgressForKidByStatus(Long kidId, ProgressStatus status);
}


