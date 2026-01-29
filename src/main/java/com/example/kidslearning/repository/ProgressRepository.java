package com.example.kidslearning.repository;

import com.example.kidslearning.entity.Chapter;
import com.example.kidslearning.entity.Kid;
import com.example.kidslearning.entity.Progress;
import com.example.kidslearning.enums.ProgressStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProgressRepository extends JpaRepository<Progress, Long> {

    Optional<Progress> findByKidAndChapter(Kid kid, Chapter chapter);

    List<Progress> findByKid(Kid kid);

    List<Progress> findByKidAndStatus(Kid kid, ProgressStatus status);
}


