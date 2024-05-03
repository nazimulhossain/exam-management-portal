package com.example.onlineexamportal.admin.mapper;

import com.example.onlineexamportal.admin.dto.DescriptiveDto;
import com.example.onlineexamportal.admin.entity.Descriptive;

public class DescriptiveMapper {
    public static DescriptiveDto maptoDescriptiveDto(Descriptive descriptive,DescriptiveDto descriptiveDto){
        descriptiveDto.setId(descriptive.getId());
        descriptiveDto.setQuestion(descriptive.getQuestion());

        return descriptiveDto;
    }

    public static Descriptive maptoDescriptive(DescriptiveDto descriptiveDto,Descriptive descriptive){
        descriptive.setQuestion(descriptiveDto.getQuestion());

        return descriptive;
    }
}
