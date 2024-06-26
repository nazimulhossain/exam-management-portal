package com.example.onlineexamportal.admin.repository;

import com.example.onlineexamportal.admin.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SemesterRepository extends JpaRepository<Semester,Integer> {

    Optional<Semester> findBySemesterName(String semesterName);
}
