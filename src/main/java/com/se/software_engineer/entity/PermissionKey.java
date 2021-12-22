package com.se.software_engineer.entity;

public class PermissionKey {
    private String id;

    private String courseId;

    public PermissionKey(String id, String courseId) {
        this.id = id;
        this.courseId = courseId;
    }

    public PermissionKey() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }
}