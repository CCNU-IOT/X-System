package com.example.xsystem05.controller;

import com.example.xsystem05.entity.AIoTEntity;
import com.example.xsystem05.mapper.AIoTEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SelectController {

    @Autowired
    private AIoTEntityMapper aIoTEntityMapper;

    @GetMapping("/latest")
    public AIoTEntity getLatestData(){
        return aIoTEntityMapper.selectIoT1();
    }
}
