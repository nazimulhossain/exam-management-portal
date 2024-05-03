package com.example.onlineexamportal.admin.service.impl;

import com.example.onlineexamportal.admin.dto.CourseDto;
import com.example.onlineexamportal.admin.entity.Batch;
import com.example.onlineexamportal.admin.entity.Course;
import com.example.onlineexamportal.admin.entity.Subject;
import com.example.onlineexamportal.admin.mapper.CourseMapper;
import com.example.onlineexamportal.admin.repository.CourseRepository;
import com.example.onlineexamportal.admin.repository.SubjectRepository;
import com.example.onlineexamportal.admin.service.ICourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements ICourseService {

    private final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;
    @Override
    public boolean createCourse(CourseDto courseDto) {
        boolean isCreated = false;
        Course newCourse = CourseMapper.maptoCourse(courseDto,new Course());
        Optional<Course> previousCourse = courseRepository.findByCourseName(newCourse.getCourseName());
        if(previousCourse.isPresent()){
            return isCreated;
        }
        courseRepository.save(newCourse);
        isCreated =true;
        return isCreated;


    }

    @Override
    public CourseDto getCourse(String courseName) {
        Optional<Course> course = courseRepository.findByCourseName(courseName);
        if(course.isPresent()){
            CourseDto courseDto = CourseMapper.maptoCourseDto(course.get(),new CourseDto());
            return courseDto;
        }

        return null;
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDto> courseDtos = new LinkedList<>();
        for(int i=0;i<courses.size();i++){
          CourseDto courseDto = CourseMapper.maptoCourseDto(courses.get(i),new CourseDto());
          courseDtos.add(courseDto);
        }
        return courseDtos;
    }

    @Override
    public boolean updateCourse(CourseDto courseDto) {
        boolean isUpdated = false;
        Course course = CourseMapper.maptoCourse(courseDto,new Course());
        Optional<Course> getCourseFromDataBase = courseRepository.findById(course.getCourseId());
        if(getCourseFromDataBase.isPresent()){
            courseRepository.save(course);
            isUpdated= true;

        }

        return isUpdated;
    }

    @Override
    public boolean deleteCourse(String courseId) {
        boolean isDeleted = false;
        Optional<Course> course= courseRepository.findById(Integer.valueOf(courseId));
        if(course.isPresent()){
            courseRepository.delete(course.get());
            isDeleted= true;
        }
        return isDeleted;
    }

    @Override
    public void addSubjectToCourse(String courseName) {
        Optional<Course> course = courseRepository.findByCourseName(courseName);
        List<Subject> subjects=subjectRepository.findAll();

    }


}
