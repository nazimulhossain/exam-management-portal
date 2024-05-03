package com.example.onlineexamportal.admin.service;

import com.example.onlineexamportal.admin.dto.ExamDto;
import com.example.onlineexamportal.admin.entity.Exam;

import java.util.List;

public interface IExamService {

    void createExam(String subjectCode, ExamDto examDto);

    ExamDto getExamBySubjectCode(String subjectCode);

    List<ExamDto> findAllExam();

    void deleteExamById(int id);


}
