package com.example.onlineexamportal.admin.controller;

import com.example.onlineexamportal.admin.dto.ExamDto;
import com.example.onlineexamportal.admin.dto.SubjectDto;
import com.example.onlineexamportal.admin.service.IExamService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = {"/api/admin/exams"},produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*")
@Slf4j
public class ExamController {

    private final IExamService iExamService;

    @PostMapping("/create/{subjectCode}")
    public void createExam(@PathVariable String subjectCode, @RequestBody ExamDto examDto){

        iExamService.createExam(subjectCode,examDto);
    }

    @GetMapping("/id/{subjectCode}")
    public ResponseEntity<ExamDto> getExamBySubjectCode(@PathVariable String subjectCode){
        ExamDto examDto =  iExamService.getExamBySubjectCode(subjectCode);
        return ResponseEntity.status(HttpStatus.OK).body(examDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<ExamDto>> getAllExam(){
        List<ExamDto> examDtos = iExamService.findAllExam();
        return ResponseEntity.status(HttpStatus.OK).body(examDtos);
    }

    @DeleteMapping("/id/{examId}")
    public void deleteExam(@PathVariable String examId){
        iExamService.deleteExamById(Integer.valueOf(examId));
    }


}
