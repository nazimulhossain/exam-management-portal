package com.example.onlineexamportal.admin.mapper;

import com.example.onlineexamportal.admin.dto.McqDto;
import com.example.onlineexamportal.admin.dto.OptionDto;
import com.example.onlineexamportal.admin.entity.Mcq;
import com.example.onlineexamportal.admin.entity.Option;

import java.util.ArrayList;
import java.util.List;

public class McqMapper {
    public static McqDto mapToMcqDto(Mcq mcq,McqDto mcqDto){
        mcqDto.setId(mcq.getId());
        mcqDto.setQuestion(mcq.getQuestion());
        List<OptionDto> options = new ArrayList<>();
        for (int i=0;i<mcq.getOptions().size();i++){
            OptionDto option = OptionMapper.maptoOptionDto(mcq.getOptions().get(i),new OptionDto() );
            options.add(option);
        }

        mcqDto.setOptions(options);
        mcqDto.setAnswer(mcq.getAnswer());
        mcqDto.setPoints(mcq.getPoints());
        return mcqDto;
    }

    public static Mcq mapToMcq(McqDto mcqDto,Mcq mcq){

        mcq.setQuestion(mcqDto.getQuestion());
        List<Option> options = new ArrayList<>();
        for (int i=0;i<mcqDto.getOptions().size();i++){
            Option option = OptionMapper.maptoOption(mcqDto.getOptions().get(i),new Option() );
            options.add(option);
        }

        mcq.setOptions(options);
        mcq.setAnswer(mcqDto.getAnswer());
        mcq.setPoints(mcqDto.getPoints());
        return mcq;
    }
}
