package com.example.xsystem05.service;

import com.example.xsystem05.entity.AIoTEntity;
import com.example.xsystem05.mapper.AIoTEntityMapper;
import com.example.xsystem05.mapper.AIoTEntityMapper02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class AIoTService {
     @Autowired
    private AIoTEntityMapper aIoTEntityMapper;
     @Autowired
     private AIoTEntityMapper02 aIoTEntityMapper02;

     @Scheduled(fixedRate = 5000)
    public void insertAIoTData() {
        AIoTEntity entity1 = new AIoTEntity();
        AIoTEntity entity2 = new AIoTEntity();

        String address1 = "华中师范大学";
        String address2 = "上海";

        String data01 = "";
        String sensor_id_01 = "6500372502c946447751ea00_sensor";


        httpGetHuaweiIOT iotController = null;
        try {
            iotController = new httpGetHuaweiIOT();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            data01 = iotController.getdev(sensor_id_01,"shadow","radiation");
            Double radiation = Double.parseDouble(data01);

            entity1.setRadiation(radiation);
            entity1.setTime(new Timestamp(System.currentTimeMillis()));
            entity1.setAddress(address1);
            aIoTEntityMapper.insertAIoTEntity(entity1);

            entity2.setAddress(address2);
            entity2.setRadiation(radiation);
            entity2.setTime(new Timestamp(System.currentTimeMillis()));
            aIoTEntityMapper02.insertIoT2(entity2);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
