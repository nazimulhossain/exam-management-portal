package com.example.onlineexamportal.admin.controller;

import com.example.onlineexamportal.admin.dto.CourseDto;
import com.example.onlineexamportal.admin.dto.ResponseDto;
import com.example.onlineexamportal.admin.service.ICourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/admin/courses",produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*")
@Slf4j
public class CourseController {


    private final ICourseService iCourseService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCourse(@RequestBody CourseDto courseDto){
        boolean isCreated = iCourseService.createCourse(courseDto);
        if(isCreated){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseDto(201,"Course Created"));

        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseDto(400,"Course Already existed"));



    }


    @GetMapping("/{courseName}")
    public ResponseEntity<CourseDto> getCourse(@PathVariable String courseName){

        CourseDto courseDto = iCourseService.getCourse(courseName);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(courseDto);


    }

    @GetMapping("/all")
    public ResponseEntity<List<CourseDto>> getAllCourses(){
        List<CourseDto> courseDtos = iCourseService.getAllCourses();
        return ResponseEntity.status(HttpStatus.OK)
                .body(courseDtos);

    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCourse(@RequestBody CourseDto courseDto){
        log.info(courseDto.toString());
        boolean isUpdated = iCourseService.updateCourse(courseDto);
        if (isUpdated){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseDto(201,"Course Updated Successfully"));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseDto(404,"Course not found"));

    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<ResponseDto> deleteCourse(@PathVariable String courseId){
        boolean isDeleted = iCourseService.deleteCourse(courseId);
        if(isDeleted)
        {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(new ResponseDto(202,"Course Deleted Successfully"));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseDto(404,"Course not found"));


    }




}
