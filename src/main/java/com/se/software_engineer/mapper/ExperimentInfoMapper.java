package com.se.software_engineer.mapper;

import com.se.software_engineer.entity.ExperimentInfo;
import com.se.software_engineer.entity.ExperimentInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;



@Repository
@Mapper
public interface ExperimentInfoMapper extends BaseMapper<ExperimentInfo>{
    Integer maxId();
}