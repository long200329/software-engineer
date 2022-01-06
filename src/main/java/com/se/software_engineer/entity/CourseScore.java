package com.se.software_engineer.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("course_score")
@Data
public class CourseScore {
    @TableId
    private String courseId;

    private BigDecimal attendanceWeight;

    private BigDecimal experimentWeight;

    private BigDecimal practiceWeight;

    private BigDecimal practiceTotalScore;

    private BigDecimal experimentTotalScore;


}