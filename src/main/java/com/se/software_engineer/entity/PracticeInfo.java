package com.se.software_engineer.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("practice_info")
@Data
public class PracticeInfo {
    @TableId
    private String practiceId;

    private Integer courseId;

    private Date deadline;

    private String state;

    private String practiceName;
}