package com.example.onlineexamportal.admin.service.impl;

import com.example.onlineexamportal.admin.dto.OptionDto;
import com.example.onlineexamportal.admin.entity.Mcq;
import com.example.onlineexamportal.admin.entity.Option;
import com.example.onlineexamportal.admin.mapper.OptionMapper;
import com.example.onlineexamportal.admin.repository.McqRepository;
import com.example.onlineexamportal.admin.repository.OptionRepository;
import com.example.onlineexamportal.admin.service.IOptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OptionServiceImpl implements IOptionService {

    private final McqRepository mcqRepository;
    private final OptionRepository optionRepository;
    @Override
    public List<OptionDto> getMcqOptions(int id) {
        Optional<Mcq> mcq = mcqRepository.findById(id);
        List<OptionDto> optionDtos = new ArrayList<>();
        if(mcq.isPresent()){
            List<Option> options = mcq.get().getOptions();
            for (int i=0; i<options.size();i++){
                OptionDto optionDto = OptionMapper.maptoOptionDto(options.get(i),new OptionDto());
                optionDtos.add(optionDto);
            }
        }
        return optionDtos;
    }
}
