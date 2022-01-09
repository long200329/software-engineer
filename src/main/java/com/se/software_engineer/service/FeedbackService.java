package com.se.software_engineer.service;

import java.util.List;

public interface FeedbackService {
    int createFeedback(String id,String courseId,String feedbackContent);
    List getCourseFeedbacks(String courseId);
    List getStudentFeedbacks(String courseId,String id);

}
