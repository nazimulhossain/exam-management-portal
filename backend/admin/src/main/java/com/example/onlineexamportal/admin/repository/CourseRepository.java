package com.example.onlineexamportal.admin.repository;

import com.example.onlineexamportal.admin.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    Optional<Course> findByCourseName(String courseName);
}
