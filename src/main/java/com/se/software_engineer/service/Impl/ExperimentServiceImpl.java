package com.se.software_engineer.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.software_engineer.entity.ExperimentInfo;
import com.se.software_engineer.mapper.ExperimentInfoMapper;
import com.se.software_engineer.service.ExperimentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExperimentServiceImpl implements ExperimentService {
    @Resource
    private ExperimentInfoMapper experimentInfoMapper;

    public int createExperiment(ExperimentInfo experimentInfo){
        Integer num = experimentInfoMapper.maxId();
        if(num == null)
            num = 1;
        else
            num++;

        experimentInfo.setExperimentId(num);
        if(experimentInfoMapper.insert(experimentInfo)>0){
            return num;
        }
        return 0;
    }

    public List getExperiments(Integer courseId){
        QueryWrapper<ExperimentInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);

        return experimentInfoMapper.selectList(queryWrapper);
    }

    public ExperimentInfo getExperiment(Integer courseId,Integer experimentId){
        QueryWrapper<ExperimentInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId).eq("experiment_id",experimentId);
        return experimentInfoMapper.selectOne(queryWrapper);
    }
}
