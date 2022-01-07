package com.se.software_engineer.service;

import com.se.software_engineer.entity.Notice;

import java.util.List;

public interface NoticeService {
    int createNotice(String noticeTittle,String noticeContent,String courseId);
    List getNotices(String courseId);
}
