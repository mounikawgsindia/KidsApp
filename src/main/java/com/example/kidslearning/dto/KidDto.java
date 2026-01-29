package com.example.kidslearning.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class KidDto {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private Long parentId;
}


