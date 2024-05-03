package com.example.onlineexamportal.admin.service;

import com.example.onlineexamportal.admin.dto.CourseDto;
import com.example.onlineexamportal.admin.dto.SemesterDto;
import com.example.onlineexamportal.admin.dto.SubjectDto;
import com.example.onlineexamportal.admin.entity.Semester;

import java.util.List;

public interface ISemesterService {

    boolean createSemesterByCourse(String courseName, SemesterDto semesterDto);

//    void createSemester(SemesterDto semesterDto);



    List<SemesterDto> getAllSemesters();

    List<SemesterDto> getAllSemestersByCourse(String courseName);



    boolean updateSemester(int id,SemesterDto semesterDto);

    boolean addSemestersToCourse(int id, CourseDto courseName);


    void addSubjectToSemesters(int id,SubjectDto subjectDto);

    SemesterDto getSemesterById(int id);

    void deleteSemesterById(int id);

    List<SubjectDto> getSubjectsBySemesterId(int id);
}
