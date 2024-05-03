package com.example.onlineexamportal.admin.service;

import com.example.onlineexamportal.admin.dto.CourseDto;

import java.util.List;

public interface ICourseService {

    boolean createCourse(CourseDto courseDto);

    CourseDto getCourse(String courseName);

    List<CourseDto> getAllCourses();

    boolean updateCourse(CourseDto courseDto);

    boolean deleteCourse(String courseId);

    void addSubjectToCourse(String courseName);
}
