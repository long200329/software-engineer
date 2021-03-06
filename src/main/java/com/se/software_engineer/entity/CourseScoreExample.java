package com.se.software_engineer.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CourseScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseScoreExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(String value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(String value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(String value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(String value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(String value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(String value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLike(String value) {
            addCriterion("course_id like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotLike(String value) {
            addCriterion("course_id not like", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<String> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<String> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(String value1, String value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(String value1, String value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andAttendanceWeightIsNull() {
            addCriterion("attendance_weight is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceWeightIsNotNull() {
            addCriterion("attendance_weight is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceWeightEqualTo(BigDecimal value) {
            addCriterion("attendance_weight =", value, "attendanceWeight");
            return (Criteria) this;
        }

        public Criteria andAttendanceWeightNotEqualTo(BigDecimal value) {
            addCriterion("attendance_weight <>", value, "attendanceWeight");
            return (Criteria) this;
        }

        public Criteria andAttendanceWeightGreaterThan(BigDecimal value) {
            addCriterion("attendance_weight >", value, "attendanceWeight");
            return (Criteria) this;
        }

        public Criteria andAttendanceWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("attendance_weight >=", value, "attendanceWeight");
            return (Criteria) this;
        }

        public Criteria andAttendanceWeightLessThan(BigDecimal value) {
            addCriterion("attendance_weight <", value, "attendanceWeight");
            return (Criteria) this;
        }

        public Criteria andAttendanceWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("attendance_weight <=", value, "attendanceWeight");
            return (Criteria) this;
        }

        public Criteria andAttendanceWeightIn(List<BigDecimal> values) {
            addCriterion("attendance_weight in", values, "attendanceWeight");
            return (Criteria) this;
        }

        public Criteria andAttendanceWeightNotIn(List<BigDecimal> values) {
            addCriterion("attendance_weight not in", values, "attendanceWeight");
            return (Criteria) this;
        }

        public Criteria andAttendanceWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("attendance_weight between", value1, value2, "attendanceWeight");
            return (Criteria) this;
        }

        public Criteria andAttendanceWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("attendance_weight not between", value1, value2, "attendanceWeight");
            return (Criteria) this;
        }

        public Criteria andExperimentWeightIsNull() {
            addCriterion("experiment_weight is null");
            return (Criteria) this;
        }

        public Criteria andExperimentWeightIsNotNull() {
            addCriterion("experiment_weight is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentWeightEqualTo(BigDecimal value) {
            addCriterion("experiment_weight =", value, "experimentWeight");
            return (Criteria) this;
        }

        public Criteria andExperimentWeightNotEqualTo(BigDecimal value) {
            addCriterion("experiment_weight <>", value, "experimentWeight");
            return (Criteria) this;
        }

        public Criteria andExperimentWeightGreaterThan(BigDecimal value) {
            addCriterion("experiment_weight >", value, "experimentWeight");
            return (Criteria) this;
        }

        public Criteria andExperimentWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("experiment_weight >=", value, "experimentWeight");
            return (Criteria) this;
        }

        public Criteria andExperimentWeightLessThan(BigDecimal value) {
            addCriterion("experiment_weight <", value, "experimentWeight");
            return (Criteria) this;
        }

        public Criteria andExperimentWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("experiment_weight <=", value, "experimentWeight");
            return (Criteria) this;
        }

        public Criteria andExperimentWeightIn(List<BigDecimal> values) {
            addCriterion("experiment_weight in", values, "experimentWeight");
            return (Criteria) this;
        }

        public Criteria andExperimentWeightNotIn(List<BigDecimal> values) {
            addCriterion("experiment_weight not in", values, "experimentWeight");
            return (Criteria) this;
        }

        public Criteria andExperimentWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("experiment_weight between", value1, value2, "experimentWeight");
            return (Criteria) this;
        }

        public Criteria andExperimentWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("experiment_weight not between", value1, value2, "experimentWeight");
            return (Criteria) this;
        }

        public Criteria andPracticeWeightIsNull() {
            addCriterion("practice_weight is null");
            return (Criteria) this;
        }

        public Criteria andPracticeWeightIsNotNull() {
            addCriterion("practice_weight is not null");
            return (Criteria) this;
        }

        public Criteria andPracticeWeightEqualTo(BigDecimal value) {
            addCriterion("practice_weight =", value, "practiceWeight");
            return (Criteria) this;
        }

        public Criteria andPracticeWeightNotEqualTo(BigDecimal value) {
            addCriterion("practice_weight <>", value, "practiceWeight");
            return (Criteria) this;
        }

        public Criteria andPracticeWeightGreaterThan(BigDecimal value) {
            addCriterion("practice_weight >", value, "practiceWeight");
            return (Criteria) this;
        }

        public Criteria andPracticeWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("practice_weight >=", value, "practiceWeight");
            return (Criteria) this;
        }

        public Criteria andPracticeWeightLessThan(BigDecimal value) {
            addCriterion("practice_weight <", value, "practiceWeight");
            return (Criteria) this;
        }

        public Criteria andPracticeWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("practice_weight <=", value, "practiceWeight");
            return (Criteria) this;
        }

        public Criteria andPracticeWeightIn(List<BigDecimal> values) {
            addCriterion("practice_weight in", values, "practiceWeight");
            return (Criteria) this;
        }

        public Criteria andPracticeWeightNotIn(List<BigDecimal> values) {
            addCriterion("practice_weight not in", values, "practiceWeight");
            return (Criteria) this;
        }

        public Criteria andPracticeWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("practice_weight between", value1, value2, "practiceWeight");
            return (Criteria) this;
        }

        public Criteria andPracticeWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("practice_weight not between", value1, value2, "practiceWeight");
            return (Criteria) this;
        }

        public Criteria andPracticeTotalScoreIsNull() {
            addCriterion("practice_total_score is null");
            return (Criteria) this;
        }

        public Criteria andPracticeTotalScoreIsNotNull() {
            addCriterion("practice_total_score is not null");
            return (Criteria) this;
        }

        public Criteria andPracticeTotalScoreEqualTo(BigDecimal value) {
            addCriterion("practice_total_score =", value, "practiceTotalScore");
            return (Criteria) this;
        }

        public Criteria andPracticeTotalScoreNotEqualTo(BigDecimal value) {
            addCriterion("practice_total_score <>", value, "practiceTotalScore");
            return (Criteria) this;
        }

        public Criteria andPracticeTotalScoreGreaterThan(BigDecimal value) {
            addCriterion("practice_total_score >", value, "practiceTotalScore");
            return (Criteria) this;
        }

        public Criteria andPracticeTotalScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("practice_total_score >=", value, "practiceTotalScore");
            return (Criteria) this;
        }

        public Criteria andPracticeTotalScoreLessThan(BigDecimal value) {
            addCriterion("practice_total_score <", value, "practiceTotalScore");
            return (Criteria) this;
        }

        public Criteria andPracticeTotalScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("practice_total_score <=", value, "practiceTotalScore");
            return (Criteria) this;
        }

        public Criteria andPracticeTotalScoreIn(List<BigDecimal> values) {
            addCriterion("practice_total_score in", values, "practiceTotalScore");
            return (Criteria) this;
        }

        public Criteria andPracticeTotalScoreNotIn(List<BigDecimal> values) {
            addCriterion("practice_total_score not in", values, "practiceTotalScore");
            return (Criteria) this;
        }

        public Criteria andPracticeTotalScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("practice_total_score between", value1, value2, "practiceTotalScore");
            return (Criteria) this;
        }

        public Criteria andPracticeTotalScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("practice_total_score not between", value1, value2, "practiceTotalScore");
            return (Criteria) this;
        }

        public Criteria andExperimentTotalScoreIsNull() {
            addCriterion("experiment_total_score is null");
            return (Criteria) this;
        }

        public Criteria andExperimentTotalScoreIsNotNull() {
            addCriterion("experiment_total_score is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentTotalScoreEqualTo(BigDecimal value) {
            addCriterion("experiment_total_score =", value, "experimentTotalScore");
            return (Criteria) this;
        }

        public Criteria andExperimentTotalScoreNotEqualTo(BigDecimal value) {
            addCriterion("experiment_total_score <>", value, "experimentTotalScore");
            return (Criteria) this;
        }

        public Criteria andExperimentTotalScoreGreaterThan(BigDecimal value) {
            addCriterion("experiment_total_score >", value, "experimentTotalScore");
            return (Criteria) this;
        }

        public Criteria andExperimentTotalScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("experiment_total_score >=", value, "experimentTotalScore");
            return (Criteria) this;
        }

        public Criteria andExperimentTotalScoreLessThan(BigDecimal value) {
            addCriterion("experiment_total_score <", value, "experimentTotalScore");
            return (Criteria) this;
        }

        public Criteria andExperimentTotalScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("experiment_total_score <=", value, "experimentTotalScore");
            return (Criteria) this;
        }

        public Criteria andExperimentTotalScoreIn(List<BigDecimal> values) {
            addCriterion("experiment_total_score in", values, "experimentTotalScore");
            return (Criteria) this;
        }

        public Criteria andExperimentTotalScoreNotIn(List<BigDecimal> values) {
            addCriterion("experiment_total_score not in", values, "experimentTotalScore");
            return (Criteria) this;
        }

        public Criteria andExperimentTotalScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("experiment_total_score between", value1, value2, "experimentTotalScore");
            return (Criteria) this;
        }

        public Criteria andExperimentTotalScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("experiment_total_score not between", value1, value2, "experimentTotalScore");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}