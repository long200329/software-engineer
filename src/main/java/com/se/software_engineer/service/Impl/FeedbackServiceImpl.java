package com.se.software_engineer.service.Impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.software_engineer.entity.Feedback;
import com.se.software_engineer.entity.User;
import com.se.software_engineer.mapper.FeedbackMapper;
import com.se.software_engineer.mapper.UserMapper;
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
    @Resource
    private UserMapper userMapper;
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
        JSONArray array = new JSONArray();
        for(int i=0;i<list.size();i++){
            Feedback feedback = (Feedback) list.get(i);
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("id",feedback.getId());
            JSONObject object = JSONUtil.parseObj(feedback);
            User user = userMapper.selectOne(userQueryWrapper);
            if(user!= null)
                object.put("name",user.getName());
            else
                object.put("name","null");
            array.add(object);
        }
        return array;
    }
    public List getStudentFeedbacks(String courseId,String id){
        QueryWrapper<Feedback> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId).eq("id",id);
        List list = feedbackMapper.selectList(queryWrapper);
        Collections.reverse(list);
        return list;
    }
}
