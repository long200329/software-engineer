package com.se.software_engineer.entity;

import java.util.ArrayList;
import java.util.List;

public class PracticeProblemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PracticeProblemExample() {
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

        public Criteria andPracticeIdIsNull() {
            addCriterion("practice_id is null");
            return (Criteria) this;
        }

        public Criteria andPracticeIdIsNotNull() {
            addCriterion("practice_id is not null");
            return (Criteria) this;
        }

        public Criteria andPracticeIdEqualTo(String value) {
            addCriterion("practice_id =", value, "practiceId");
            return (Criteria) this;
        }

        public Criteria andPracticeIdNotEqualTo(String value) {
            addCriterion("practice_id <>", value, "practiceId");
            return (Criteria) this;
        }

        public Criteria andPracticeIdGreaterThan(String value) {
            addCriterion("practice_id >", value, "practiceId");
            return (Criteria) this;
        }

        public Criteria andPracticeIdGreaterThanOrEqualTo(String value) {
            addCriterion("practice_id >=", value, "practiceId");
            return (Criteria) this;
        }

        public Criteria andPracticeIdLessThan(String value) {
            addCriterion("practice_id <", value, "practiceId");
            return (Criteria) this;
        }

        public Criteria andPracticeIdLessThanOrEqualTo(String value) {
            addCriterion("practice_id <=", value, "practiceId");
            return (Criteria) this;
        }

        public Criteria andPracticeIdLike(String value) {
            addCriterion("practice_id like", value, "practiceId");
            return (Criteria) this;
        }

        public Criteria andPracticeIdNotLike(String value) {
            addCriterion("practice_id not like", value, "practiceId");
            return (Criteria) this;
        }

        public Criteria andPracticeIdIn(List<String> values) {
            addCriterion("practice_id in", values, "practiceId");
            return (Criteria) this;
        }

        public Criteria andPracticeIdNotIn(List<String> values) {
            addCriterion("practice_id not in", values, "practiceId");
            return (Criteria) this;
        }

        public Criteria andPracticeIdBetween(String value1, String value2) {
            addCriterion("practice_id between", value1, value2, "practiceId");
            return (Criteria) this;
        }

        public Criteria andPracticeIdNotBetween(String value1, String value2) {
            addCriterion("practice_id not between", value1, value2, "practiceId");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
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

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andOptionOneIsNull() {
            addCriterion("option_one is null");
            return (Criteria) this;
        }

        public Criteria andOptionOneIsNotNull() {
            addCriterion("option_one is not null");
            return (Criteria) this;
        }

        public Criteria andOptionOneEqualTo(String value) {
            addCriterion("option_one =", value, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneNotEqualTo(String value) {
            addCriterion("option_one <>", value, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneGreaterThan(String value) {
            addCriterion("option_one >", value, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneGreaterThanOrEqualTo(String value) {
            addCriterion("option_one >=", value, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneLessThan(String value) {
            addCriterion("option_one <", value, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneLessThanOrEqualTo(String value) {
            addCriterion("option_one <=", value, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneLike(String value) {
            addCriterion("option_one like", value, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneNotLike(String value) {
            addCriterion("option_one not like", value, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneIn(List<String> values) {
            addCriterion("option_one in", values, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneNotIn(List<String> values) {
            addCriterion("option_one not in", values, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneBetween(String value1, String value2) {
            addCriterion("option_one between", value1, value2, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneNotBetween(String value1, String value2) {
            addCriterion("option_one not between", value1, value2, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionTwoIsNull() {
            addCriterion("option_two is null");
            return (Criteria) this;
        }

        public Criteria andOptionTwoIsNotNull() {
            addCriterion("option_two is not null");
            return (Criteria) this;
        }

        public Criteria andOptionTwoEqualTo(String value) {
            addCriterion("option_two =", value, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoNotEqualTo(String value) {
            addCriterion("option_two <>", value, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoGreaterThan(String value) {
            addCriterion("option_two >", value, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoGreaterThanOrEqualTo(String value) {
            addCriterion("option_two >=", value, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoLessThan(String value) {
            addCriterion("option_two <", value, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoLessThanOrEqualTo(String value) {
            addCriterion("option_two <=", value, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoLike(String value) {
            addCriterion("option_two like", value, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoNotLike(String value) {
            addCriterion("option_two not like", value, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoIn(List<String> values) {
            addCriterion("option_two in", values, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoNotIn(List<String> values) {
            addCriterion("option_two not in", values, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoBetween(String value1, String value2) {
            addCriterion("option_two between", value1, value2, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoNotBetween(String value1, String value2) {
            addCriterion("option_two not between", value1, value2, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionThreeIsNull() {
            addCriterion("option_three is null");
            return (Criteria) this;
        }

        public Criteria andOptionThreeIsNotNull() {
            addCriterion("option_three is not null");
            return (Criteria) this;
        }

        public Criteria andOptionThreeEqualTo(String value) {
            addCriterion("option_three =", value, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeNotEqualTo(String value) {
            addCriterion("option_three <>", value, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeGreaterThan(String value) {
            addCriterion("option_three >", value, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeGreaterThanOrEqualTo(String value) {
            addCriterion("option_three >=", value, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeLessThan(String value) {
            addCriterion("option_three <", value, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeLessThanOrEqualTo(String value) {
            addCriterion("option_three <=", value, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeLike(String value) {
            addCriterion("option_three like", value, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeNotLike(String value) {
            addCriterion("option_three not like", value, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeIn(List<String> values) {
            addCriterion("option_three in", values, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeNotIn(List<String> values) {
            addCriterion("option_three not in", values, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeBetween(String value1, String value2) {
            addCriterion("option_three between", value1, value2, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeNotBetween(String value1, String value2) {
            addCriterion("option_three not between", value1, value2, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionFourIsNull() {
            addCriterion("option_four is null");
            return (Criteria) this;
        }

        public Criteria andOptionFourIsNotNull() {
            addCriterion("option_four is not null");
            return (Criteria) this;
        }

        public Criteria andOptionFourEqualTo(String value) {
            addCriterion("option_four =", value, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourNotEqualTo(String value) {
            addCriterion("option_four <>", value, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourGreaterThan(String value) {
            addCriterion("option_four >", value, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourGreaterThanOrEqualTo(String value) {
            addCriterion("option_four >=", value, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourLessThan(String value) {
            addCriterion("option_four <", value, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourLessThanOrEqualTo(String value) {
            addCriterion("option_four <=", value, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourLike(String value) {
            addCriterion("option_four like", value, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourNotLike(String value) {
            addCriterion("option_four not like", value, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourIn(List<String> values) {
            addCriterion("option_four in", values, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourNotIn(List<String> values) {
            addCriterion("option_four not in", values, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourBetween(String value1, String value2) {
            addCriterion("option_four between", value1, value2, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourNotBetween(String value1, String value2) {
            addCriterion("option_four not between", value1, value2, "optionFour");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
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