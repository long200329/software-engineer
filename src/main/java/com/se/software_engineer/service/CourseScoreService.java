package com.se.software_engineer.service;

import com.se.software_engineer.entity.CourseScore;

public interface CourseScoreService {
    void addExperimentScore(String courseId);
    int putCourseScore(String courseId,Double attendanceWeight,Double experimentWeight,Double practiceWeight);
    CourseScore getCourseScore(String courseId);
}
