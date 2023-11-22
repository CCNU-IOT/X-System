package com.example.xsystem05.mapper;

import com.example.xsystem05.entity.AIoTEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AIoTEntityMapper {
    @Insert("insert into iot1 (radiation, time,address) values (#{radiation},#{time},#{address})")
    void insertAIoTEntity(AIoTEntity entity);

    @Select("select * from iot1 order by id desc limit 1")
    AIoTEntity selectIoT1();
}

