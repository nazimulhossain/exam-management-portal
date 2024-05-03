package com.example.onlineexamportal.admin.controller;

import com.example.onlineexamportal.admin.dto.ResponseDto;
import com.example.onlineexamportal.admin.dto.SubjectDto;
import com.example.onlineexamportal.admin.service.ISubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/admin/subjects",produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*")
public class SubjectController {

    private final ISubjectService iSubjectService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createSubject(@RequestBody SubjectDto subjectDto){
        boolean isCreated = iSubjectService.createSubject(subjectDto);
        if(isCreated){
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(201,"Subject Created Successfully"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(400,"Subject not created"));
    }

    @GetMapping("/")
    public ResponseEntity<List<SubjectDto>> getAllSubjects(){
        List<SubjectDto> subjectDto = iSubjectService.getAllSubjects();
        return ResponseEntity.status(HttpStatus.OK).body(subjectDto);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateSubject(@PathVariable String id,@RequestBody SubjectDto subjectDto){
        boolean isUpdated = iSubjectService.updateSubject(Integer.valueOf(id),subjectDto);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(200,"Subject updated successfully"));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(400,"Subject not updated"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteSubject(@PathVariable String id){
        iSubjectService.deleteSubject(Integer.valueOf(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseDto(204,"Subject deleted successfully"));

    }


}
