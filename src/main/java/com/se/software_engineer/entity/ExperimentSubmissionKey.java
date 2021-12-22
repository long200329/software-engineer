package com.se.software_engineer.entity;

public class ExperimentSubmissionKey {
    private String experimentId;

    private String courseId;

    private String id;

    public ExperimentSubmissionKey(String experimentId, String courseId, String id) {
        this.experimentId = experimentId;
        this.courseId = courseId;
        this.id = id;
    }

    public ExperimentSubmissionKey() {
        super();
    }

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId == null ? null : experimentId.trim();
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