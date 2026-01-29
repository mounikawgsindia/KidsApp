package com.example.kidslearning.service;

import com.example.kidslearning.dto.ChapterDto;

import java.util.List;

public interface ChapterService {

    ChapterDto createChapter(ChapterDto chapterDto);

    List<ChapterDto> getChaptersBySubject(Long subjectId);

    ChapterDto getChapterById(Long id);

    void deleteChapter(Long id);
}


