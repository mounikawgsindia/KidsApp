package com.example.kidslearning.service.impl;

import com.example.kidslearning.dto.SubjectDto;
import com.example.kidslearning.dto.SubjectRequestDto;
import com.example.kidslearning.entity.Kid;
import com.example.kidslearning.entity.Subject;
import com.example.kidslearning.exception.ResourceNotFoundException;
import com.example.kidslearning.repository.KidRepository;
import com.example.kidslearning.repository.SubjectRepository;
import com.example.kidslearning.service.SubjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final KidRepository kidRepository;

    @Override
    public SubjectDto createSubject(SubjectDto subjectDto) {
        Subject subject = new Subject();
        subject.setName(subjectDto.getName());
        Subject saved = subjectRepository.save(subject);
        return mapToDto(saved);
    }

    @Override
    public List<SubjectDto> getAllSubjects() {
        return subjectRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubjectDto getSubjectById(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id " + id));
        return mapToDto(subject);
    }

    @Override
    public void deleteSubject(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Subject not found with id " + id);
        }
        subjectRepository.deleteById(id);
    }



    private SubjectDto mapToDto(Subject subject) {
        SubjectDto dto = new SubjectDto();
        dto.setId(subject.getId());
        dto.setName(subject.getName());
        return dto;
    }
    @Override
    @Transactional
    public void addSubjectToKid(Long kidId, SubjectRequestDto dto) {

        Kid kid = kidRepository.findById(kidId)
                .orElseThrow(() -> new RuntimeException("Kid not found"));

        Subject subject = subjectRepository.findByName(dto.getName())
                .orElseGet(() -> {
                    Subject newSubject = new Subject();
                    newSubject.setName(dto.getName());
                    return subjectRepository.save(newSubject);
                });

        // ✅ map both sides (VERY IMPORTANT)
        kid.getSubjects().add(subject);
        subject.getKids().add(kid);

        kidRepository.save(kid);
    }

}


