package com.se.software_engineer.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "user")
@Data
public class User {
    @TableId
    private String id;

    private String email;

    private String name;

    private String password;

    private String institute;

    private String identification;

    private String state;


}