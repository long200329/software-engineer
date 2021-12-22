package com.se.software_engineer.mapper;

import com.se.software_engineer.entity.PracticeProblem;
import com.se.software_engineer.entity.PracticeProblemExample;
import com.se.software_engineer.entity.PracticeProblemKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;



@Repository
@Mapper
public interface PracticeProblemMapper extends BaseMapper<PracticeProblem> {

}