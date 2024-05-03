package com.example.onlineexamportal.admin.dto;

import com.example.onlineexamportal.admin.entity.Option;
import lombok.Data;

import java.util.List;

@Data
public class McqDto {
    private int id;
    private String question;
    private List<OptionDto> options;
    private String answer;
    private int points;
}
