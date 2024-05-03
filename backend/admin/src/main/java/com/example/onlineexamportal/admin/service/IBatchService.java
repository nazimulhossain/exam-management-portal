package com.example.onlineexamportal.admin.service;

import com.example.onlineexamportal.admin.dto.BatchDto;

import java.util.List;

public interface IBatchService {

    boolean createBatch(String courseName, BatchDto batchDto);

    BatchDto getSingleBatch(String batchName);

    Boolean editBatch(String courseName,BatchDto batchDto);

    List<BatchDto> getAllBatch(String courseName);

    List<BatchDto> findAllBatches();

    void deleteBatch(int batchId);

    void addSemester(String courseName, String batchName);

}
