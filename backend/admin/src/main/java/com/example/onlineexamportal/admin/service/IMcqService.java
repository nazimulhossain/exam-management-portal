package com.example.onlineexamportal.admin.service;

import com.example.onlineexamportal.admin.dto.ExamDto;
import com.example.onlineexamportal.admin.dto.McqDto;

import java.util.List;

public interface IMcqService {

    void createMcq(String examName, ExamDto examDto);

    List<McqDto> getAllMcqsByExam(String examName);

    void updateMcq(int id,McqDto mcqDto);

    void deleteMcq(int id);
}
