package com.se.software_engineer.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("file")
@Data
public class File {

    @TableId
    private Integer fileId;

    private String fileName;

    private  String primaryIndex;

    private  String secondaryIndex;

    private String tertiaryIndex;

    private String url;
}
