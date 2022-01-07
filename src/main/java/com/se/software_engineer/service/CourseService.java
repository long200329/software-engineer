package com.se.software_engineer.service;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

import java.util.List;

public interface CourseService {
    int createCourse(JSONObject object);
    int createPermission(JSONArray array,String courseId);
    JSONArray getCourses(String id);
    int attend(String courseId,String id);
    String getCourseName(String courseId);
}
