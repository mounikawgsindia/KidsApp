package com.example.kidslearning.service.impl;

import com.example.kidslearning.dto.SubjectDto;
import com.example.kidslearning.entity.Subject;
import com.example.kidslearning.exception.ResourceNotFoundException;
import com.example.kidslearning.repository.SubjectRepository;
import com.example.kidslearning.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

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
}


