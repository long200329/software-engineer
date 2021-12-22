package com.se.software_engineer.entity;

public class PracticeProblemKey {
    private String practiceId;

    private Integer number;

    public PracticeProblemKey(String practiceId, Integer number) {
        this.practiceId = practiceId;
        this.number = number;
    }

    public PracticeProblemKey() {
        super();
    }

    public String getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(String practiceId) {
        this.practiceId = practiceId == null ? null : practiceId.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}