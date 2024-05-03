package com.example.onlineexamportal.admin.service.impl;

import com.example.onlineexamportal.admin.dto.ExamDto;
import com.example.onlineexamportal.admin.entity.Exam;
import com.example.onlineexamportal.admin.entity.Mcq;
import com.example.onlineexamportal.admin.entity.Subject;
import com.example.onlineexamportal.admin.mapper.ExamMapper;
import com.example.onlineexamportal.admin.repository.ExamRepository;
import com.example.onlineexamportal.admin.repository.SubjectRepository;
import com.example.onlineexamportal.admin.service.IExamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExamServiceImpl implements IExamService {

    private final ExamRepository examRepository;
    private final SubjectRepository subjectRepository;


    @Override
    public void createExam(String subjectCode, ExamDto examDto) {
        Optional<Subject> subject = subjectRepository.findBySubjectCode(subjectCode);
        if(subject.isPresent()){
            Exam exam = ExamMapper.maptoExam(examDto,new Exam());
            exam.setSubject(subject.get());
            examRepository.save(exam);
        }

    }

    @Override
    public ExamDto getExamBySubjectCode(String subjectCode) {
        Optional<Subject> subject = subjectRepository.findBySubjectCode(subjectCode);
        Exam exam = subject.get().getExam();
        ExamDto examDto = ExamMapper.maptoExamDto(exam, new ExamDto());

        return examDto;
    }

    @Override
    public List<ExamDto> findAllExam() {
        List<Exam> exams = examRepository.findAll();
        List<ExamDto> examDtos = new ArrayList<>();

        for(int i=0;i< exams.size();i++){
            ExamDto examDto = ExamMapper.maptoExamDto(exams.get(i),new ExamDto());
            examDtos.add(examDto);
        }
        return examDtos;
    }

    @Override
    @Transactional
    public void deleteExamById(int id) {
        Optional<Exam> exam = examRepository.findById(id);
        Optional<Subject> subject = subjectRepository.findBySubjectName(exam.get().getSubject().getSubjectName());
        subject.get().setExam(null);
        examRepository.deleteById(id);


    }


}
