package com.se.software_engineer.Controller;


import com.se.software_engineer.entity.CommonResult;
import com.se.software_engineer.service.CourseScoreService;
import com.se.software_engineer.service.ScoreService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin("*")
public class ScoreController {

    @Resource
    private CourseScoreService courseScoreService;
    @Resource
    private ScoreService scoreService;
    @PutMapping("/courseScore")
    public CommonResult putCourseScore(@RequestParam String courseId, @RequestParam Double attendanceWeight,
                                       @RequestParam Double experimentWeight, @RequestParam Double practiceWeight,
                                       @RequestParam String teacherId){
        if(courseId == null)
            return CommonResult.failure("请求失败，缺少课程号");
        if(attendanceWeight== null || experimentWeight ==null || practiceWeight == null)
            return CommonResult.failure("请求失败，缺少必要成绩比重");

        if(courseScoreService.putCourseScore(courseId,attendanceWeight,experimentWeight,practiceWeight)>0) {
            scoreService.updateScores(courseId);
            return CommonResult.success("修改成绩比例成功", null);
        }
        return CommonResult.failure("修改失败");

    }

    @GetMapping("/score")
    public CommonResult getScore(@RequestParam String courseId,@RequestParam String id){
        if(courseId == null)
            return CommonResult.failure("请求失败，缺少课程号");
        if(id == null)
            return CommonResult.failure("请求失败，缺少学号");

        return CommonResult.success("查询成功",scoreService.getScore(id,courseId));
    }
}
