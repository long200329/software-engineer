package com.se.software_engineer.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("permission")
@Data
public class Permission  {
    @TableId
    private String id;
    @TableId
    private Integer courseId;

    private String userPermission;

}