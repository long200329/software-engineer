package com.se.software_engineer.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("feedback")
@Data
public class Feedback {
    @TableId
    private Integer feedbackId;

    private String courseId;

    private String id;

    private String feedbackContent;

    private Date date;


}