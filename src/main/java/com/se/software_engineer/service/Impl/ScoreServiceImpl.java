package com.se.software_engineer.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.software_engineer.entity.CourseScore;
import com.se.software_engineer.entity.Permission;
import com.se.software_engineer.entity.Score;
import com.se.software_engineer.mapper.CourseScoreMapper;
import com.se.software_engineer.mapper.PermissionMapper;
import com.se.software_engineer.mapper.ScoreMapper;
import com.se.software_engineer.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class ScoreServiceImpl implements ScoreService {
    @Resource
    private ScoreMapper scoreMapper;
    @Resource
    private CourseScoreMapper courseScoreMapper;
    @Resource
    private PermissionMapper permissionMapper;

    public int calculateScore(String id,String courseId){
        QueryWrapper<Score> scoreQueryWrapper = new QueryWrapper<>();
        QueryWrapper<CourseScore> courseScoreQueryWrapper = new QueryWrapper<>();

        scoreQueryWrapper.eq("course_id",courseId).eq("id",id);
        Score score = scoreMapper.selectOne(scoreQueryWrapper);

        courseScoreQueryWrapper.eq("course_id",courseId);
        CourseScore courseScore = courseScoreMapper.selectOne(courseScoreQueryWrapper);

        BigDecimal attendanceScore = score.getAttendanceScore().multiply(courseScore.getAttendanceWeight());
        BigDecimal experimentScore = new BigDecimal(0.00);
        BigDecimal practiceScore = new BigDecimal(0.00);
        if(courseScore.getExperimentTotalScore().compareTo(new BigDecimal(0.00))!=0){
            experimentScore = score.getExperimentScore().divide(courseScore.getExperimentTotalScore());
            log.info("first:"+experimentScore.toString());
            experimentScore = experimentScore.multiply(courseScore.getExperimentWeight());
            log.info("second:"+experimentScore.toString());
        }
        score.setTotalScore(attendanceScore.add(experimentScore));
        return scoreMapper.update(score,scoreQueryWrapper);
    }

    public void updateScores(String courseId){
        QueryWrapper<Permission>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        List list = permissionMapper.selectList(queryWrapper);

        for(int i=0;i<list.size();i++){
            Permission permission = (Permission) list.get(i);
            calculateScore(permission.getId(),courseId);
        }
        return;
    }

}
