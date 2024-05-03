package com.example.onlineexamportal.admin.service;

import com.example.onlineexamportal.admin.dto.OptionDto;

import java.util.List;

public interface IOptionService {

    List<OptionDto> getMcqOptions(int id);
}
