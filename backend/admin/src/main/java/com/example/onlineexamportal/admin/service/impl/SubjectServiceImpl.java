package com.example.onlineexamportal.admin.service.impl;

import com.example.onlineexamportal.admin.dto.SubjectDto;
import com.example.onlineexamportal.admin.entity.Subject;
import com.example.onlineexamportal.admin.mapper.SubjectMapper;
import com.example.onlineexamportal.admin.repository.SubjectRepository;
import com.example.onlineexamportal.admin.service.ISubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements ISubjectService {
    private final SubjectRepository subjectRepository;

    @Override
    public boolean createSubject(SubjectDto subjectDto) {
        boolean isCreated = false;
        Subject newSubject = SubjectMapper.maptoSubject(subjectDto,new Subject());
        Subject subject  = subjectRepository.save(newSubject);
        if(subject!=null){
            isCreated = true;
        }
        return isCreated;


    }

    @Override
    public boolean updateSubject(int id, SubjectDto subjectDto) {
        boolean isUpdated = false;
        Optional<Subject> subject = subjectRepository.findById(id);
        if(subject.isPresent()){
            Subject updateSubject = SubjectMapper.maptoSubject(subjectDto,new Subject());
            updateSubject.setId(id);
            subjectRepository.save(updateSubject);
            isUpdated = true;

        }
        return isUpdated;
    }

    @Override
    public void deleteSubject(int id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        if(subject.isPresent()){
            subjectRepository.delete(subject.get());
        }

    }

    @Override
    public List<SubjectDto> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        List<SubjectDto> subjectDtos = new ArrayList<>();
        for(int i=0;i< subjects.size();i++){
            SubjectDto subjectDto = SubjectMapper.maptoSubjectDto(subjects.get(i),new SubjectDto());
            subjectDtos.add(subjectDto);
        }
        return subjectDtos;
    }
}
