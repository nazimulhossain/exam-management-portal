package com.example.onlineexamportal.admin.service;

import com.example.onlineexamportal.admin.dto.SubjectDto;

import java.util.List;

public interface ISubjectService {
    boolean createSubject(SubjectDto subjectDto);

    List<SubjectDto> getAllSubjects();

    boolean updateSubject(int id,SubjectDto subjectDto);

    void deleteSubject(int id);


}
