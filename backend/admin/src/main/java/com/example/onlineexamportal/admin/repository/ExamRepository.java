package com.example.onlineexamportal.admin.repository;

import com.example.onlineexamportal.admin.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Integer> {

    Optional<Exam> findByName(String examName);
}
