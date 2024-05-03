package com.example.onlineexamportal.admin.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/admin/questions",produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*")
@Slf4j
public class QustionController {
}
