package com.se.software_engineer.mapper;

import com.se.software_engineer.entity.AttendanceExample;
import com.se.software_engineer.entity.Attendance;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;



@Repository
@Mapper
public interface AttendanceMapper extends BaseMapper<Attendance>{

}