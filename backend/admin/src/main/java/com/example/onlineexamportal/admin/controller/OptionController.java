package com.example.onlineexamportal.admin.controller;

import com.example.onlineexamportal.admin.dto.OptionDto;
import com.example.onlineexamportal.admin.service.IOptionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/admin/options",produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*")
@Slf4j
public class OptionController {
    private final IOptionService iOptionService;

    @GetMapping("/id/{mcqId}")
    public ResponseEntity<List<OptionDto>> getMcqOptions(@PathVariable String mcqId){
        List<OptionDto> optionDtos = iOptionService.getMcqOptions(Integer.valueOf(mcqId));
        return ResponseEntity.status(HttpStatus.OK).body(optionDtos);
    }
}
