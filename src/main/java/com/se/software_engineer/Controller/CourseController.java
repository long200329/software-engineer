package com.se.software_engineer.Controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONObject;
import com.se.software_engineer.entity.CommonResult;
import com.se.software_engineer.service.CourseService;
import com.se.software_engineer.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin("*")
public class CourseController {

    @Resource
    private CourseService courseService;

    @PostMapping("/course")
    public CommonResult createCourse(@RequestBody JSONObject object){
        if(object == null)
            return CommonResult.failure("错误，缺少信息");
        int code = courseService.createCourse(object);
        return CommonResult.success("创建成功",code);
    }

    @GetMapping("/course")
    public CommonResult getCourses(@RequestParam String id){
        if(id == null)
            return CommonResult.failure("错误，缺少id");
        return CommonResult.success("查询成功",courseService.getCourses(id));
    }
}
