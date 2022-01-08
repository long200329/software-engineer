package com.se.software_engineer.service;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.se.software_engineer.entity.Course;

import java.util.List;

public interface CourseService {
    int createCourse(JSONObject object);
    int createPermission(JSONArray array,String courseId);
    JSONArray getCourses(String id);
    int attend(String courseId,String id);
    String getCourseName(String courseId);
    List getPermissions(String courseId);
    Course getCourse(String courseId);
}
