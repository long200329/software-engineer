package com.se.software_engineer.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("course")
@Data
public class Course {
    @TableId
    private Integer courseId;

    private String chargingTeacherId;

    private String teacherId;

    private String state;

    private String schedule;


    private String courseName;


}