package com.example.kidslearning.controller;

import com.example.kidslearning.dto.KidDto;
import com.example.kidslearning.service.KidService;
import com.example.kidslearning.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/kids")
@RequiredArgsConstructor
public class KidController {

    private final KidService kidService;

    @PostMapping
    public ResponseEntity<ApiResponse<KidDto>> createKid(@RequestBody KidDto kidDto) {
        KidDto created = kidService.createKid(kidDto);
        return ResponseEntity.ok(ApiResponse.ok("Kid created successfully", created));
    }

    @GetMapping("/parent/{parentId}")
    public ResponseEntity<ApiResponse<List<KidDto>>> getKidsByParent(@PathVariable Long parentId) {
        List<KidDto> kids = kidService.getKidsByParent(parentId);
        return ResponseEntity.ok(ApiResponse.ok("Kids fetched successfully", kids));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<KidDto>> getKidById(@PathVariable Long id) {
        KidDto kid = kidService.getKidById(id);
        return ResponseEntity.ok(ApiResponse.ok("Kid fetched successfully", kid));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteKid(@PathVariable Long id) {
        kidService.deleteKid(id);
        return ResponseEntity.ok(ApiResponse.ok("Kid deleted successfully", null));
    }
}


