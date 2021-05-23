package com.example.second.entity;

import java.util.ArrayList;
import java.util.List;

public class KcExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KcExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andKcnumberIsNull() {
            addCriterion("kcNumber is null");
            return (Criteria) this;
        }

        public Criteria andKcnumberIsNotNull() {
            addCriterion("kcNumber is not null");
            return (Criteria) this;
        }

        public Criteria andKcnumberEqualTo(String value) {
            addCriterion("kcNumber =", value, "kcnumber");
            return (Criteria) this;
        }

        public Criteria andKcnumberNotEqualTo(String value) {
            addCriterion("kcNumber <>", value, "kcnumber");
            return (Criteria) this;
        }

        public Criteria andKcnumberGreaterThan(String value) {
            addCriterion("kcNumber >", value, "kcnumber");
            return (Criteria) this;
        }

        public Criteria andKcnumberGreaterThanOrEqualTo(String value) {
            addCriterion("kcNumber >=", value, "kcnumber");
            return (Criteria) this;
        }

        public Criteria andKcnumberLessThan(String value) {
            addCriterion("kcNumber <", value, "kcnumber");
            return (Criteria) this;
        }

        public Criteria andKcnumberLessThanOrEqualTo(String value) {
            addCriterion("kcNumber <=", value, "kcnumber");
            return (Criteria) this;
        }

        public Criteria andKcnumberLike(String value) {
            addCriterion("kcNumber like", value, "kcnumber");
            return (Criteria) this;
        }

        public Criteria andKcnumberNotLike(String value) {
            addCriterion("kcNumber not like", value, "kcnumber");
            return (Criteria) this;
        }

        public Criteria andKcnumberIn(List<String> values) {
            addCriterion("kcNumber in", values, "kcnumber");
            return (Criteria) this;
        }

        public Criteria andKcnumberNotIn(List<String> values) {
            addCriterion("kcNumber not in", values, "kcnumber");
            return (Criteria) this;
        }

        public Criteria andKcnumberBetween(String value1, String value2) {
            addCriterion("kcNumber between", value1, value2, "kcnumber");
            return (Criteria) this;
        }

        public Criteria andKcnumberNotBetween(String value1, String value2) {
            addCriterion("kcNumber not between", value1, value2, "kcnumber");
            return (Criteria) this;
        }

        public Criteria andKcnameIsNull() {
            addCriterion("kcName is null");
            return (Criteria) this;
        }

        public Criteria andKcnameIsNotNull() {
            addCriterion("kcName is not null");
            return (Criteria) this;
        }

        public Criteria andKcnameEqualTo(String value) {
            addCriterion("kcName =", value, "kcname");
            return (Criteria) this;
        }

        public Criteria andKcnameNotEqualTo(String value) {
            addCriterion("kcName <>", value, "kcname");
            return (Criteria) this;
        }

        public Criteria andKcnameGreaterThan(String value) {
            addCriterion("kcName >", value, "kcname");
            return (Criteria) this;
        }

        public Criteria andKcnameGreaterThanOrEqualTo(String value) {
            addCriterion("kcName >=", value, "kcname");
            return (Criteria) this;
        }

        public Criteria andKcnameLessThan(String value) {
            addCriterion("kcName <", value, "kcname");
            return (Criteria) this;
        }

        public Criteria andKcnameLessThanOrEqualTo(String value) {
            addCriterion("kcName <=", value, "kcname");
            return (Criteria) this;
        }

        public Criteria andKcnameLike(String value) {
            addCriterion("kcName like", value, "kcname");
            return (Criteria) this;
        }

        public Criteria andKcnameNotLike(String value) {
            addCriterion("kcName not like", value, "kcname");
            return (Criteria) this;
        }

        public Criteria andKcnameIn(List<String> values) {
            addCriterion("kcName in", values, "kcname");
            return (Criteria) this;
        }

        public Criteria andKcnameNotIn(List<String> values) {
            addCriterion("kcName not in", values, "kcname");
            return (Criteria) this;
        }

        public Criteria andKcnameBetween(String value1, String value2) {
            addCriterion("kcName between", value1, value2, "kcname");
            return (Criteria) this;
        }

        public Criteria andKcnameNotBetween(String value1, String value2) {
            addCriterion("kcName not between", value1, value2, "kcname");
            return (Criteria) this;
        }

        public Criteria andKctypeIsNull() {
            addCriterion("kcType is null");
            return (Criteria) this;
        }

        public Criteria andKctypeIsNotNull() {
            addCriterion("kcType is not null");
            return (Criteria) this;
        }

        public Criteria andKctypeEqualTo(String value) {
            addCriterion("kcType =", value, "kctype");
            return (Criteria) this;
        }

        public Criteria andKctypeNotEqualTo(String value) {
            addCriterion("kcType <>", value, "kctype");
            return (Criteria) this;
        }

        public Criteria andKctypeGreaterThan(String value) {
            addCriterion("kcType >", value, "kctype");
            return (Criteria) this;
        }

        public Criteria andKctypeGreaterThanOrEqualTo(String value) {
            addCriterion("kcType >=", value, "kctype");
            return (Criteria) this;
        }

        public Criteria andKctypeLessThan(String value) {
            addCriterion("kcType <", value, "kctype");
            return (Criteria) this;
        }

        public Criteria andKctypeLessThanOrEqualTo(String value) {
            addCriterion("kcType <=", value, "kctype");
            return (Criteria) this;
        }

        public Criteria andKctypeLike(String value) {
            addCriterion("kcType like", value, "kctype");
            return (Criteria) this;
        }

        public Criteria andKctypeNotLike(String value) {
            addCriterion("kcType not like", value, "kctype");
            return (Criteria) this;
        }

        public Criteria andKctypeIn(List<String> values) {
            addCriterion("kcType in", values, "kctype");
            return (Criteria) this;
        }

        public Criteria andKctypeNotIn(List<String> values) {
            addCriterion("kcType not in", values, "kctype");
            return (Criteria) this;
        }

        public Criteria andKctypeBetween(String value1, String value2) {
            addCriterion("kcType between", value1, value2, "kctype");
            return (Criteria) this;
        }

        public Criteria andKctypeNotBetween(String value1, String value2) {
            addCriterion("kcType not between", value1, value2, "kctype");
            return (Criteria) this;
        }

        public Criteria andKccollegeIsNull() {
            addCriterion("kcCollege is null");
            return (Criteria) this;
        }

        public Criteria andKccollegeIsNotNull() {
            addCriterion("kcCollege is not null");
            return (Criteria) this;
        }

        public Criteria andKccollegeEqualTo(String value) {
            addCriterion("kcCollege =", value, "kccollege");
            return (Criteria) this;
        }

        public Criteria andKccollegeNotEqualTo(String value) {
            addCriterion("kcCollege <>", value, "kccollege");
            return (Criteria) this;
        }

        public Criteria andKccollegeGreaterThan(String value) {
            addCriterion("kcCollege >", value, "kccollege");
            return (Criteria) this;
        }

        public Criteria andKccollegeGreaterThanOrEqualTo(String value) {
            addCriterion("kcCollege >=", value, "kccollege");
            return (Criteria) this;
        }

        public Criteria andKccollegeLessThan(String value) {
            addCriterion("kcCollege <", value, "kccollege");
            return (Criteria) this;
        }

        public Criteria andKccollegeLessThanOrEqualTo(String value) {
            addCriterion("kcCollege <=", value, "kccollege");
            return (Criteria) this;
        }

        public Criteria andKccollegeLike(String value) {
            addCriterion("kcCollege like", value, "kccollege");
            return (Criteria) this;
        }

        public Criteria andKccollegeNotLike(String value) {
            addCriterion("kcCollege not like", value, "kccollege");
            return (Criteria) this;
        }

        public Criteria andKccollegeIn(List<String> values) {
            addCriterion("kcCollege in", values, "kccollege");
            return (Criteria) this;
        }

        public Criteria andKccollegeNotIn(List<String> values) {
            addCriterion("kcCollege not in", values, "kccollege");
            return (Criteria) this;
        }

        public Criteria andKccollegeBetween(String value1, String value2) {
            addCriterion("kcCollege between", value1, value2, "kccollege");
            return (Criteria) this;
        }

        public Criteria andKccollegeNotBetween(String value1, String value2) {
            addCriterion("kcCollege not between", value1, value2, "kccollege");
            return (Criteria) this;
        }

        public Criteria andKcroomIsNull() {
            addCriterion("kcRoom is null");
            return (Criteria) this;
        }

        public Criteria andKcroomIsNotNull() {
            addCriterion("kcRoom is not null");
            return (Criteria) this;
        }

        public Criteria andKcroomEqualTo(String value) {
            addCriterion("kcRoom =", value, "kcroom");
            return (Criteria) this;
        }

        public Criteria andKcroomNotEqualTo(String value) {
            addCriterion("kcRoom <>", value, "kcroom");
            return (Criteria) this;
        }

        public Criteria andKcroomGreaterThan(String value) {
            addCriterion("kcRoom >", value, "kcroom");
            return (Criteria) this;
        }

        public Criteria andKcroomGreaterThanOrEqualTo(String value) {
            addCriterion("kcRoom >=", value, "kcroom");
            return (Criteria) this;
        }

        public Criteria andKcroomLessThan(String value) {
            addCriterion("kcRoom <", value, "kcroom");
            return (Criteria) this;
        }

        public Criteria andKcroomLessThanOrEqualTo(String value) {
            addCriterion("kcRoom <=", value, "kcroom");
            return (Criteria) this;
        }

        public Criteria andKcroomLike(String value) {
            addCriterion("kcRoom like", value, "kcroom");
            return (Criteria) this;
        }

        public Criteria andKcroomNotLike(String value) {
            addCriterion("kcRoom not like", value, "kcroom");
            return (Criteria) this;
        }

        public Criteria andKcroomIn(List<String> values) {
            addCriterion("kcRoom in", values, "kcroom");
            return (Criteria) this;
        }

        public Criteria andKcroomNotIn(List<String> values) {
            addCriterion("kcRoom not in", values, "kcroom");
            return (Criteria) this;
        }

        public Criteria andKcroomBetween(String value1, String value2) {
            addCriterion("kcRoom between", value1, value2, "kcroom");
            return (Criteria) this;
        }

        public Criteria andKcroomNotBetween(String value1, String value2) {
            addCriterion("kcRoom not between", value1, value2, "kcroom");
            return (Criteria) this;
        }

        public Criteria andKctimesIsNull() {
            addCriterion("kcTimes is null");
            return (Criteria) this;
        }

        public Criteria andKctimesIsNotNull() {
            addCriterion("kcTimes is not null");
            return (Criteria) this;
        }

        public Criteria andKctimesEqualTo(String value) {
            addCriterion("kcTimes =", value, "kctimes");
            return (Criteria) this;
        }

        public Criteria andKctimesNotEqualTo(String value) {
            addCriterion("kcTimes <>", value, "kctimes");
            return (Criteria) this;
        }

        public Criteria andKctimesGreaterThan(String value) {
            addCriterion("kcTimes >", value, "kctimes");
            return (Criteria) this;
        }

        public Criteria andKctimesGreaterThanOrEqualTo(String value) {
            addCriterion("kcTimes >=", value, "kctimes");
            return (Criteria) this;
        }

        public Criteria andKctimesLessThan(String value) {
            addCriterion("kcTimes <", value, "kctimes");
            return (Criteria) this;
        }

        public Criteria andKctimesLessThanOrEqualTo(String value) {
            addCriterion("kcTimes <=", value, "kctimes");
            return (Criteria) this;
        }

        public Criteria andKctimesLike(String value) {
            addCriterion("kcTimes like", value, "kctimes");
            return (Criteria) this;
        }

        public Criteria andKctimesNotLike(String value) {
            addCriterion("kcTimes not like", value, "kctimes");
            return (Criteria) this;
        }

        public Criteria andKctimesIn(List<String> values) {
            addCriterion("kcTimes in", values, "kctimes");
            return (Criteria) this;
        }

        public Criteria andKctimesNotIn(List<String> values) {
            addCriterion("kcTimes not in", values, "kctimes");
            return (Criteria) this;
        }

        public Criteria andKctimesBetween(String value1, String value2) {
            addCriterion("kcTimes between", value1, value2, "kctimes");
            return (Criteria) this;
        }

        public Criteria andKctimesNotBetween(String value1, String value2) {
            addCriterion("kcTimes not between", value1, value2, "kctimes");
            return (Criteria) this;
        }

        public Criteria andKcdurationIsNull() {
            addCriterion("kcDuration is null");
            return (Criteria) this;
        }

        public Criteria andKcdurationIsNotNull() {
            addCriterion("kcDuration is not null");
            return (Criteria) this;
        }

        public Criteria andKcdurationEqualTo(String value) {
            addCriterion("kcDuration =", value, "kcduration");
            return (Criteria) this;
        }

        public Criteria andKcdurationNotEqualTo(String value) {
            addCriterion("kcDuration <>", value, "kcduration");
            return (Criteria) this;
        }

        public Criteria andKcdurationGreaterThan(String value) {
            addCriterion("kcDuration >", value, "kcduration");
            return (Criteria) this;
        }

        public Criteria andKcdurationGreaterThanOrEqualTo(String value) {
            addCriterion("kcDuration >=", value, "kcduration");
            return (Criteria) this;
        }

        public Criteria andKcdurationLessThan(String value) {
            addCriterion("kcDuration <", value, "kcduration");
            return (Criteria) this;
        }

        public Criteria andKcdurationLessThanOrEqualTo(String value) {
            addCriterion("kcDuration <=", value, "kcduration");
            return (Criteria) this;
        }

        public Criteria andKcdurationLike(String value) {
            addCriterion("kcDuration like", value, "kcduration");
            return (Criteria) this;
        }

        public Criteria andKcdurationNotLike(String value) {
            addCriterion("kcDuration not like", value, "kcduration");
            return (Criteria) this;
        }

        public Criteria andKcdurationIn(List<String> values) {
            addCriterion("kcDuration in", values, "kcduration");
            return (Criteria) this;
        }

        public Criteria andKcdurationNotIn(List<String> values) {
            addCriterion("kcDuration not in", values, "kcduration");
            return (Criteria) this;
        }

        public Criteria andKcdurationBetween(String value1, String value2) {
            addCriterion("kcDuration between", value1, value2, "kcduration");
            return (Criteria) this;
        }

        public Criteria andKcdurationNotBetween(String value1, String value2) {
            addCriterion("kcDuration not between", value1, value2, "kcduration");
            return (Criteria) this;
        }

        public Criteria andKcintroduceIsNull() {
            addCriterion("kcIntroduce is null");
            return (Criteria) this;
        }

        public Criteria andKcintroduceIsNotNull() {
            addCriterion("kcIntroduce is not null");
            return (Criteria) this;
        }

        public Criteria andKcintroduceEqualTo(String value) {
            addCriterion("kcIntroduce =", value, "kcintroduce");
            return (Criteria) this;
        }

        public Criteria andKcintroduceNotEqualTo(String value) {
            addCriterion("kcIntroduce <>", value, "kcintroduce");
            return (Criteria) this;
        }

        public Criteria andKcintroduceGreaterThan(String value) {
            addCriterion("kcIntroduce >", value, "kcintroduce");
            return (Criteria) this;
        }

        public Criteria andKcintroduceGreaterThanOrEqualTo(String value) {
            addCriterion("kcIntroduce >=", value, "kcintroduce");
            return (Criteria) this;
        }

        public Criteria andKcintroduceLessThan(String value) {
            addCriterion("kcIntroduce <", value, "kcintroduce");
            return (Criteria) this;
        }

        public Criteria andKcintroduceLessThanOrEqualTo(String value) {
            addCriterion("kcIntroduce <=", value, "kcintroduce");
            return (Criteria) this;
        }

        public Criteria andKcintroduceLike(String value) {
            addCriterion("kcIntroduce like", value, "kcintroduce");
            return (Criteria) this;
        }

        public Criteria andKcintroduceNotLike(String value) {
            addCriterion("kcIntroduce not like", value, "kcintroduce");
            return (Criteria) this;
        }

        public Criteria andKcintroduceIn(List<String> values) {
            addCriterion("kcIntroduce in", values, "kcintroduce");
            return (Criteria) this;
        }

        public Criteria andKcintroduceNotIn(List<String> values) {
            addCriterion("kcIntroduce not in", values, "kcintroduce");
            return (Criteria) this;
        }

        public Criteria andKcintroduceBetween(String value1, String value2) {
            addCriterion("kcIntroduce between", value1, value2, "kcintroduce");
            return (Criteria) this;
        }

        public Criteria andKcintroduceNotBetween(String value1, String value2) {
            addCriterion("kcIntroduce not between", value1, value2, "kcintroduce");
            return (Criteria) this;
        }
    }

    /**
     */
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