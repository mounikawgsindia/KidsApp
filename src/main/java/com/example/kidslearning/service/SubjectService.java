package com.example.kidslearning.service;

import com.example.kidslearning.dto.SubjectDto;

import java.util.List;

public interface SubjectService {

    SubjectDto createSubject(SubjectDto subjectDto);

    List<SubjectDto> getAllSubjects();

    SubjectDto getSubjectById(Long id);

    void deleteSubject(Long id);
}


