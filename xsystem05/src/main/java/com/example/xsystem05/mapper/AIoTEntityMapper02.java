package com.example.xsystem05.mapper;

import com.example.xsystem05.entity.AIoTEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AIoTEntityMapper02 {
    @Insert("insert into iot2 (radiation, address, time) VALUES (#{radiation},#{address},#{time})")
     void insertIoT2(AIoTEntity aIoTEntity);
}

