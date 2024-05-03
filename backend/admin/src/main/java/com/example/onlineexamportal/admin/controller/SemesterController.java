package com.example.onlineexamportal.admin.controller;

import com.example.onlineexamportal.admin.dto.CourseDto;
import com.example.onlineexamportal.admin.dto.ResponseDto;
import com.example.onlineexamportal.admin.dto.SemesterDto;
import com.example.onlineexamportal.admin.dto.SubjectDto;
import com.example.onlineexamportal.admin.entity.Semester;
import com.example.onlineexamportal.admin.entity.Subject;
import com.example.onlineexamportal.admin.mapper.SemesterMapper;
import com.example.onlineexamportal.admin.service.ISemesterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/admin/semesters",produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*")
@Slf4j
public class SemesterController {

    private final ISemesterService iSemesterService;

    @PostMapping("/{courseName}")
    public ResponseEntity<ResponseDto> createSemester(@PathVariable String courseName,@RequestBody SemesterDto semesterDto){
        boolean isCreated = iSemesterService.createSemesterByCourse(courseName,semesterDto);
        if(isCreated){
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(201,"Semester created successfully"));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(400,"Semester not created"));

    }

    @GetMapping("/{courseName}")
    public ResponseEntity<List<SemesterDto>> getAllSemestersByCourse(@PathVariable String courseName){
        List<SemesterDto> semesterDtos = iSemesterService.getAllSemestersByCourse(courseName);

        return ResponseEntity.status(HttpStatus.OK).body(semesterDtos);


    }

    @GetMapping("/")
    public ResponseEntity<List<SemesterDto>> getAllSemesters(){
        List<SemesterDto> semesterDtos = iSemesterService.getAllSemesters();
        return ResponseEntity.status(HttpStatus.OK).body(semesterDtos);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateSemester(@PathVariable String id,@RequestBody SemesterDto semesterDto){
        boolean isUpdated = iSemesterService.updateSemester(Integer.valueOf(id),semesterDto);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(201,"Semester updated successfully"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(400,"Semester not updated"));

    }

    @PutMapping("/addSemesters/{id}")
    public ResponseEntity<ResponseDto> addSemestersToCourse(@PathVariable String id,@RequestBody CourseDto courseName){
        boolean isAdded = iSemesterService.addSemestersToCourse(Integer.valueOf(id),courseName);
        if(isAdded){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(200,"Semesters added top course"));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(400,"Semester not added"));


    }

    @GetMapping("/id/{id}")
    public SemesterDto getSemesterById(@PathVariable String id){
        return iSemesterService.getSemesterById(Integer.valueOf(id));
    }

    @DeleteMapping("/id/{id}")
    public void deleteSemesterByID(@PathVariable String id){
        iSemesterService.deleteSemesterById(Integer.valueOf(id));
    }

    @PutMapping("/{id}/subjects")
    public void addSubjectToSemester(@PathVariable String id, @RequestBody SubjectDto subjectDto){

        iSemesterService.addSubjectToSemesters(Integer.valueOf(id),subjectDto);

    }

    @GetMapping("/subjects/{id}")
    public List<SubjectDto> getSubjectsBySemesterId(@PathVariable String id){
        return iSemesterService.getSubjectsBySemesterId(Integer.valueOf(id));

    }
}
