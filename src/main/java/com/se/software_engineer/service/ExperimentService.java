package com.se.software_engineer.service;

import cn.hutool.json.JSONArray;
import com.se.software_engineer.entity.ExperimentInfo;

import java.util.List;

public interface ExperimentService {
    int createExperiment(ExperimentInfo experimentInfo);
    List getExperiments(Integer courseId);
    ExperimentInfo getExperiment(Integer courseId,Integer experimentId);
}
