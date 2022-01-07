package com.se.software_engineer.mapper;

import com.se.software_engineer.entity.ExperimentSubmission;
import com.se.software_engineer.entity.ExperimentSubmissionExample;
import com.se.software_engineer.entity.ExperimentSubmissionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;



@Repository
@Mapper
public interface ExperimentSubmissionMapper extends BaseMapper<ExperimentSubmission>{
    Integer getReportScore(String id,String courseId,Integer experimentId);
}