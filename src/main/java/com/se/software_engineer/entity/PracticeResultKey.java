package com.se.software_engineer.entity;

public class PracticeResultKey {
    private String practiceId;

    private String id;

    public PracticeResultKey(String practiceId, String id) {
        this.practiceId = practiceId;
        this.id = id;
    }

    public PracticeResultKey() {
        super();
    }

    public String getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(String practiceId) {
        this.practiceId = practiceId == null ? null : practiceId.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
}