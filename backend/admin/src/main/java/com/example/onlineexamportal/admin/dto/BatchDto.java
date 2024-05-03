package com.example.onlineexamportal.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class BatchDto {
    private int batchId;
    private String batchName;
    private String batchCode;
    private String batchDescription;
}
