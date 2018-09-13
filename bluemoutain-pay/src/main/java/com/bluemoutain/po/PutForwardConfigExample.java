package com.bluemoutain.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PutForwardConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PutForwardConfigExample() {
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

        public Criteria andOptUserIsNull() {
            addCriterion("opt_user is null");
            return (Criteria) this;
        }

        public Criteria andOptUserIsNotNull() {
            addCriterion("opt_user is not null");
            return (Criteria) this;
        }

        public Criteria andOptUserEqualTo(Integer value) {
            addCriterion("opt_user =", value, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserNotEqualTo(Integer value) {
            addCriterion("opt_user <>", value, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserGreaterThan(Integer value) {
            addCriterion("opt_user >", value, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("opt_user >=", value, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserLessThan(Integer value) {
            addCriterion("opt_user <", value, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserLessThanOrEqualTo(Integer value) {
            addCriterion("opt_user <=", value, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserIn(List<Integer> values) {
            addCriterion("opt_user in", values, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserNotIn(List<Integer> values) {
            addCriterion("opt_user not in", values, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserBetween(Integer value1, Integer value2) {
            addCriterion("opt_user between", value1, value2, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserNotBetween(Integer value1, Integer value2) {
            addCriterion("opt_user not between", value1, value2, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptTimeIsNull() {
            addCriterion("opt_time is null");
            return (Criteria) this;
        }

        public Criteria andOptTimeIsNotNull() {
            addCriterion("opt_time is not null");
            return (Criteria) this;
        }

        public Criteria andOptTimeEqualTo(Date value) {
            addCriterion("opt_time =", value, "optTime");
            return (Criteria) this;
        }

        public Criteria andOptTimeNotEqualTo(Date value) {
            addCriterion("opt_time <>", value, "optTime");
            return (Criteria) this;
        }

        public Criteria andOptTimeGreaterThan(Date value) {
            addCriterion("opt_time >", value, "optTime");
            return (Criteria) this;
        }

        public Criteria andOptTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("opt_time >=", value, "optTime");
            return (Criteria) this;
        }

        public Criteria andOptTimeLessThan(Date value) {
            addCriterion("opt_time <", value, "optTime");
            return (Criteria) this;
        }

        public Criteria andOptTimeLessThanOrEqualTo(Date value) {
            addCriterion("opt_time <=", value, "optTime");
            return (Criteria) this;
        }

        public Criteria andOptTimeIn(List<Date> values) {
            addCriterion("opt_time in", values, "optTime");
            return (Criteria) this;
        }

        public Criteria andOptTimeNotIn(List<Date> values) {
            addCriterion("opt_time not in", values, "optTime");
            return (Criteria) this;
        }

        public Criteria andOptTimeBetween(Date value1, Date value2) {
            addCriterion("opt_time between", value1, value2, "optTime");
            return (Criteria) this;
        }

        public Criteria andOptTimeNotBetween(Date value1, Date value2) {
            addCriterion("opt_time not between", value1, value2, "optTime");
            return (Criteria) this;
        }

        public Criteria andAlipayNameIsNull() {
            addCriterion("alipay_name is null");
            return (Criteria) this;
        }

        public Criteria andAlipayNameIsNotNull() {
            addCriterion("alipay_name is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayNameEqualTo(String value) {
            addCriterion("alipay_name =", value, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameNotEqualTo(String value) {
            addCriterion("alipay_name <>", value, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameGreaterThan(String value) {
            addCriterion("alipay_name >", value, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_name >=", value, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameLessThan(String value) {
            addCriterion("alipay_name <", value, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameLessThanOrEqualTo(String value) {
            addCriterion("alipay_name <=", value, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameLike(String value) {
            addCriterion("alipay_name like", value, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameNotLike(String value) {
            addCriterion("alipay_name not like", value, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameIn(List<String> values) {
            addCriterion("alipay_name in", values, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameNotIn(List<String> values) {
            addCriterion("alipay_name not in", values, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameBetween(String value1, String value2) {
            addCriterion("alipay_name between", value1, value2, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayNameNotBetween(String value1, String value2) {
            addCriterion("alipay_name not between", value1, value2, "alipayName");
            return (Criteria) this;
        }

        public Criteria andAlipayIdIsNull() {
            addCriterion("alipay_id is null");
            return (Criteria) this;
        }

        public Criteria andAlipayIdIsNotNull() {
            addCriterion("alipay_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayIdEqualTo(String value) {
            addCriterion("alipay_id =", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdNotEqualTo(String value) {
            addCriterion("alipay_id <>", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdGreaterThan(String value) {
            addCriterion("alipay_id >", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_id >=", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdLessThan(String value) {
            addCriterion("alipay_id <", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdLessThanOrEqualTo(String value) {
            addCriterion("alipay_id <=", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdLike(String value) {
            addCriterion("alipay_id like", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdNotLike(String value) {
            addCriterion("alipay_id not like", value, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdIn(List<String> values) {
            addCriterion("alipay_id in", values, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdNotIn(List<String> values) {
            addCriterion("alipay_id not in", values, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdBetween(String value1, String value2) {
            addCriterion("alipay_id between", value1, value2, "alipayId");
            return (Criteria) this;
        }

        public Criteria andAlipayIdNotBetween(String value1, String value2) {
            addCriterion("alipay_id not between", value1, value2, "alipayId");
            return (Criteria) this;
        }

        public Criteria andWxNameIsNull() {
            addCriterion("wx_name is null");
            return (Criteria) this;
        }

        public Criteria andWxNameIsNotNull() {
            addCriterion("wx_name is not null");
            return (Criteria) this;
        }

        public Criteria andWxNameEqualTo(String value) {
            addCriterion("wx_name =", value, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameNotEqualTo(String value) {
            addCriterion("wx_name <>", value, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameGreaterThan(String value) {
            addCriterion("wx_name >", value, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameGreaterThanOrEqualTo(String value) {
            addCriterion("wx_name >=", value, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameLessThan(String value) {
            addCriterion("wx_name <", value, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameLessThanOrEqualTo(String value) {
            addCriterion("wx_name <=", value, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameLike(String value) {
            addCriterion("wx_name like", value, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameNotLike(String value) {
            addCriterion("wx_name not like", value, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameIn(List<String> values) {
            addCriterion("wx_name in", values, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameNotIn(List<String> values) {
            addCriterion("wx_name not in", values, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameBetween(String value1, String value2) {
            addCriterion("wx_name between", value1, value2, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxNameNotBetween(String value1, String value2) {
            addCriterion("wx_name not between", value1, value2, "wxName");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdIsNull() {
            addCriterion("wx_open_id is null");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdIsNotNull() {
            addCriterion("wx_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdEqualTo(String value) {
            addCriterion("wx_open_id =", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdNotEqualTo(String value) {
            addCriterion("wx_open_id <>", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdGreaterThan(String value) {
            addCriterion("wx_open_id >", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("wx_open_id >=", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdLessThan(String value) {
            addCriterion("wx_open_id <", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdLessThanOrEqualTo(String value) {
            addCriterion("wx_open_id <=", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdLike(String value) {
            addCriterion("wx_open_id like", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdNotLike(String value) {
            addCriterion("wx_open_id not like", value, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdIn(List<String> values) {
            addCriterion("wx_open_id in", values, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdNotIn(List<String> values) {
            addCriterion("wx_open_id not in", values, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdBetween(String value1, String value2) {
            addCriterion("wx_open_id between", value1, value2, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andWxOpenIdNotBetween(String value1, String value2) {
            addCriterion("wx_open_id not between", value1, value2, "wxOpenId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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