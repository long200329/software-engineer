package com.se.software_engineer.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("feedback")
@Data
public class Feedback {
    @TableId
    private String feedbackId;

    private Integer courseId;

    private String id;

    private String feedbackContent;

    private Date date;


}