package com.se.software_engineer.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("practice_group")
@Data
public class PracticeGroup {
    @TableId
    private String practiceId;
    @TableId
    private Integer groupNum;
    @TableId
    private String id;


}