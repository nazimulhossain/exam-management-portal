package com.example.onlineexamportal.admin.service.impl;

import com.example.onlineexamportal.admin.dto.CourseDto;
import com.example.onlineexamportal.admin.dto.SemesterDto;
import com.example.onlineexamportal.admin.dto.SubjectDto;
import com.example.onlineexamportal.admin.entity.Batch;
import com.example.onlineexamportal.admin.entity.Course;
import com.example.onlineexamportal.admin.entity.Semester;
import com.example.onlineexamportal.admin.entity.Subject;
import com.example.onlineexamportal.admin.mapper.SemesterMapper;
import com.example.onlineexamportal.admin.mapper.SubjectMapper;
import com.example.onlineexamportal.admin.repository.BatchRepository;
import com.example.onlineexamportal.admin.repository.CourseRepository;
import com.example.onlineexamportal.admin.repository.SemesterRepository;
import com.example.onlineexamportal.admin.repository.SubjectRepository;
import com.example.onlineexamportal.admin.service.ISemesterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class SemesterServiceImpl implements ISemesterService {

    private final SemesterRepository semesterRepository;
    private final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;
    @Override
    public boolean createSemesterByCourse(String courseName, SemesterDto semesterDto) {
        boolean isCreated = false;

        Optional<Course> course = courseRepository.findByCourseName(courseName);
        if(course.isPresent()){
            Semester newSemester = SemesterMapper.mapToSemester(semesterDto, new Semester());
            List<Semester> semesters = course.get().getSemesters();
            semesters.add(newSemester);
            course.get().setSemesters(semesters);
            semesterRepository.save(newSemester);

            isCreated = true;

        }

        return isCreated;
    }

//    @Override
//    public void createSemester(SemesterDto semesterDto) {
//        Semester semester = SemesterMapper.mapToSemester(semesterDto,new Semester());
//        semesterRepository.save(semester);
//    }

    @Override
    public List<SemesterDto> getAllSemestersByCourse(String courseName) {
        Optional<Course> course = courseRepository.findByCourseName(courseName);
        List<SemesterDto> semesterDtos = new ArrayList<>();
        if(course.isPresent()){
            List<Semester> semesters = course.get().getSemesters();
            if(semesters.size() > 0){
                for(int i=0;i<semesters.size();i++){
                    SemesterDto semesterDto = SemesterMapper.mapToSemesterDto(semesters.get(i),new SemesterDto());
                    semesterDtos.add(semesterDto);
                }

                return semesterDtos;
            }
        }




        return null;
    }

    @Override
    public List<SemesterDto> getAllSemesters() {
        List<Semester> semesters = semesterRepository.findAll();
        List<SemesterDto> semesterDtos = new ArrayList<>();
        if(semesters.size()>0)
        for(int i=0;i<semesters.size();i++){
            SemesterDto semesterDto = SemesterMapper.mapToSemesterDto(semesters.get(i),new SemesterDto());
            semesterDtos.add(semesterDto);
        }
        return semesterDtos;
    }

    @Override
    public boolean updateSemester(int id, SemesterDto semesterDto) {
        boolean isUpdated = false;
       Optional<Semester> semester = semesterRepository.findById(id);
       if(semester.isPresent()){
           Semester updatedSemester = SemesterMapper.mapToSemester(semesterDto,semester.get());
           semesterRepository.save(updatedSemester);
           isUpdated = true;
       }
        return isUpdated;
    }

    @Override
    public boolean addSemestersToCourse(int id, CourseDto courseDto) {
        boolean isAdded = false;
        Optional<Course> course = courseRepository.findByCourseName(courseDto.getCourseName());
        Optional<Semester> semester = semesterRepository.findById(id);
        course.get().addSemester(semester.get());
        courseRepository.save(course.get());
        isAdded = true;




        return isAdded;
    }

    @Override
    public void addSubjectToSemesters(int id, SubjectDto subjectDto) {
        boolean isAdded = false;
        Optional<Semester> semester = semesterRepository.findById(id);
       Optional<Subject> subject = subjectRepository.findBySubjectName(subjectDto.getSubjectName());
       if(subject.isPresent()){
           semester.get().addSubject(subject.get());
           semesterRepository.save(semester.get());
       }


    }

    @Override
    public SemesterDto getSemesterById(int id) {
        Optional<Semester> semester = semesterRepository.findById(id);
        if(semester.isPresent()){
            SemesterDto semesterDto = SemesterMapper.mapToSemesterDto(semester.get(),new SemesterDto());
            return semesterDto;
        }

        return null;
    }

    @Override
    public void deleteSemesterById(int id) {
        Optional<Semester> semester = semesterRepository.findById(id);
        if(semester.isPresent()){
            semesterRepository.delete(semester.get());
        }

    }

    @Override
    public List<SubjectDto> getSubjectsBySemesterId(int id) {
        Optional<Semester> semester = semesterRepository.findById(id);
        List<Subject> subjects = semester.get().getSubjects();
        List<SubjectDto> subjectDtos = new ArrayList<>();

        for (int i=0;i<subjects.size();i++){
            SubjectDto subjectDto = SubjectMapper.maptoSubjectDto(subjects.get(i),new SubjectDto());
            subjectDtos.add(subjectDto);
        }

        return subjectDtos;
    }
}
