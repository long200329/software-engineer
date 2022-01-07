package com.se.software_engineer.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.software_engineer.entity.Notice;
import com.se.software_engineer.mapper.NoticeMapper;
import com.se.software_engineer.service.CourseService;
import com.se.software_engineer.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;
    @Resource
    private CourseService courseService;
    public int createNotice(String noticeTittle,String noticeContent,String courseId){
        Integer noticeId = noticeMapper.maxId();
        if(noticeId==null)
            noticeId = 1;
        else noticeId++;

        Notice notice = new Notice();
        notice.setNoticeId(noticeId);
        notice.setNoticeContent(noticeContent);
        notice.setNoticeTittle(noticeTittle);
        notice.setCourseName(courseService.getCourseName(courseId));
        notice.setCourseId(courseId);

        Date recordTime = new Date();
        recordTime.setHours(recordTime.getHours()+8);
        notice.setDate(recordTime);

        return noticeMapper.insert(notice);
    }

    public List getNotices(String courseId){
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_id",courseId);
        List list = noticeMapper.selectList(queryWrapper);
        Collections.reverse(list);
        return list;
    }
}
