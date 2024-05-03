package com.example.onlineexamportal.admin.mapper;

import com.example.onlineexamportal.admin.dto.CourseDto;
import com.example.onlineexamportal.admin.entity.Course;

public class CourseMapper {

    public static CourseDto maptoCourseDto(Course course, CourseDto courseDto){
        courseDto.setCourseId(course.getCourseId());
        courseDto.setCourseCode(course.getCourseCode());
        courseDto.setCourseName(course.getCourseName());
        courseDto.setCourseDescription(course.getCourseDescription());
        return courseDto;

    }

    public static Course maptoCourse(CourseDto courseDto,Course course){
        course.setCourseId(courseDto.getCourseId());
        course.setCourseCode(courseDto.getCourseCode());
        course.setCourseName(courseDto.getCourseName());
        course.setCourseDescription(courseDto.getCourseDescription());
        return course;
    }
}
