package com.example.onlineexamportal.admin.mapper;

import com.example.onlineexamportal.admin.dto.SemesterDto;
import com.example.onlineexamportal.admin.entity.Semester;

public class SemesterMapper {

    public static SemesterDto mapToSemesterDto(Semester semester, SemesterDto semesterDto) {
        semesterDto.setId(semester.getId());
        semesterDto.setSemesterName(semester.getSemesterName());
        return semesterDto;
    }

    public static Semester mapToSemester(SemesterDto semesterDto, Semester semester){
        semester.setSemesterName(semesterDto.getSemesterName());
        return semester;
    }
}
