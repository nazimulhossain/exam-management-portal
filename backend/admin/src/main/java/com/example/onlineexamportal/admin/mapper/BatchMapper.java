package com.example.onlineexamportal.admin.mapper;

import com.example.onlineexamportal.admin.dto.BatchDto;
import com.example.onlineexamportal.admin.entity.Batch;

public class BatchMapper {
    public static BatchDto mapToBatchDto(Batch batch,BatchDto batchDto){
        batchDto.setBatchId(batch.getBatchId());
        batchDto.setBatchName(batch.getBatchName());
        batchDto.setBatchCode(batch.getBatchCode());
        batchDto.setBatchDescription(batch.getBatchDescription());
        return batchDto;
    }

    public static Batch mapToBatch(BatchDto batchDto,Batch batch){
        batch.setBatchName(batchDto.getBatchName());
        batch.setBatchCode(batchDto.getBatchCode());
        batch.setBatchDescription(batchDto.getBatchDescription());
        return batch;
    }
}
