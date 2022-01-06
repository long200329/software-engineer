package com.se.software_engineer.service;

import org.springframework.stereotype.Service;


public interface ScoreService {
    int calculateScore(String id,String courseId);
    void updateScores(String courseId);
}
