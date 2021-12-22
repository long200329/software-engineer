package com.se.software_engineer.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("experiment_info")
@Data
public class ExperimentInfo {
    @TableId
    private Integer experimentId;

    private Integer courseId;

    private String teacher;

    private String description;

    private String template;

    private String submissionMethod;

    private Date startTime;

    private Date deadline;

    private String experimentName;
}