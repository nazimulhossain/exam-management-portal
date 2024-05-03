package com.example.onlineexamportal.admin.mapper;

import com.example.onlineexamportal.admin.dto.OptionDto;
import com.example.onlineexamportal.admin.entity.Option;

public class OptionMapper {

    public static OptionDto maptoOptionDto(Option option,OptionDto optionDto){
        optionDto.setId(option.getId());
        optionDto.setOptionTitle(option.getOptionTitle());
        return optionDto;
    }

    public static Option maptoOption(OptionDto optionDto,Option option){
        option.setOptionTitle(optionDto.getOptionTitle());
        return option;
    }
}
