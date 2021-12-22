package com.se.software_engineer.Controller;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONObject;
import com.se.software_engineer.entity.CommonResult;

import com.se.software_engineer.entity.ExperimentInfo;
import com.se.software_engineer.service.ExperimentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin("*")
public class ExperimentController {
    @Resource
    private ExperimentService experimentService;

    @GetMapping("/experiment")
    public CommonResult getExperiment(@RequestParam  Integer courseId){
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
    public CommonResult getExperimentInfo(@RequestParam Integer courseId,@RequestParam Integer experimentId){
        if(courseId == null)
            return CommonResult.failure("错误，缺少courseId");
        if(experimentId == null)
            return CommonResult.failure("错误，缺少experimentId");
        return CommonResult.success("查询成功",experimentService.getExperiment(courseId,experimentId));
    }

}
