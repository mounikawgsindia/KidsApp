package com.example.kidslearning.repository;

import com.example.kidslearning.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    // 🔍 Find subject by name (used while adding subject to kid)
    Optional<Subject> findByName(String name);

    // 🔍 Check if subject exists by name (optional but useful)
    boolean existsByName(String name);
}



