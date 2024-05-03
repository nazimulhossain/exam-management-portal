package com.example.onlineexamportal.admin.service.impl;

import com.example.onlineexamportal.admin.dto.ExamDto;
import com.example.onlineexamportal.admin.dto.McqDto;
import com.example.onlineexamportal.admin.dto.OptionDto;
import com.example.onlineexamportal.admin.entity.Exam;
import com.example.onlineexamportal.admin.entity.Mcq;
import com.example.onlineexamportal.admin.entity.Option;
import com.example.onlineexamportal.admin.mapper.ExamMapper;
import com.example.onlineexamportal.admin.mapper.McqMapper;
import com.example.onlineexamportal.admin.mapper.OptionMapper;
import com.example.onlineexamportal.admin.repository.ExamRepository;
import com.example.onlineexamportal.admin.repository.McqRepository;
import com.example.onlineexamportal.admin.repository.OptionRepository;
import com.example.onlineexamportal.admin.service.IMcqService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class McqServiceImpl implements IMcqService {

    private final ExamRepository examRepository;
    private final McqRepository mcqRepository;
    private final OptionRepository optionRepository;

    @Override
    public void createMcq(String examName, ExamDto examDto) {
        Optional<Exam> exam = examRepository.findByName(examName);
        List<Mcq> mcqs = new ArrayList<>();

        for (int i=0;i<examDto.getMcqDtos().size();i++){
            Mcq newMcq = McqMapper.mapToMcq(examDto.getMcqDtos().get(i),new Mcq() );
            for(int j=0;j<newMcq.getOptions().size();j++){
               optionRepository.save(newMcq.getOptions().get(j));
           }

            mcqs.add(newMcq);

        }

        List<Mcq> oldMcqs = exam.get().getMcqs();
        List<Mcq> newList = new ArrayList<>(oldMcqs);
        newList.addAll(mcqs);

        exam.get().setMcqs(newList);

        examRepository.save(exam.get());
        

    }

    @Override
    public List<McqDto> getAllMcqsByExam(String examName) {
        Optional<Exam> exam = examRepository.findByName(examName);
        List<McqDto> mcqDtos = new ArrayList<>();
        if(exam.isPresent()){
            List<Mcq> mcqs = exam.get().getMcqs();
            if(mcqs.size()==0){
                return null;
            }

            for(int i=0;i<mcqs.size();i++){
                McqDto mcqDto = McqMapper.mapToMcqDto(mcqs.get(i),new McqDto());
                mcqDtos.add(mcqDto);


            }
        }

        return mcqDtos;
    }

    @Override
    public void updateMcq(int id,McqDto mcqDto) {
        Optional<Mcq> mcq = mcqRepository.findById(id);
        if(mcq.isPresent()){
            mcq.get().setQuestion(mcqDto.getQuestion());
            mcq.get().setAnswer(mcqDto.getAnswer());
            mcq.get().setPoints(mcqDto.getPoints());
            List<Option> options = new ArrayList<>();
            for(int i=0;i<mcqDto.getOptions().size();i++){
                Option option = OptionMapper.maptoOption(mcqDto.getOptions().get(i),mcq.get().getOptions().get(i));
                options.add(option);
            }
            mcq.get().setOptions(options);

            mcqRepository.save(mcq.get());

        }
    }

    @Override
    public void deleteMcq(int id) {
        Optional<Mcq> mcq = mcqRepository.findById(id);
        if(mcq.isPresent()){
            mcqRepository.delete(mcq.get());
        }
    }


}
