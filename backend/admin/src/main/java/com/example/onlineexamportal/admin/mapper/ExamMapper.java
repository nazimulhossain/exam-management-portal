package com.example.onlineexamportal.admin.mapper;

import com.example.onlineexamportal.admin.dto.ExamDto;
import com.example.onlineexamportal.admin.entity.Exam;
import com.example.onlineexamportal.admin.entity.Mcq;

import java.util.ArrayList;
import java.util.List;

public class ExamMapper {

    public static ExamDto maptoExamDto(Exam exam, ExamDto examDto){
        examDto.setId(exam.getId());
        examDto.setName(exam.getName());
        examDto.setDescription(exam.getDescription());
        examDto.setTotalMarks(exam.getTotalMarks());
        return examDto;
    }

    public static Exam maptoExam(ExamDto examDto,Exam exam){
        exam.setName(examDto.getName());
        exam.setDescription(examDto.getDescription());
        exam.setTotalMarks(examDto.getTotalMarks());
        List<Mcq> mcqs = new ArrayList<>();
        if(examDto.getMcqDtos()!=null){
            for (int i=0; i<examDto.getMcqDtos().size();i++){
                Mcq newMcq = McqMapper.mapToMcq(examDto.getMcqDtos().get(i),new Mcq() );
                mcqs.add(newMcq);
            }
        }

        exam.setMcqs(mcqs);
        return exam;
}
}