package com.example.xsystem05.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AIoTEntity {
    private int id;
    private Double radiation;
    private Timestamp time;
    private String address;

}