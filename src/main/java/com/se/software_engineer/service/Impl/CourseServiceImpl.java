package com.se.software_engineer.service.Impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.software_engineer.entity.Course;
import com.se.software_engineer.entity.Permission;
import com.se.software_engineer.mapper.CourseMapper;
import com.se.software_engineer.mapper.PermissionMapper;
import com.se.software_engineer.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private PermissionMapper permissionMapper;

    public int createCourse(JSONObject object){
        Course course = new Course();
        course.setCourseName(object.getStr("courseName"));
        course.setChargingTeacherId(object.getStr("chargingTeacherId"));
        course.setSchedule(object.getStr("schedule"));
        course.setState("Inactive");
        course.setTeacherId("teacherId");
        course.setCourseId(object.getInt("courseId"));

        courseMapper.insert(course);

        JSONArray list = object.getJSONArray("studentList");

        createPermission(list,object.getInt("courseId"));
        return 1;
    }

    public int createPermission(JSONArray array,Integer courseId){
        for(int i=0;i<array.size();i++){
            JSONObject object = array.getJSONObject(i);
            Permission permission = new Permission();
            permission.setCourseId(courseId);
            permission.setId(object.getStr("id"));
            permission.setUserPermission(object.getStr("userPermission"));
            permissionMapper.insert(permission);
        }
        return 1;
    }

    public JSONArray getCourses(String id){
        QueryWrapper<Permission> permissionQueryWrapper = new QueryWrapper<>();
        permissionQueryWrapper.eq("id",id);
        List permissionList = permissionMapper.selectList(permissionQueryWrapper);
        JSONArray array = new JSONArray();
        for(int i=0;i<permissionList.size();i++){
            Permission permission = (Permission) permissionList.get(i);
            array.add(JSONUtil.parse(courseMapper.selectById(permission.getCourseId())));
        }
        return array;
    }

}
