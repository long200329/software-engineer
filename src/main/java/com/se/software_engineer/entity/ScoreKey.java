package com.se.software_engineer.entity;

public class ScoreKey {
    private String courseId;

    private String id;

    public ScoreKey(String courseId, String id) {
        this.courseId = courseId;
        this.id = id;
    }

    public ScoreKey() {
        super();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
}