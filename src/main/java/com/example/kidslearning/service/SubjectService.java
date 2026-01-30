package com.example.kidslearning.service;

import com.example.kidslearning.dto.SubjectDto;
import com.example.kidslearning.dto.SubjectRequestDto;
import com.example.kidslearning.entity.Kid;
import com.example.kidslearning.entity.Subject;
import jakarta.transaction.Transactional;

import java.util.List;

public interface SubjectService {

    SubjectDto createSubject(SubjectDto subjectDto);

    List<SubjectDto> getAllSubjects();

    SubjectDto getSubjectById(Long id);

    void deleteSubject(Long id);

    // ✅ ADD THIS
    void addSubjectToKid(Long kidId, SubjectRequestDto dto);

}


