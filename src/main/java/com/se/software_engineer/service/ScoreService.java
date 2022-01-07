package com.se.software_engineer.service;

import com.se.software_engineer.entity.Score;
import org.springframework.stereotype.Service;


public interface ScoreService {
    int calculateScore(String id,String courseId);
    void updateScores(String courseId);
    Score getScore(String id, String courseId);
}
