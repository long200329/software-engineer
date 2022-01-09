package com.se.software_engineer.service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.software_engineer.entity.CourseScore;
import com.se.software_engineer.entity.Permission;
import com.se.software_engineer.mapper.CourseScoreMapper;
import com.se.software_engineer.mapper.PermissionMapper;
import com.se.software_engineer.service.CourseScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class CourseScoreServiceImpl implements CourseScoreService {
    @Resource
    private CourseScoreMapper courseScoreMapper;
    @Resource
    private PermissionMapper permissionMapper;

    public void addExperimentScore(String courseId){
        QueryWrapper <CourseScore>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        CourseScore courseScore = courseScoreMapper.selectOne(queryWrapper);
        BigDecimal bigDecimal = courseScore.getExperimentTotalScore().add(new BigDecimal(100.00));


        courseScore.setExperimentTotalScore(bigDecimal);

        courseScoreMapper.update(courseScore,queryWrapper);
        return ;
    }
    public int putCourseScore(String courseId,Double attendanceWeight,Double experimentWeight,Double practiceWeight){
        QueryWrapper<CourseScore>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        CourseScore courseScore = courseScoreMapper.selectOne(queryWrapper);
        courseScore.setPracticeWeight(new BigDecimal(practiceWeight));
        courseScore.setExperimentWeight(new BigDecimal(experimentWeight));
        courseScore.setAttendanceWeight(new BigDecimal(attendanceWeight));




        return courseScoreMapper.update(courseScore,queryWrapper);

    }

    public CourseScore getCourseScore(String courseId){
        QueryWrapper<CourseScore>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        return courseScoreMapper.selectOne(queryWrapper);
    }

}
