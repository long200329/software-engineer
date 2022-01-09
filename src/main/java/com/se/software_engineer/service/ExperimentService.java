package com.se.software_engineer.service;

import cn.hutool.json.JSONArray;
import com.se.software_engineer.entity.ExperimentInfo;
import com.se.software_engineer.entity.ExperimentSubmission;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ExperimentService {
    int createExperiment(ExperimentInfo experimentInfo);
    List getExperiments(String courseId);
    ExperimentInfo getExperiment(String courseId,Integer experimentId);
    int createReport(ExperimentSubmission experimentSubmission, MultipartFile file)throws IOException;
    String uploadReport(String courseId,Integer ExperimentId,MultipartFile file)throws IOException;
    ExperimentSubmission getReport(String id,String courseId,int experimentId);
    int putReport(String id,String courseId,int experimentId,String correctorId,String correctorName,Double score);
    String getReportScore(String id,String courseId,Integer experimentId);
    JSONArray getReports(String courseId,String id);
}
