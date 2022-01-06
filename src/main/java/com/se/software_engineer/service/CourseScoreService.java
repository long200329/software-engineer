package com.se.software_engineer.service;

public interface CourseScoreService {
    void addExperimentScore(String courseId);
    int putCourseScore(String courseId,Double attendanceWeight,Double experimentWeight,Double practiceWeight);
}
