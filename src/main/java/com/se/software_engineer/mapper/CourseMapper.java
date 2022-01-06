package com.se.software_engineer.mapper;

import com.se.software_engineer.entity.Course;
import com.se.software_engineer.entity.CourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;



@Repository
@Mapper
public interface CourseMapper extends BaseMapper<Course>{
    Integer maxId();
    List getCourseById(String id);
}
