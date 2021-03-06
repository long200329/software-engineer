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

    @GetMapping("/courses")
    public CommonResult getCourses(@RequestParam String id){
        if(id == null)
            return CommonResult.failure("错误，缺少id");
        return CommonResult.success("查询成功",courseService.getCourses(id));
    }

    @PostMapping("/attend")
    public CommonResult attend(@RequestParam String id,@RequestParam String courseId){
        if(id == null)
            return CommonResult.failure("错误，缺少id");
        if(courseId == null)
            return CommonResult.failure("错误，缺少courseId");

        if(courseService.attend(courseId,id)>0)
            return CommonResult.success("记录考勤成功",null);

        return CommonResult.failure("记录考勤失败");
    }

    @GetMapping("/permission")
    public CommonResult getPermissionList(@RequestParam String courseId){
        if(courseId==null)
            return CommonResult.failure("查询失败，缺少课程id");
        return CommonResult.success("查询成功",courseService.getPermissions(courseId));
    }

    @GetMapping("/course")
    public CommonResult getCourse(@RequestParam String courseId){
        if(courseId==null)
            return CommonResult.failure("查询失败，缺少课程id");
        return CommonResult.success("查询成功",courseService.getCourse(courseId));
    }

    @GetMapping("/permission/user")
    public CommonResult getPermission(@RequestParam String courseId,@RequestParam String id) {
        if (courseId == null)
            return CommonResult.failure("查询失败，缺少课程id");
        if (id == null)
            return CommonResult.failure("错误，缺少id");
        return CommonResult.success("查询成功", courseService.getPermission(courseId, id));

    }
}
