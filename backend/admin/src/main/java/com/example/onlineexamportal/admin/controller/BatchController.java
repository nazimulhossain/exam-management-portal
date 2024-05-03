package com.example.onlineexamportal.admin.controller;

import com.example.onlineexamportal.admin.dto.BatchDto;
import com.example.onlineexamportal.admin.dto.CourseDto;
import com.example.onlineexamportal.admin.dto.ResponseDto;
import com.example.onlineexamportal.admin.service.IBatchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = {"/api/admin/batches"},produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*")
@Slf4j
public class BatchController {

    @Autowired
    private final IBatchService iBatchService;

    @PostMapping("/{courseName}")
    public ResponseEntity<ResponseDto> createBatch(@PathVariable String courseName, @RequestBody BatchDto batchDto){
      boolean isCreated =  iBatchService.createBatch(courseName,batchDto);
      if(isCreated){
          return ResponseEntity.status(HttpStatus.CREATED)
                  .body(new ResponseDto(201,"Batch created successfully"));

      }
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ResponseDto(400,"Batch already exists"));


    }

    @GetMapping("/{courseName}")
    public ResponseEntity<List<BatchDto>> getAllBatches(@PathVariable String courseName){
        List<BatchDto> batchDtos = iBatchService.getAllBatch(courseName);
        return ResponseEntity.status(HttpStatus.OK)
                .body(batchDtos);

    }

    @GetMapping("/batch/{batchName}")
    public ResponseEntity<BatchDto> getSingleBatch(@PathVariable String batchName){
        BatchDto batchDto = iBatchService.getSingleBatch(batchName);
        if(batchDto!=null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(batchDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new BatchDto());

    }
    @PutMapping("/{courseName}")
    public ResponseEntity<ResponseDto> updateBatch(@PathVariable String courseName, @RequestBody BatchDto batchDto){
        boolean isUpdated = iBatchService.editBatch(courseName,batchDto);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseDto(200,"Batch updated successfully"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(400,"Course not updated"));
    }

    @DeleteMapping("/{batchId}")
    public ResponseEntity<ResponseDto> deleteBatch(@PathVariable String batchId){
        iBatchService.deleteBatch(Integer.valueOf(batchId));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(204,"Batch Deleted Successfully"));
    }

    @GetMapping("/")
    public ResponseEntity<List<BatchDto>> findAllBacthes(){
        List<BatchDto> batchDtos = iBatchService.findAllBatches();
        return ResponseEntity.status(HttpStatus.OK).body(batchDtos);
    }




}
