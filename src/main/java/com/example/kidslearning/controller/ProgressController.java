package com.example.kidslearning.controller;

import com.example.kidslearning.dto.ProgressDto;
import com.example.kidslearning.enums.ProgressStatus;
import com.example.kidslearning.service.ProgressService;
import com.example.kidslearning.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
@RequiredArgsConstructor
public class ProgressController {

    private final ProgressService progressService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProgressDto>> upsertProgress(@RequestBody ProgressDto progressDto) {
        ProgressDto saved = progressService.upsertProgress(progressDto);
        return ResponseEntity.ok(ApiResponse.ok("Progress updated successfully", saved));
    }

    @GetMapping("/kid/{kidId}")
    public ResponseEntity<ApiResponse<List<ProgressDto>>> getProgressForKid(@PathVariable Long kidId) {
        List<ProgressDto> progressList = progressService.getProgressForKid(kidId);
        return ResponseEntity.ok(ApiResponse.ok("Progress fetched successfully", progressList));
    }

    @GetMapping("/kid/{kidId}/status")
    public ResponseEntity<ApiResponse<List<ProgressDto>>> getProgressForKidByStatus(
            @PathVariable Long kidId,
            @RequestParam ProgressStatus status) {
        List<ProgressDto> progressList = progressService.getProgressForKidByStatus(kidId, status);
        return ResponseEntity.ok(ApiResponse.ok("Progress fetched successfully", progressList));
    }
}


