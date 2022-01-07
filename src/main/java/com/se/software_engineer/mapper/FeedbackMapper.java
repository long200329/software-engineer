package com.se.software_engineer.mapper;

import com.se.software_engineer.entity.Feedback;
import com.se.software_engineer.entity.FeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;



@Repository
@Mapper
public interface FeedbackMapper extends BaseMapper<Feedback>{
 Integer maxId();
}