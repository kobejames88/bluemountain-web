package com.bluemoutain.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PutForwardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PutForwardExample() {
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

        public Criteria andPsdIsNull() {
            addCriterion("psd is null");
            return (Criteria) this;
        }

        public Criteria andPsdIsNotNull() {
            addCriterion("psd is not null");
            return (Criteria) this;
        }

        public Criteria andPsdEqualTo(String value) {
            addCriterion("psd =", value, "psd");
            return (Criteria) this;
        }

        public Criteria andPsdNotEqualTo(String value) {
            addCriterion("psd <>", value, "psd");
            return (Criteria) this;
        }

        public Criteria andPsdGreaterThan(String value) {
            addCriterion("psd >", value, "psd");
            return (Criteria) this;
        }

        public Criteria andPsdGreaterThanOrEqualTo(String value) {
            addCriterion("psd >=", value, "psd");
            return (Criteria) this;
        }

        public Criteria andPsdLessThan(String value) {
            addCriterion("psd <", value, "psd");
            return (Criteria) this;
        }

        public Criteria andPsdLessThanOrEqualTo(String value) {
            addCriterion("psd <=", value, "psd");
            return (Criteria) this;
        }

        public Criteria andPsdLike(String value) {
            addCriterion("psd like", value, "psd");
            return (Criteria) this;
        }

        public Criteria andPsdNotLike(String value) {
            addCriterion("psd not like", value, "psd");
            return (Criteria) this;
        }

        public Criteria andPsdIn(List<String> values) {
            addCriterion("psd in", values, "psd");
            return (Criteria) this;
        }

        public Criteria andPsdNotIn(List<String> values) {
            addCriterion("psd not in", values, "psd");
            return (Criteria) this;
        }

        public Criteria andPsdBetween(String value1, String value2) {
            addCriterion("psd between", value1, value2, "psd");
            return (Criteria) this;
        }

        public Criteria andPsdNotBetween(String value1, String value2) {
            addCriterion("psd not between", value1, value2, "psd");
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

        public Criteria andPutIdIsNull() {
            addCriterion("put_id is null");
            return (Criteria) this;
        }

        public Criteria andPutIdIsNotNull() {
            addCriterion("put_id is not null");
            return (Criteria) this;
        }

        public Criteria andPutIdEqualTo(String value) {
            addCriterion("put_id =", value, "putId");
            return (Criteria) this;
        }

        public Criteria andPutIdNotEqualTo(String value) {
            addCriterion("put_id <>", value, "putId");
            return (Criteria) this;
        }

        public Criteria andPutIdGreaterThan(String value) {
            addCriterion("put_id >", value, "putId");
            return (Criteria) this;
        }

        public Criteria andPutIdGreaterThanOrEqualTo(String value) {
            addCriterion("put_id >=", value, "putId");
            return (Criteria) this;
        }

        public Criteria andPutIdLessThan(String value) {
            addCriterion("put_id <", value, "putId");
            return (Criteria) this;
        }

        public Criteria andPutIdLessThanOrEqualTo(String value) {
            addCriterion("put_id <=", value, "putId");
            return (Criteria) this;
        }

        public Criteria andPutIdLike(String value) {
            addCriterion("put_id like", value, "putId");
            return (Criteria) this;
        }

        public Criteria andPutIdNotLike(String value) {
            addCriterion("put_id not like", value, "putId");
            return (Criteria) this;
        }

        public Criteria andPutIdIn(List<String> values) {
            addCriterion("put_id in", values, "putId");
            return (Criteria) this;
        }

        public Criteria andPutIdNotIn(List<String> values) {
            addCriterion("put_id not in", values, "putId");
            return (Criteria) this;
        }

        public Criteria andPutIdBetween(String value1, String value2) {
            addCriterion("put_id between", value1, value2, "putId");
            return (Criteria) this;
        }

        public Criteria andPutIdNotBetween(String value1, String value2) {
            addCriterion("put_id not between", value1, value2, "putId");
            return (Criteria) this;
        }

        public Criteria andPutNameIsNull() {
            addCriterion("put_name is null");
            return (Criteria) this;
        }

        public Criteria andPutNameIsNotNull() {
            addCriterion("put_name is not null");
            return (Criteria) this;
        }

        public Criteria andPutNameEqualTo(String value) {
            addCriterion("put_name =", value, "putName");
            return (Criteria) this;
        }

        public Criteria andPutNameNotEqualTo(String value) {
            addCriterion("put_name <>", value, "putName");
            return (Criteria) this;
        }

        public Criteria andPutNameGreaterThan(String value) {
            addCriterion("put_name >", value, "putName");
            return (Criteria) this;
        }

        public Criteria andPutNameGreaterThanOrEqualTo(String value) {
            addCriterion("put_name >=", value, "putName");
            return (Criteria) this;
        }

        public Criteria andPutNameLessThan(String value) {
            addCriterion("put_name <", value, "putName");
            return (Criteria) this;
        }

        public Criteria andPutNameLessThanOrEqualTo(String value) {
            addCriterion("put_name <=", value, "putName");
            return (Criteria) this;
        }

        public Criteria andPutNameLike(String value) {
            addCriterion("put_name like", value, "putName");
            return (Criteria) this;
        }

        public Criteria andPutNameNotLike(String value) {
            addCriterion("put_name not like", value, "putName");
            return (Criteria) this;
        }

        public Criteria andPutNameIn(List<String> values) {
            addCriterion("put_name in", values, "putName");
            return (Criteria) this;
        }

        public Criteria andPutNameNotIn(List<String> values) {
            addCriterion("put_name not in", values, "putName");
            return (Criteria) this;
        }

        public Criteria andPutNameBetween(String value1, String value2) {
            addCriterion("put_name between", value1, value2, "putName");
            return (Criteria) this;
        }

        public Criteria andPutNameNotBetween(String value1, String value2) {
            addCriterion("put_name not between", value1, value2, "putName");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andErrorInfoIsNull() {
            addCriterion("error_info is null");
            return (Criteria) this;
        }

        public Criteria andErrorInfoIsNotNull() {
            addCriterion("error_info is not null");
            return (Criteria) this;
        }

        public Criteria andErrorInfoEqualTo(String value) {
            addCriterion("error_info =", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoNotEqualTo(String value) {
            addCriterion("error_info <>", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoGreaterThan(String value) {
            addCriterion("error_info >", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoGreaterThanOrEqualTo(String value) {
            addCriterion("error_info >=", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoLessThan(String value) {
            addCriterion("error_info <", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoLessThanOrEqualTo(String value) {
            addCriterion("error_info <=", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoLike(String value) {
            addCriterion("error_info like", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoNotLike(String value) {
            addCriterion("error_info not like", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoIn(List<String> values) {
            addCriterion("error_info in", values, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoNotIn(List<String> values) {
            addCriterion("error_info not in", values, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoBetween(String value1, String value2) {
            addCriterion("error_info between", value1, value2, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoNotBetween(String value1, String value2) {
            addCriterion("error_info not between", value1, value2, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andTranoIsNull() {
            addCriterion("trano is null");
            return (Criteria) this;
        }

        public Criteria andTranoIsNotNull() {
            addCriterion("trano is not null");
            return (Criteria) this;
        }

        public Criteria andTranoEqualTo(String value) {
            addCriterion("trano =", value, "trano");
            return (Criteria) this;
        }

        public Criteria andTranoNotEqualTo(String value) {
            addCriterion("trano <>", value, "trano");
            return (Criteria) this;
        }

        public Criteria andTranoGreaterThan(String value) {
            addCriterion("trano >", value, "trano");
            return (Criteria) this;
        }

        public Criteria andTranoGreaterThanOrEqualTo(String value) {
            addCriterion("trano >=", value, "trano");
            return (Criteria) this;
        }

        public Criteria andTranoLessThan(String value) {
            addCriterion("trano <", value, "trano");
            return (Criteria) this;
        }

        public Criteria andTranoLessThanOrEqualTo(String value) {
            addCriterion("trano <=", value, "trano");
            return (Criteria) this;
        }

        public Criteria andTranoLike(String value) {
            addCriterion("trano like", value, "trano");
            return (Criteria) this;
        }

        public Criteria andTranoNotLike(String value) {
            addCriterion("trano not like", value, "trano");
            return (Criteria) this;
        }

        public Criteria andTranoIn(List<String> values) {
            addCriterion("trano in", values, "trano");
            return (Criteria) this;
        }

        public Criteria andTranoNotIn(List<String> values) {
            addCriterion("trano not in", values, "trano");
            return (Criteria) this;
        }

        public Criteria andTranoBetween(String value1, String value2) {
            addCriterion("trano between", value1, value2, "trano");
            return (Criteria) this;
        }

        public Criteria andTranoNotBetween(String value1, String value2) {
            addCriterion("trano not between", value1, value2, "trano");
            return (Criteria) this;
        }

        public Criteria andPTypeIsNull() {
            addCriterion("p_type is null");
            return (Criteria) this;
        }

        public Criteria andPTypeIsNotNull() {
            addCriterion("p_type is not null");
            return (Criteria) this;
        }

        public Criteria andPTypeEqualTo(Integer value) {
            addCriterion("p_type =", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeNotEqualTo(Integer value) {
            addCriterion("p_type <>", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeGreaterThan(Integer value) {
            addCriterion("p_type >", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_type >=", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeLessThan(Integer value) {
            addCriterion("p_type <", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeLessThanOrEqualTo(Integer value) {
            addCriterion("p_type <=", value, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeIn(List<Integer> values) {
            addCriterion("p_type in", values, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeNotIn(List<Integer> values) {
            addCriterion("p_type not in", values, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeBetween(Integer value1, Integer value2) {
            addCriterion("p_type between", value1, value2, "pType");
            return (Criteria) this;
        }

        public Criteria andPTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("p_type not between", value1, value2, "pType");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andStrIsNull() {
            addCriterion("str is null");
            return (Criteria) this;
        }

        public Criteria andStrIsNotNull() {
            addCriterion("str is not null");
            return (Criteria) this;
        }

        public Criteria andStrEqualTo(String value) {
            addCriterion("str =", value, "str");
            return (Criteria) this;
        }

        public Criteria andStrNotEqualTo(String value) {
            addCriterion("str <>", value, "str");
            return (Criteria) this;
        }

        public Criteria andStrGreaterThan(String value) {
            addCriterion("str >", value, "str");
            return (Criteria) this;
        }

        public Criteria andStrGreaterThanOrEqualTo(String value) {
            addCriterion("str >=", value, "str");
            return (Criteria) this;
        }

        public Criteria andStrLessThan(String value) {
            addCriterion("str <", value, "str");
            return (Criteria) this;
        }

        public Criteria andStrLessThanOrEqualTo(String value) {
            addCriterion("str <=", value, "str");
            return (Criteria) this;
        }

        public Criteria andStrLike(String value) {
            addCriterion("str like", value, "str");
            return (Criteria) this;
        }

        public Criteria andStrNotLike(String value) {
            addCriterion("str not like", value, "str");
            return (Criteria) this;
        }

        public Criteria andStrIn(List<String> values) {
            addCriterion("str in", values, "str");
            return (Criteria) this;
        }

        public Criteria andStrNotIn(List<String> values) {
            addCriterion("str not in", values, "str");
            return (Criteria) this;
        }

        public Criteria andStrBetween(String value1, String value2) {
            addCriterion("str between", value1, value2, "str");
            return (Criteria) this;
        }

        public Criteria andStrNotBetween(String value1, String value2) {
            addCriterion("str not between", value1, value2, "str");
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