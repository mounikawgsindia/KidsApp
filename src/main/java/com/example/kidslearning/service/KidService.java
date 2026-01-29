package com.example.kidslearning.service;

import com.example.kidslearning.dto.KidDto;

import java.util.List;

public interface KidService {

    KidDto createKid(KidDto kidDto);

    List<KidDto> getKidsByParent(Long parentId);

    KidDto getKidById(Long id);

    void deleteKid(Long id);
}


