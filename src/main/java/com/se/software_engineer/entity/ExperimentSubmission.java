package com.se.software_engineer.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("experiment_submission")
@Data
public class ExperimentSubmission  {
    @TableId
    private Integer experimentId;
    @TableId
    private String courseId;

    private String id;

    private Date submissionTime;

    private String type;

    private String content;

    private BigDecimal score;

    private String correctorId;

    private String correctorName;


}