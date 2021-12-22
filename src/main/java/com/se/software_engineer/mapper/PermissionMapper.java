package com.se.software_engineer.mapper;

import com.se.software_engineer.entity.Permission;
import com.se.software_engineer.entity.PermissionExample;
import com.se.software_engineer.entity.PermissionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;



@Repository
@Mapper
public interface PermissionMapper extends BaseMapper<Permission>{

}