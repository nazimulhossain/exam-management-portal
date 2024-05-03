package com.example.onlineexamportal.admin.service.impl;

import com.example.onlineexamportal.admin.dto.BatchDto;
import com.example.onlineexamportal.admin.entity.Batch;
import com.example.onlineexamportal.admin.entity.Course;
import com.example.onlineexamportal.admin.entity.Semester;
import com.example.onlineexamportal.admin.mapper.BatchMapper;
import com.example.onlineexamportal.admin.repository.BatchRepository;
import com.example.onlineexamportal.admin.repository.CourseRepository;
import com.example.onlineexamportal.admin.service.IBatchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class BatchServiceImpl implements IBatchService {

    private final CourseRepository courseRepository;
    private final BatchRepository batchRepository;
    @Override
    public boolean createBatch(String courseName, BatchDto batchDto) {
        boolean isCreated = false;
        Optional<Batch> batch = batchRepository.findByBatchName(batchDto.getBatchName());
        if(batch.isPresent()){
            return isCreated;
        }
        Optional<Course> course = courseRepository.findByCourseName(courseName);
        if(course.isPresent()){
            Batch newBatch = BatchMapper.mapToBatch(batchDto,new Batch());
            course.get().addBatches(newBatch);
            batchRepository.save(newBatch);
            isCreated = true;

        }

        return isCreated;



    }

    @Override
    public BatchDto getSingleBatch(String batchName) {
            Optional<Batch> batch = batchRepository.findByBatchName(batchName);
            if(batch.isPresent()){
                BatchDto batchDto = BatchMapper.mapToBatchDto(batch.get(),new BatchDto());
                return batchDto;
            }


        return null;
    }

    @Override
    public Boolean editBatch(String courseName,BatchDto batchDto) {
        boolean isUpdated = false;
        Optional<Batch> batch = batchRepository.findById(Integer.valueOf(batchDto.getBatchId()));
        if(batch.isPresent()){
            Batch batch1 = BatchMapper.mapToBatch(batchDto,batch.get());
            Optional<Course> course = courseRepository.findByCourseName(courseName);
            batchRepository.save(batch1);
            isUpdated = true;
        }

        return isUpdated;
    }

    @Override
    public List<BatchDto> getAllBatch(String courseName) {
        Optional<Course> course = courseRepository.findByCourseName(courseName);
        List<Batch> batches = new ArrayList<>();
        List<BatchDto> batchDtos = new ArrayList<>();
        if(course.isPresent()){
            batches = course.get().getBatches();
            for (int i=0;i<batches.size();i++){
                BatchDto batchDto = BatchMapper.mapToBatchDto(batches.get(i),new BatchDto());
                batchDtos.add(batchDto);
            }

        }




        return batchDtos;
    }

    @Override
    public List<BatchDto> findAllBatches() {
        List<Batch> batches = batchRepository.findAll();
        List<BatchDto> batchDtos = new ArrayList<>();
        for(int i=0;i<batches.size();i++){
            BatchDto batchDto = BatchMapper.mapToBatchDto(batches.get(i),new BatchDto());
            batchDtos.add(batchDto);
        }
        return batchDtos;
    }

    @Override
    public void deleteBatch(int batchId) {
        Optional<Batch> batch = batchRepository.findById(batchId);
        if(batch.isPresent()){
            batch.get().setCourses(null);
            batchRepository.delete(batch.get());
        }
    }

    @Override
    public void addSemester(String courseName, String batchName) {
        Optional<Course> course = courseRepository.findByCourseName(courseName);
        Optional<Batch> batch = batchRepository.findByBatchName(batchName);

        if(batch.isPresent()){
            BatchDto batchDto = BatchMapper.mapToBatchDto(batch.get(),new BatchDto());
            System.out.println(batchDto);
        }


    }
}
