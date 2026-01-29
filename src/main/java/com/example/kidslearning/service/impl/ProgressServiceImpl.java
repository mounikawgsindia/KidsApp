package com.example.kidslearning.service.impl;

import com.example.kidslearning.dto.ProgressDto;
import com.example.kidslearning.entity.Chapter;
import com.example.kidslearning.entity.Kid;
import com.example.kidslearning.entity.Progress;
import com.example.kidslearning.enums.ProgressStatus;
import com.example.kidslearning.exception.ResourceNotFoundException;
import com.example.kidslearning.repository.ChapterRepository;
import com.example.kidslearning.repository.KidRepository;
import com.example.kidslearning.repository.ProgressRepository;
import com.example.kidslearning.service.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProgressServiceImpl implements ProgressService {

    private final ProgressRepository progressRepository;
    private final KidRepository kidRepository;
    private final ChapterRepository chapterRepository;

    @Override
    public ProgressDto upsertProgress(ProgressDto progressDto) {
        Kid kid = kidRepository.findById(progressDto.getKidId())
                .orElseThrow(() -> new ResourceNotFoundException("Kid not found with id " + progressDto.getKidId()));
        Chapter chapter = chapterRepository.findById(progressDto.getChapterId())
                .orElseThrow(() -> new ResourceNotFoundException("Chapter not found with id " + progressDto.getChapterId()));

        Progress progress = progressRepository.findByKidAndChapter(kid, chapter)
                .orElseGet(() -> {
                    Progress p = new Progress();
                    p.setKid(kid);
                    p.setChapter(chapter);
                    return p;
                });

        if (progressDto.getStatus() != null) {
            progress.setStatus(progressDto.getStatus());
        }
        progress.setScore(progressDto.getScore());
        progress.setUpdatedAt(LocalDateTime.now());

        Progress saved = progressRepository.save(progress);
        return mapToDto(saved);
    }

    @Override
    public List<ProgressDto> getProgressForKid(Long kidId) {
        Kid kid = kidRepository.findById(kidId)
                .orElseThrow(() -> new ResourceNotFoundException("Kid not found with id " + kidId));
        return progressRepository.findByKid(kid).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProgressDto> getProgressForKidByStatus(Long kidId, ProgressStatus status) {
        Kid kid = kidRepository.findById(kidId)
                .orElseThrow(() -> new ResourceNotFoundException("Kid not found with id " + kidId));
        return progressRepository.findByKidAndStatus(kid, status).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private ProgressDto mapToDto(Progress progress) {
        ProgressDto dto = new ProgressDto();
        dto.setId(progress.getId());
        if (progress.getKid() != null) {
            dto.setKidId(progress.getKid().getId());
        }
        if (progress.getChapter() != null) {
            dto.setChapterId(progress.getChapter().getId());
        }
        dto.setStatus(progress.getStatus());
        dto.setScore(progress.getScore());
        dto.setUpdatedAt(progress.getUpdatedAt());
        return dto;
    }
}


