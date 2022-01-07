package com.se.software_engineer.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.software_engineer.entity.Feedback;
import com.se.software_engineer.mapper.FeedbackMapper;
import com.se.software_engineer.service.FeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private FeedbackMapper feedbackMapper;

    public int createFeedback(String id,String courseId,String feedbackContent){

        Date recordTime = new Date();
        recordTime.setHours(recordTime.getHours()+8);

        Feedback feedback = new Feedback();
        feedback.setDate(recordTime);

        Integer feedbackId = feedbackMapper.maxId();
        if(feedbackId ==null)
            feedbackId = 1;
        else feedbackId++;
        feedback.setFeedbackId(feedbackId);
        feedback.setFeedbackContent(feedbackContent);
        feedback.setId(id);
        feedback.setCourseId(courseId);
        return feedbackMapper.insert(feedback);
    }

    public List getCourseFeedbacks(String courseId){
        QueryWrapper<Feedback> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        List list = feedbackMapper.selectList(queryWrapper);
        Collections.reverse(list);
        return list;
    }
    public List getStudentFeedbacks(String courseId,String id){
        QueryWrapper<Feedback> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId).eq("id",id);
        List list = feedbackMapper.selectList(queryWrapper);
        Collections.reverse(list);
        return list;
    }
}
