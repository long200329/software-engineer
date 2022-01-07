package com.se.software_engineer.service.Impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.software_engineer.entity.*;
import com.se.software_engineer.mapper.*;
import com.se.software_engineer.service.CourseService;
import com.se.software_engineer.service.ScoreService;
import com.se.software_engineer.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;
    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private CourseScoreMapper courseScoreMapper;
    @Resource
    private ScoreMapper scoreMapper;
    @Resource
    private ScoreService scoreService;
    @Resource
    private AttendanceMapper attendanceMapper;
    @Resource
    private UserService userService;

    public int createCourse(JSONObject object){
        Course course = new Course();
        course.setCourseName(object.getStr("courseName"));
        course.setChargingTeacherId(object.getStr("chargingTeacherId"));
        course.setSchedule(object.getStr("schedule"));
        course.setState("Inactive");
        course.setTeacherId("teacherId");
        course.setCourseId(object.getStr("courseId"));

        courseMapper.insert(course);

        CourseScore courseScore = new CourseScore();
        courseScore.setCourseId(object.getStr("courseId"));
        courseScore.setAttendanceWeight(BigDecimal.ZERO);
        courseScore.setExperimentWeight(BigDecimal.ZERO);
        courseScore.setPracticeWeight(BigDecimal.ZERO);
        courseScore.setExperimentTotalScore(BigDecimal.ZERO);
        courseScore.setPracticeTotalScore(BigDecimal.ZERO);
        courseScoreMapper.insert(courseScore);

        JSONArray list = object.getJSONArray("studentList");

        createPermission(list,object.getStr("courseId"));
        return 1;
    }

    public int createPermission(JSONArray array,String courseId){
        for(int i=0;i<array.size();i++){
            JSONObject object = array.getJSONObject(i);
            Permission permission = new Permission();
            permission.setCourseId(courseId);
            permission.setId(object.getStr("id"));
            permission.setUserPermission(object.getStr("userPermission"));
            permissionMapper.insert(permission);


                Score score = new Score();
                score.setCourseId(courseId);
                score.setId(permission.getId());
                score.setAttendanceScore(new BigDecimal(0.00));
                score.setExperimentScore(new BigDecimal(0.00));
                score.setPracticeScore(new BigDecimal(0.00));
                score.setTotalScore(new BigDecimal(0.00));
                scoreMapper.insert(score);

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
        JSONArray arr = new JSONArray();

        for(int i=0;i<array.size();i++){
            JSONObject object = array.getJSONObject(i);
            JSONObject object1 = new JSONObject();
            object1.put("courseId",object.getStr("CourseId"));
            object1.put("courseName",object.getStr("courseName"));
            arr.add(object1);
        }

        return arr;
    }

    public int attend(String courseId,String id){
        Attendance attendance = new Attendance();
        attendance.setId(id);
        attendance.setCourseId(courseId);

        Date recordTime = new Date();
        recordTime.setHours(recordTime.getHours()+8);

        attendance.setLoginTime(recordTime);

        QueryWrapper<Score>scoreQueryWrapper = new QueryWrapper<>();
        scoreQueryWrapper.eq("course_id",courseId).eq("id",id);
        Score score = scoreMapper.selectOne(scoreQueryWrapper);

        if(score.getAttendanceScore().compareTo(new BigDecimal(100))==-1){
            score.setAttendanceScore(score.getAttendanceScore().add(new BigDecimal(10.00)));
            scoreMapper.update(score,scoreQueryWrapper);
            scoreService.calculateScore(id,courseId);
        }

        return attendanceMapper.insert(attendance);

    }

    public String getCourseName(String courseId){
        QueryWrapper<Course>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        Course course = courseMapper.selectOne(queryWrapper);
        return course.getCourseName();
    }

    public List getPermissions(String courseId){
        QueryWrapper<Permission>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        List list = permissionMapper.selectList(queryWrapper);

        List perimissionList = new JSONArray();
        for(int i=0;i<list.size();i++){
            JSONObject object = new JSONObject();
            Permission permission = (Permission) list.get(i);
            object.put("permission",permission.getUserPermission());
            object.put("id",permission.getId());
            object.put("name",userService.getUserName(permission.getId()));
            perimissionList.add(object);
        }
        return perimissionList;
    }

}
