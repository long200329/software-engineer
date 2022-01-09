package com.se.software_engineer.Controller;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONObject;
import com.se.software_engineer.entity.CommonResult;

import com.se.software_engineer.entity.ExperimentInfo;
import com.se.software_engineer.entity.ExperimentSubmission;
import com.se.software_engineer.service.ExperimentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

@RestController
@CrossOrigin("*")
public class ExperimentController {
    @Resource
    private ExperimentService experimentService;



    @GetMapping("/experiment")
    public CommonResult getExperiment(@RequestParam  String courseId){
        if(courseId == null)
            return CommonResult.failure("错误，缺少courseId");

        return CommonResult.success("查询成功",experimentService.getExperiments(courseId));
    }

    @PostMapping("/experiment")
    public CommonResult createExperiment(@RequestBody ExperimentInfo experimentInfo){
        int id = experimentService.createExperiment(experimentInfo);
        if(id>0)
            return CommonResult.success("创建成功",id);
        else
            return CommonResult.failure("创建失败");
    }

    @GetMapping("/experimentInfo")
    public CommonResult getExperimentInfo(@RequestParam String courseId,@RequestParam Integer experimentId){
        if(courseId == null)
            return CommonResult.failure("错误，缺少courseId");
        if(experimentId == null)
            return CommonResult.failure("错误，缺少experimentId");
        return CommonResult.success("查询成功",experimentService.getExperiment(courseId,experimentId));
    }

    @PostMapping("/report")
    public CommonResult postReport(@RequestParam String courseId, @RequestParam String id, @RequestParam Integer experimentId,
                                   @RequestPart (required = false) MultipartFile file,@RequestParam String type,@RequestParam (required = false) String content )throws IOException {
        ExperimentSubmission experimentSubmission = new ExperimentSubmission();
        experimentSubmission.setCourseId(courseId);
        experimentSubmission.setId(id);
        experimentSubmission.setExperimentId(experimentId);
        if(content!=null)
            experimentSubmission.setContent(content);
        experimentSubmission.setType(type);
        Date recordTime = new Date();
        recordTime.setHours(recordTime.getHours()+8);
        experimentSubmission.setSubmissionTime(recordTime);
        experimentService.createReport(experimentSubmission,file);
        return CommonResult.success("上传成功",null);
    }

    @GetMapping("/report")
    public CommonResult getReport(@RequestParam String courseId,@RequestParam String id,@RequestParam Integer experimentId){
        if(courseId == null)
            return CommonResult.failure("错误，缺少courseId");
        if(experimentId == null)
            return CommonResult.failure("错误，缺少experimentId");
        if(id == null)
            return CommonResult.failure("错误，缺少id");

        return CommonResult.success("查询成功",experimentService.getReport(id,courseId,experimentId));

    }

    @PutMapping("/report")
    public CommonResult putReport(@RequestParam String courseId,@RequestParam String id,@RequestParam Integer experimentId,
                                  @RequestParam String correctorId,@RequestParam String correctorName,@RequestParam Double score){
        if(courseId == null)
            return CommonResult.failure("错误，缺少courseId");
        if(experimentId == null)
            return CommonResult.failure("错误，缺少experimentId");
        if(id == null)
            return CommonResult.failure("错误，缺少id");
        if(correctorId == null)
            return CommonResult.failure("错误，缺少correctorId");
        if(correctorName == null)
            return CommonResult.failure("错误，缺少correctorName");
        if(score == null)
            return CommonResult.failure("错误，缺少score");



        if(experimentService.putReport(id,courseId,experimentId,correctorId,correctorName,score)>0)
            return CommonResult.success("修改成功",null);
        else
            return CommonResult.failure("修改失败");
    }

    @GetMapping("/reportScore")
    public CommonResult getReportScore(@RequestParam String courseId,@RequestParam Integer experimentId,@RequestParam String id){
        if(courseId == null)
            return CommonResult.failure("错误，缺少courseId");
        if(experimentId == null)
            return CommonResult.failure("错误，缺少experimentId");
        if(id == null)
            return CommonResult.failure("错误，缺少id");
        return CommonResult.success("查询成功",experimentService.getReportScore(id,courseId,experimentId));
    }

    @GetMapping("/reports")
    public CommonResult getReports(@RequestParam String courseId,@RequestParam String id){
        if(courseId == null)
            return CommonResult.failure("错误，缺少courseId");

        if(id == null)
            return CommonResult.failure("错误，缺少id");
        return CommonResult.success("查询成功",experimentService.getReports(courseId,id));
    }

}
