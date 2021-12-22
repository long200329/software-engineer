package com.se.software_engineer.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("Attendance")
@Data
public class Attendance {
    @TableId
    private Integer courseId;
    @TableId
    private String id;
    @TableId
    private Date loginTime;


}