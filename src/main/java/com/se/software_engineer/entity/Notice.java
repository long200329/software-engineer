package com.se.software_engineer.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("notice")
@Data
public class Notice {
    @TableId
    private String noticeId;

    private String courseId;

    private String courseName;

    private String noticeTittle;

    private String noticeContent;

    private Date date;


}