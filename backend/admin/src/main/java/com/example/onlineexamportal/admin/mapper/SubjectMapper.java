package com.example.onlineexamportal.admin.mapper;

import com.example.onlineexamportal.admin.dto.SubjectDto;
import com.example.onlineexamportal.admin.entity.Subject;

public class SubjectMapper {

    public static SubjectDto maptoSubjectDto(Subject subject, SubjectDto subjectDto){
        subjectDto.setId(subject.getId());
        subjectDto.setSubjectCode(subject.getSubjectCode());
        subjectDto.setSubjectName(subject.getSubjectName());
        subjectDto.setSubjectDescription(subject.getSubjectDescription());
        return subjectDto;
    }
    public static Subject maptoSubject(SubjectDto subjectDto,Subject subject){
        subject.setSubjectName(subjectDto.getSubjectName());
        subject.setSubjectCode(subjectDto.getSubjectCode());
        subject.setSubjectDescription(subjectDto.getSubjectDescription());
        return subject;
    }
}
