package com.example.kidslearning.repository;

import com.example.kidslearning.entity.Kid;
import com.example.kidslearning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KidRepository extends JpaRepository<Kid, Long> {
    List<Kid> findByParent(User parent);
}


