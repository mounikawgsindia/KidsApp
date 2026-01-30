package com.example.kidslearning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // ✅ allows new SubjectDto(id, name)
@NoArgsConstructor  // ✅ default constructor
public class SubjectDto {
    private Long id;
    private String name;
}


