package com.example.onlineexamportal.admin.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExamDto {
    private int id;
    private String name;

    private String description;

    private int totalMarks;
    private List<McqDto> mcqDtos;
}
