package com.example.onlineexamportal.admin.controller;

import com.example.onlineexamportal.admin.dto.ExamDto;
import com.example.onlineexamportal.admin.dto.McqDto;
import com.example.onlineexamportal.admin.dto.ResponseDto;
import com.example.onlineexamportal.admin.entity.Exam;
import com.example.onlineexamportal.admin.service.IMcqService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/admin/mcqs",produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*")
@Slf4j
public class McqController {

    private final IMcqService iMcqService;

    @PostMapping("/{examName}/create")
    public ResponseEntity<ResponseDto> createMcq(@PathVariable String examName, @RequestBody ExamDto examDto){
        iMcqService.createMcq(examName,examDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(201,"Mcq Created Successfully"));
    }

    @GetMapping("/{examName}")
    public ResponseEntity<List<McqDto>> getMcqsByExam(@PathVariable String examName){
        List<McqDto> mcqDtos = iMcqService.getAllMcqsByExam(examName);
        return ResponseEntity.status(HttpStatus.OK).body(mcqDtos);
    }

    @PutMapping("/update/{mcqId}")
    public ResponseEntity<ResponseDto> updateMcq(@PathVariable String mcqId,@RequestBody McqDto mcq){
        iMcqService.updateMcq(Integer.valueOf(mcqId),mcq);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(200,"Mcq updated successfully"));

    }

    @DeleteMapping("/delete/{id}")
    public void deleteMcq(@PathVariable String id){
        iMcqService.deleteMcq(Integer.valueOf(id));
    }
}
