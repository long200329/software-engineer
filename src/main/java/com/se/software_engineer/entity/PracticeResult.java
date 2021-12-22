package com.se.software_engineer.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@Data
@TableName("practice_result")
public class PracticeResult  {
    @TableId
    private String practiceId;
    @TableId
    private String id;

    private Integer courseId;

    private BigDecimal score;

    private String answer;


}