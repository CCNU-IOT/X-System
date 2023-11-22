package com.example.xsystem05;

import com.example.xsystem05.entity.AIoTEntity;
import com.example.xsystem05.mapper.AIoTEntityMapper;
import com.example.xsystem05.service.AIoTService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Xsystem05ApplicationTests {
    @Autowired
    private AIoTEntityMapper aIoTEntityMapper;

    @Test
    public void test1(){
        AIoTEntity aIoTEntity;
        aIoTEntity = aIoTEntityMapper.selectIoT1();
        System.out.println(aIoTEntity);
    }

}
