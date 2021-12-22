package com.se.software_engineer.mapper;

import com.se.software_engineer.entity.PracticeInfo;
import com.se.software_engineer.entity.PracticeInfoExample;
import java.util.List;

import com.se.software_engineer.entity.PracticeProblem;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;



@Repository
@Mapper
public interface PracticeInfoMapper extends BaseMapper<PracticeInfo> {

}