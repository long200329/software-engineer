package com.se.software_engineer.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("practice_problem")
@Data
public class PracticeProblem  {
    @TableId
    private String practiceId;
    @TableId
    private Integer number;

    private String courseId;

    private String description;

    private String type;

    private String optionOne;

    private String optionTwo;

    private String optionThree;

    private String optionFour;

    private String answer;


}