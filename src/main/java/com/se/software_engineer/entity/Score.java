package com.se.software_engineer.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("score")
@Data
public class Score {
    @TableId
    private String courseId;
    @TableId
    private String id;

    private BigDecimal attendanceScore;

    private BigDecimal experimentScore;

    private BigDecimal practiceScore;

    private BigDecimal totalScore;


}