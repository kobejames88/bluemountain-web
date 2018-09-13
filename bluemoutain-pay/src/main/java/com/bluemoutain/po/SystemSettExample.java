package com.bluemoutain.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemSettExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemSettExample() {
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

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(String value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(String value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(String value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(String value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(String value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(String value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLike(String value) {
            addCriterion("sid like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotLike(String value) {
            addCriterion("sid not like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<String> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<String> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(String value1, String value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(String value1, String value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andSettPreMoneyIsNull() {
            addCriterion("sett_pre_money is null");
            return (Criteria) this;
        }

        public Criteria andSettPreMoneyIsNotNull() {
            addCriterion("sett_pre_money is not null");
            return (Criteria) this;
        }

        public Criteria andSettPreMoneyEqualTo(BigDecimal value) {
            addCriterion("sett_pre_money =", value, "settPreMoney");
            return (Criteria) this;
        }

        public Criteria andSettPreMoneyNotEqualTo(BigDecimal value) {
            addCriterion("sett_pre_money <>", value, "settPreMoney");
            return (Criteria) this;
        }

        public Criteria andSettPreMoneyGreaterThan(BigDecimal value) {
            addCriterion("sett_pre_money >", value, "settPreMoney");
            return (Criteria) this;
        }

        public Criteria andSettPreMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sett_pre_money >=", value, "settPreMoney");
            return (Criteria) this;
        }

        public Criteria andSettPreMoneyLessThan(BigDecimal value) {
            addCriterion("sett_pre_money <", value, "settPreMoney");
            return (Criteria) this;
        }

        public Criteria andSettPreMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sett_pre_money <=", value, "settPreMoney");
            return (Criteria) this;
        }

        public Criteria andSettPreMoneyIn(List<BigDecimal> values) {
            addCriterion("sett_pre_money in", values, "settPreMoney");
            return (Criteria) this;
        }

        public Criteria andSettPreMoneyNotIn(List<BigDecimal> values) {
            addCriterion("sett_pre_money not in", values, "settPreMoney");
            return (Criteria) this;
        }

        public Criteria andSettPreMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sett_pre_money between", value1, value2, "settPreMoney");
            return (Criteria) this;
        }

        public Criteria andSettPreMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sett_pre_money not between", value1, value2, "settPreMoney");
            return (Criteria) this;
        }

        public Criteria andSettSubMoneyIsNull() {
            addCriterion("sett_sub_money is null");
            return (Criteria) this;
        }

        public Criteria andSettSubMoneyIsNotNull() {
            addCriterion("sett_sub_money is not null");
            return (Criteria) this;
        }

        public Criteria andSettSubMoneyEqualTo(BigDecimal value) {
            addCriterion("sett_sub_money =", value, "settSubMoney");
            return (Criteria) this;
        }

        public Criteria andSettSubMoneyNotEqualTo(BigDecimal value) {
            addCriterion("sett_sub_money <>", value, "settSubMoney");
            return (Criteria) this;
        }

        public Criteria andSettSubMoneyGreaterThan(BigDecimal value) {
            addCriterion("sett_sub_money >", value, "settSubMoney");
            return (Criteria) this;
        }

        public Criteria andSettSubMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sett_sub_money >=", value, "settSubMoney");
            return (Criteria) this;
        }

        public Criteria andSettSubMoneyLessThan(BigDecimal value) {
            addCriterion("sett_sub_money <", value, "settSubMoney");
            return (Criteria) this;
        }

        public Criteria andSettSubMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sett_sub_money <=", value, "settSubMoney");
            return (Criteria) this;
        }

        public Criteria andSettSubMoneyIn(List<BigDecimal> values) {
            addCriterion("sett_sub_money in", values, "settSubMoney");
            return (Criteria) this;
        }

        public Criteria andSettSubMoneyNotIn(List<BigDecimal> values) {
            addCriterion("sett_sub_money not in", values, "settSubMoney");
            return (Criteria) this;
        }

        public Criteria andSettSubMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sett_sub_money between", value1, value2, "settSubMoney");
            return (Criteria) this;
        }

        public Criteria andSettSubMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sett_sub_money not between", value1, value2, "settSubMoney");
            return (Criteria) this;
        }

        public Criteria andSettFinalMoneyIsNull() {
            addCriterion("sett_final_money is null");
            return (Criteria) this;
        }

        public Criteria andSettFinalMoneyIsNotNull() {
            addCriterion("sett_final_money is not null");
            return (Criteria) this;
        }

        public Criteria andSettFinalMoneyEqualTo(BigDecimal value) {
            addCriterion("sett_final_money =", value, "settFinalMoney");
            return (Criteria) this;
        }

        public Criteria andSettFinalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("sett_final_money <>", value, "settFinalMoney");
            return (Criteria) this;
        }

        public Criteria andSettFinalMoneyGreaterThan(BigDecimal value) {
            addCriterion("sett_final_money >", value, "settFinalMoney");
            return (Criteria) this;
        }

        public Criteria andSettFinalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sett_final_money >=", value, "settFinalMoney");
            return (Criteria) this;
        }

        public Criteria andSettFinalMoneyLessThan(BigDecimal value) {
            addCriterion("sett_final_money <", value, "settFinalMoney");
            return (Criteria) this;
        }

        public Criteria andSettFinalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sett_final_money <=", value, "settFinalMoney");
            return (Criteria) this;
        }

        public Criteria andSettFinalMoneyIn(List<BigDecimal> values) {
            addCriterion("sett_final_money in", values, "settFinalMoney");
            return (Criteria) this;
        }

        public Criteria andSettFinalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("sett_final_money not in", values, "settFinalMoney");
            return (Criteria) this;
        }

        public Criteria andSettFinalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sett_final_money between", value1, value2, "settFinalMoney");
            return (Criteria) this;
        }

        public Criteria andSettFinalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sett_final_money not between", value1, value2, "settFinalMoney");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andOkTimeIsNull() {
            addCriterion("ok_time is null");
            return (Criteria) this;
        }

        public Criteria andOkTimeIsNotNull() {
            addCriterion("ok_time is not null");
            return (Criteria) this;
        }

        public Criteria andOkTimeEqualTo(Date value) {
            addCriterion("ok_time =", value, "okTime");
            return (Criteria) this;
        }

        public Criteria andOkTimeNotEqualTo(Date value) {
            addCriterion("ok_time <>", value, "okTime");
            return (Criteria) this;
        }

        public Criteria andOkTimeGreaterThan(Date value) {
            addCriterion("ok_time >", value, "okTime");
            return (Criteria) this;
        }

        public Criteria andOkTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ok_time >=", value, "okTime");
            return (Criteria) this;
        }

        public Criteria andOkTimeLessThan(Date value) {
            addCriterion("ok_time <", value, "okTime");
            return (Criteria) this;
        }

        public Criteria andOkTimeLessThanOrEqualTo(Date value) {
            addCriterion("ok_time <=", value, "okTime");
            return (Criteria) this;
        }

        public Criteria andOkTimeIn(List<Date> values) {
            addCriterion("ok_time in", values, "okTime");
            return (Criteria) this;
        }

        public Criteria andOkTimeNotIn(List<Date> values) {
            addCriterion("ok_time not in", values, "okTime");
            return (Criteria) this;
        }

        public Criteria andOkTimeBetween(Date value1, Date value2) {
            addCriterion("ok_time between", value1, value2, "okTime");
            return (Criteria) this;
        }

        public Criteria andOkTimeNotBetween(Date value1, Date value2) {
            addCriterion("ok_time not between", value1, value2, "okTime");
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

        public Criteria andPreTypeIsNull() {
            addCriterion("pre_type is null");
            return (Criteria) this;
        }

        public Criteria andPreTypeIsNotNull() {
            addCriterion("pre_type is not null");
            return (Criteria) this;
        }

        public Criteria andPreTypeEqualTo(Integer value) {
            addCriterion("pre_type =", value, "preType");
            return (Criteria) this;
        }

        public Criteria andPreTypeNotEqualTo(Integer value) {
            addCriterion("pre_type <>", value, "preType");
            return (Criteria) this;
        }

        public Criteria andPreTypeGreaterThan(Integer value) {
            addCriterion("pre_type >", value, "preType");
            return (Criteria) this;
        }

        public Criteria andPreTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_type >=", value, "preType");
            return (Criteria) this;
        }

        public Criteria andPreTypeLessThan(Integer value) {
            addCriterion("pre_type <", value, "preType");
            return (Criteria) this;
        }

        public Criteria andPreTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pre_type <=", value, "preType");
            return (Criteria) this;
        }

        public Criteria andPreTypeIn(List<Integer> values) {
            addCriterion("pre_type in", values, "preType");
            return (Criteria) this;
        }

        public Criteria andPreTypeNotIn(List<Integer> values) {
            addCriterion("pre_type not in", values, "preType");
            return (Criteria) this;
        }

        public Criteria andPreTypeBetween(Integer value1, Integer value2) {
            addCriterion("pre_type between", value1, value2, "preType");
            return (Criteria) this;
        }

        public Criteria andPreTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_type not between", value1, value2, "preType");
            return (Criteria) this;
        }

        public Criteria andCtypeIsNull() {
            addCriterion("ctype is null");
            return (Criteria) this;
        }

        public Criteria andCtypeIsNotNull() {
            addCriterion("ctype is not null");
            return (Criteria) this;
        }

        public Criteria andCtypeEqualTo(Integer value) {
            addCriterion("ctype =", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotEqualTo(Integer value) {
            addCriterion("ctype <>", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeGreaterThan(Integer value) {
            addCriterion("ctype >", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ctype >=", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeLessThan(Integer value) {
            addCriterion("ctype <", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeLessThanOrEqualTo(Integer value) {
            addCriterion("ctype <=", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeIn(List<Integer> values) {
            addCriterion("ctype in", values, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotIn(List<Integer> values) {
            addCriterion("ctype not in", values, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeBetween(Integer value1, Integer value2) {
            addCriterion("ctype between", value1, value2, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ctype not between", value1, value2, "ctype");
            return (Criteria) this;
        }

        public Criteria andTranNoIsNull() {
            addCriterion("tran_no is null");
            return (Criteria) this;
        }

        public Criteria andTranNoIsNotNull() {
            addCriterion("tran_no is not null");
            return (Criteria) this;
        }

        public Criteria andTranNoEqualTo(String value) {
            addCriterion("tran_no =", value, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoNotEqualTo(String value) {
            addCriterion("tran_no <>", value, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoGreaterThan(String value) {
            addCriterion("tran_no >", value, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoGreaterThanOrEqualTo(String value) {
            addCriterion("tran_no >=", value, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoLessThan(String value) {
            addCriterion("tran_no <", value, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoLessThanOrEqualTo(String value) {
            addCriterion("tran_no <=", value, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoLike(String value) {
            addCriterion("tran_no like", value, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoNotLike(String value) {
            addCriterion("tran_no not like", value, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoIn(List<String> values) {
            addCriterion("tran_no in", values, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoNotIn(List<String> values) {
            addCriterion("tran_no not in", values, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoBetween(String value1, String value2) {
            addCriterion("tran_no between", value1, value2, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoNotBetween(String value1, String value2) {
            addCriterion("tran_no not between", value1, value2, "tranNo");
            return (Criteria) this;
        }

        public Criteria andSettErrorIsNull() {
            addCriterion("sett_error is null");
            return (Criteria) this;
        }

        public Criteria andSettErrorIsNotNull() {
            addCriterion("sett_error is not null");
            return (Criteria) this;
        }

        public Criteria andSettErrorEqualTo(String value) {
            addCriterion("sett_error =", value, "settError");
            return (Criteria) this;
        }

        public Criteria andSettErrorNotEqualTo(String value) {
            addCriterion("sett_error <>", value, "settError");
            return (Criteria) this;
        }

        public Criteria andSettErrorGreaterThan(String value) {
            addCriterion("sett_error >", value, "settError");
            return (Criteria) this;
        }

        public Criteria andSettErrorGreaterThanOrEqualTo(String value) {
            addCriterion("sett_error >=", value, "settError");
            return (Criteria) this;
        }

        public Criteria andSettErrorLessThan(String value) {
            addCriterion("sett_error <", value, "settError");
            return (Criteria) this;
        }

        public Criteria andSettErrorLessThanOrEqualTo(String value) {
            addCriterion("sett_error <=", value, "settError");
            return (Criteria) this;
        }

        public Criteria andSettErrorLike(String value) {
            addCriterion("sett_error like", value, "settError");
            return (Criteria) this;
        }

        public Criteria andSettErrorNotLike(String value) {
            addCriterion("sett_error not like", value, "settError");
            return (Criteria) this;
        }

        public Criteria andSettErrorIn(List<String> values) {
            addCriterion("sett_error in", values, "settError");
            return (Criteria) this;
        }

        public Criteria andSettErrorNotIn(List<String> values) {
            addCriterion("sett_error not in", values, "settError");
            return (Criteria) this;
        }

        public Criteria andSettErrorBetween(String value1, String value2) {
            addCriterion("sett_error between", value1, value2, "settError");
            return (Criteria) this;
        }

        public Criteria andSettErrorNotBetween(String value1, String value2) {
            addCriterion("sett_error not between", value1, value2, "settError");
            return (Criteria) this;
        }

        public Criteria andIsSettIsNull() {
            addCriterion("is_sett is null");
            return (Criteria) this;
        }

        public Criteria andIsSettIsNotNull() {
            addCriterion("is_sett is not null");
            return (Criteria) this;
        }

        public Criteria andIsSettEqualTo(Integer value) {
            addCriterion("is_sett =", value, "isSett");
            return (Criteria) this;
        }

        public Criteria andIsSettNotEqualTo(Integer value) {
            addCriterion("is_sett <>", value, "isSett");
            return (Criteria) this;
        }

        public Criteria andIsSettGreaterThan(Integer value) {
            addCriterion("is_sett >", value, "isSett");
            return (Criteria) this;
        }

        public Criteria andIsSettGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_sett >=", value, "isSett");
            return (Criteria) this;
        }

        public Criteria andIsSettLessThan(Integer value) {
            addCriterion("is_sett <", value, "isSett");
            return (Criteria) this;
        }

        public Criteria andIsSettLessThanOrEqualTo(Integer value) {
            addCriterion("is_sett <=", value, "isSett");
            return (Criteria) this;
        }

        public Criteria andIsSettIn(List<Integer> values) {
            addCriterion("is_sett in", values, "isSett");
            return (Criteria) this;
        }

        public Criteria andIsSettNotIn(List<Integer> values) {
            addCriterion("is_sett not in", values, "isSett");
            return (Criteria) this;
        }

        public Criteria andIsSettBetween(Integer value1, Integer value2) {
            addCriterion("is_sett between", value1, value2, "isSett");
            return (Criteria) this;
        }

        public Criteria andIsSettNotBetween(Integer value1, Integer value2) {
            addCriterion("is_sett not between", value1, value2, "isSett");
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