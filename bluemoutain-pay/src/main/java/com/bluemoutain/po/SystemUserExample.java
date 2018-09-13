package com.bluemoutain.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemUserExample() {
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

        public Criteria andUserIsNull() {
            addCriterion("user is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("user is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(String value) {
            addCriterion("user =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(String value) {
            addCriterion("user <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(String value) {
            addCriterion("user >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(String value) {
            addCriterion("user >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(String value) {
            addCriterion("user <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(String value) {
            addCriterion("user <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLike(String value) {
            addCriterion("user like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotLike(String value) {
            addCriterion("user not like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<String> values) {
            addCriterion("user in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<String> values) {
            addCriterion("user not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(String value1, String value2) {
            addCriterion("user between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(String value1, String value2) {
            addCriterion("user not between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andPwdIsNull() {
            addCriterion("pwd is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("pwd =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("pwd <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("pwd >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pwd >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("pwd <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("pwd <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("pwd like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("pwd not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("pwd in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("pwd not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("pwd not between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("role is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("role is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(Integer value) {
            addCriterion("role =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(Integer value) {
            addCriterion("role <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(Integer value) {
            addCriterion("role >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("role >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(Integer value) {
            addCriterion("role <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(Integer value) {
            addCriterion("role <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<Integer> values) {
            addCriterion("role in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<Integer> values) {
            addCriterion("role not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(Integer value1, Integer value2) {
            addCriterion("role between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("role not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andShownameIsNull() {
            addCriterion("showName is null");
            return (Criteria) this;
        }

        public Criteria andShownameIsNotNull() {
            addCriterion("showName is not null");
            return (Criteria) this;
        }

        public Criteria andShownameEqualTo(String value) {
            addCriterion("showName =", value, "showname");
            return (Criteria) this;
        }

        public Criteria andShownameNotEqualTo(String value) {
            addCriterion("showName <>", value, "showname");
            return (Criteria) this;
        }

        public Criteria andShownameGreaterThan(String value) {
            addCriterion("showName >", value, "showname");
            return (Criteria) this;
        }

        public Criteria andShownameGreaterThanOrEqualTo(String value) {
            addCriterion("showName >=", value, "showname");
            return (Criteria) this;
        }

        public Criteria andShownameLessThan(String value) {
            addCriterion("showName <", value, "showname");
            return (Criteria) this;
        }

        public Criteria andShownameLessThanOrEqualTo(String value) {
            addCriterion("showName <=", value, "showname");
            return (Criteria) this;
        }

        public Criteria andShownameLike(String value) {
            addCriterion("showName like", value, "showname");
            return (Criteria) this;
        }

        public Criteria andShownameNotLike(String value) {
            addCriterion("showName not like", value, "showname");
            return (Criteria) this;
        }

        public Criteria andShownameIn(List<String> values) {
            addCriterion("showName in", values, "showname");
            return (Criteria) this;
        }

        public Criteria andShownameNotIn(List<String> values) {
            addCriterion("showName not in", values, "showname");
            return (Criteria) this;
        }

        public Criteria andShownameBetween(String value1, String value2) {
            addCriterion("showName between", value1, value2, "showname");
            return (Criteria) this;
        }

        public Criteria andShownameNotBetween(String value1, String value2) {
            addCriterion("showName not between", value1, value2, "showname");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andCresteTimeIsNull() {
            addCriterion("creste_time is null");
            return (Criteria) this;
        }

        public Criteria andCresteTimeIsNotNull() {
            addCriterion("creste_time is not null");
            return (Criteria) this;
        }

        public Criteria andCresteTimeEqualTo(Date value) {
            addCriterion("creste_time =", value, "cresteTime");
            return (Criteria) this;
        }

        public Criteria andCresteTimeNotEqualTo(Date value) {
            addCriterion("creste_time <>", value, "cresteTime");
            return (Criteria) this;
        }

        public Criteria andCresteTimeGreaterThan(Date value) {
            addCriterion("creste_time >", value, "cresteTime");
            return (Criteria) this;
        }

        public Criteria andCresteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creste_time >=", value, "cresteTime");
            return (Criteria) this;
        }

        public Criteria andCresteTimeLessThan(Date value) {
            addCriterion("creste_time <", value, "cresteTime");
            return (Criteria) this;
        }

        public Criteria andCresteTimeLessThanOrEqualTo(Date value) {
            addCriterion("creste_time <=", value, "cresteTime");
            return (Criteria) this;
        }

        public Criteria andCresteTimeIn(List<Date> values) {
            addCriterion("creste_time in", values, "cresteTime");
            return (Criteria) this;
        }

        public Criteria andCresteTimeNotIn(List<Date> values) {
            addCriterion("creste_time not in", values, "cresteTime");
            return (Criteria) this;
        }

        public Criteria andCresteTimeBetween(Date value1, Date value2) {
            addCriterion("creste_time between", value1, value2, "cresteTime");
            return (Criteria) this;
        }

        public Criteria andCresteTimeNotBetween(Date value1, Date value2) {
            addCriterion("creste_time not between", value1, value2, "cresteTime");
            return (Criteria) this;
        }

        public Criteria andCreateIpIsNull() {
            addCriterion("create_ip is null");
            return (Criteria) this;
        }

        public Criteria andCreateIpIsNotNull() {
            addCriterion("create_ip is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIpEqualTo(String value) {
            addCriterion("create_ip =", value, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpNotEqualTo(String value) {
            addCriterion("create_ip <>", value, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpGreaterThan(String value) {
            addCriterion("create_ip >", value, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpGreaterThanOrEqualTo(String value) {
            addCriterion("create_ip >=", value, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpLessThan(String value) {
            addCriterion("create_ip <", value, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpLessThanOrEqualTo(String value) {
            addCriterion("create_ip <=", value, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpLike(String value) {
            addCriterion("create_ip like", value, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpNotLike(String value) {
            addCriterion("create_ip not like", value, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpIn(List<String> values) {
            addCriterion("create_ip in", values, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpNotIn(List<String> values) {
            addCriterion("create_ip not in", values, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpBetween(String value1, String value2) {
            addCriterion("create_ip between", value1, value2, "createIp");
            return (Criteria) this;
        }

        public Criteria andCreateIpNotBetween(String value1, String value2) {
            addCriterion("create_ip not between", value1, value2, "createIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("last_login_time is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("last_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("last_login_time =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("last_login_time <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("last_login_time >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_time >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("last_login_time <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_login_time <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("last_login_time in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("last_login_time not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("last_login_time between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andAppkeyIsNull() {
            addCriterion("appkey is null");
            return (Criteria) this;
        }

        public Criteria andAppkeyIsNotNull() {
            addCriterion("appkey is not null");
            return (Criteria) this;
        }

        public Criteria andAppkeyEqualTo(String value) {
            addCriterion("appkey =", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyNotEqualTo(String value) {
            addCriterion("appkey <>", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyGreaterThan(String value) {
            addCriterion("appkey >", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyGreaterThanOrEqualTo(String value) {
            addCriterion("appkey >=", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyLessThan(String value) {
            addCriterion("appkey <", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyLessThanOrEqualTo(String value) {
            addCriterion("appkey <=", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyLike(String value) {
            addCriterion("appkey like", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyNotLike(String value) {
            addCriterion("appkey not like", value, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyIn(List<String> values) {
            addCriterion("appkey in", values, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyNotIn(List<String> values) {
            addCriterion("appkey not in", values, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyBetween(String value1, String value2) {
            addCriterion("appkey between", value1, value2, "appkey");
            return (Criteria) this;
        }

        public Criteria andAppkeyNotBetween(String value1, String value2) {
            addCriterion("appkey not between", value1, value2, "appkey");
            return (Criteria) this;
        }

        public Criteria andBalnesIsNull() {
            addCriterion("balnes is null");
            return (Criteria) this;
        }

        public Criteria andBalnesIsNotNull() {
            addCriterion("balnes is not null");
            return (Criteria) this;
        }

        public Criteria andBalnesEqualTo(BigDecimal value) {
            addCriterion("balnes =", value, "balnes");
            return (Criteria) this;
        }

        public Criteria andBalnesNotEqualTo(BigDecimal value) {
            addCriterion("balnes <>", value, "balnes");
            return (Criteria) this;
        }

        public Criteria andBalnesGreaterThan(BigDecimal value) {
            addCriterion("balnes >", value, "balnes");
            return (Criteria) this;
        }

        public Criteria andBalnesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balnes >=", value, "balnes");
            return (Criteria) this;
        }

        public Criteria andBalnesLessThan(BigDecimal value) {
            addCriterion("balnes <", value, "balnes");
            return (Criteria) this;
        }

        public Criteria andBalnesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balnes <=", value, "balnes");
            return (Criteria) this;
        }

        public Criteria andBalnesIn(List<BigDecimal> values) {
            addCriterion("balnes in", values, "balnes");
            return (Criteria) this;
        }

        public Criteria andBalnesNotIn(List<BigDecimal> values) {
            addCriterion("balnes not in", values, "balnes");
            return (Criteria) this;
        }

        public Criteria andBalnesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balnes between", value1, value2, "balnes");
            return (Criteria) this;
        }

        public Criteria andBalnesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balnes not between", value1, value2, "balnes");
            return (Criteria) this;
        }

        public Criteria andZsnameIsNull() {
            addCriterion("zsname is null");
            return (Criteria) this;
        }

        public Criteria andZsnameIsNotNull() {
            addCriterion("zsname is not null");
            return (Criteria) this;
        }

        public Criteria andZsnameEqualTo(String value) {
            addCriterion("zsname =", value, "zsname");
            return (Criteria) this;
        }

        public Criteria andZsnameNotEqualTo(String value) {
            addCriterion("zsname <>", value, "zsname");
            return (Criteria) this;
        }

        public Criteria andZsnameGreaterThan(String value) {
            addCriterion("zsname >", value, "zsname");
            return (Criteria) this;
        }

        public Criteria andZsnameGreaterThanOrEqualTo(String value) {
            addCriterion("zsname >=", value, "zsname");
            return (Criteria) this;
        }

        public Criteria andZsnameLessThan(String value) {
            addCriterion("zsname <", value, "zsname");
            return (Criteria) this;
        }

        public Criteria andZsnameLessThanOrEqualTo(String value) {
            addCriterion("zsname <=", value, "zsname");
            return (Criteria) this;
        }

        public Criteria andZsnameLike(String value) {
            addCriterion("zsname like", value, "zsname");
            return (Criteria) this;
        }

        public Criteria andZsnameNotLike(String value) {
            addCriterion("zsname not like", value, "zsname");
            return (Criteria) this;
        }

        public Criteria andZsnameIn(List<String> values) {
            addCriterion("zsname in", values, "zsname");
            return (Criteria) this;
        }

        public Criteria andZsnameNotIn(List<String> values) {
            addCriterion("zsname not in", values, "zsname");
            return (Criteria) this;
        }

        public Criteria andZsnameBetween(String value1, String value2) {
            addCriterion("zsname between", value1, value2, "zsname");
            return (Criteria) this;
        }

        public Criteria andZsnameNotBetween(String value1, String value2) {
            addCriterion("zsname not between", value1, value2, "zsname");
            return (Criteria) this;
        }

        public Criteria andZspaytypeIsNull() {
            addCriterion("zspayType is null");
            return (Criteria) this;
        }

        public Criteria andZspaytypeIsNotNull() {
            addCriterion("zspayType is not null");
            return (Criteria) this;
        }

        public Criteria andZspaytypeEqualTo(Integer value) {
            addCriterion("zspayType =", value, "zspaytype");
            return (Criteria) this;
        }

        public Criteria andZspaytypeNotEqualTo(Integer value) {
            addCriterion("zspayType <>", value, "zspaytype");
            return (Criteria) this;
        }

        public Criteria andZspaytypeGreaterThan(Integer value) {
            addCriterion("zspayType >", value, "zspaytype");
            return (Criteria) this;
        }

        public Criteria andZspaytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("zspayType >=", value, "zspaytype");
            return (Criteria) this;
        }

        public Criteria andZspaytypeLessThan(Integer value) {
            addCriterion("zspayType <", value, "zspaytype");
            return (Criteria) this;
        }

        public Criteria andZspaytypeLessThanOrEqualTo(Integer value) {
            addCriterion("zspayType <=", value, "zspaytype");
            return (Criteria) this;
        }

        public Criteria andZspaytypeIn(List<Integer> values) {
            addCriterion("zspayType in", values, "zspaytype");
            return (Criteria) this;
        }

        public Criteria andZspaytypeNotIn(List<Integer> values) {
            addCriterion("zspayType not in", values, "zspaytype");
            return (Criteria) this;
        }

        public Criteria andZspaytypeBetween(Integer value1, Integer value2) {
            addCriterion("zspayType between", value1, value2, "zspaytype");
            return (Criteria) this;
        }

        public Criteria andZspaytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("zspayType not between", value1, value2, "zspaytype");
            return (Criteria) this;
        }

        public Criteria andZspayidIsNull() {
            addCriterion("zspayid is null");
            return (Criteria) this;
        }

        public Criteria andZspayidIsNotNull() {
            addCriterion("zspayid is not null");
            return (Criteria) this;
        }

        public Criteria andZspayidEqualTo(String value) {
            addCriterion("zspayid =", value, "zspayid");
            return (Criteria) this;
        }

        public Criteria andZspayidNotEqualTo(String value) {
            addCriterion("zspayid <>", value, "zspayid");
            return (Criteria) this;
        }

        public Criteria andZspayidGreaterThan(String value) {
            addCriterion("zspayid >", value, "zspayid");
            return (Criteria) this;
        }

        public Criteria andZspayidGreaterThanOrEqualTo(String value) {
            addCriterion("zspayid >=", value, "zspayid");
            return (Criteria) this;
        }

        public Criteria andZspayidLessThan(String value) {
            addCriterion("zspayid <", value, "zspayid");
            return (Criteria) this;
        }

        public Criteria andZspayidLessThanOrEqualTo(String value) {
            addCriterion("zspayid <=", value, "zspayid");
            return (Criteria) this;
        }

        public Criteria andZspayidLike(String value) {
            addCriterion("zspayid like", value, "zspayid");
            return (Criteria) this;
        }

        public Criteria andZspayidNotLike(String value) {
            addCriterion("zspayid not like", value, "zspayid");
            return (Criteria) this;
        }

        public Criteria andZspayidIn(List<String> values) {
            addCriterion("zspayid in", values, "zspayid");
            return (Criteria) this;
        }

        public Criteria andZspayidNotIn(List<String> values) {
            addCriterion("zspayid not in", values, "zspayid");
            return (Criteria) this;
        }

        public Criteria andZspayidBetween(String value1, String value2) {
            addCriterion("zspayid between", value1, value2, "zspayid");
            return (Criteria) this;
        }

        public Criteria andZspayidNotBetween(String value1, String value2) {
            addCriterion("zspayid not between", value1, value2, "zspayid");
            return (Criteria) this;
        }

        public Criteria andIsLockedIsNull() {
            addCriterion("is_locked is null");
            return (Criteria) this;
        }

        public Criteria andIsLockedIsNotNull() {
            addCriterion("is_locked is not null");
            return (Criteria) this;
        }

        public Criteria andIsLockedEqualTo(Integer value) {
            addCriterion("is_locked =", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedNotEqualTo(Integer value) {
            addCriterion("is_locked <>", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedGreaterThan(Integer value) {
            addCriterion("is_locked >", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_locked >=", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedLessThan(Integer value) {
            addCriterion("is_locked <", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedLessThanOrEqualTo(Integer value) {
            addCriterion("is_locked <=", value, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedIn(List<Integer> values) {
            addCriterion("is_locked in", values, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedNotIn(List<Integer> values) {
            addCriterion("is_locked not in", values, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedBetween(Integer value1, Integer value2) {
            addCriterion("is_locked between", value1, value2, "isLocked");
            return (Criteria) this;
        }

        public Criteria andIsLockedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_locked not between", value1, value2, "isLocked");
            return (Criteria) this;
        }

        public Criteria andUserParentIsNull() {
            addCriterion("user_parent is null");
            return (Criteria) this;
        }

        public Criteria andUserParentIsNotNull() {
            addCriterion("user_parent is not null");
            return (Criteria) this;
        }

        public Criteria andUserParentEqualTo(Integer value) {
            addCriterion("user_parent =", value, "userParent");
            return (Criteria) this;
        }

        public Criteria andUserParentNotEqualTo(Integer value) {
            addCriterion("user_parent <>", value, "userParent");
            return (Criteria) this;
        }

        public Criteria andUserParentGreaterThan(Integer value) {
            addCriterion("user_parent >", value, "userParent");
            return (Criteria) this;
        }

        public Criteria andUserParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_parent >=", value, "userParent");
            return (Criteria) this;
        }

        public Criteria andUserParentLessThan(Integer value) {
            addCriterion("user_parent <", value, "userParent");
            return (Criteria) this;
        }

        public Criteria andUserParentLessThanOrEqualTo(Integer value) {
            addCriterion("user_parent <=", value, "userParent");
            return (Criteria) this;
        }

        public Criteria andUserParentIn(List<Integer> values) {
            addCriterion("user_parent in", values, "userParent");
            return (Criteria) this;
        }

        public Criteria andUserParentNotIn(List<Integer> values) {
            addCriterion("user_parent not in", values, "userParent");
            return (Criteria) this;
        }

        public Criteria andUserParentBetween(Integer value1, Integer value2) {
            addCriterion("user_parent between", value1, value2, "userParent");
            return (Criteria) this;
        }

        public Criteria andUserParentNotBetween(Integer value1, Integer value2) {
            addCriterion("user_parent not between", value1, value2, "userParent");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andIsAutoSettIsNull() {
            addCriterion("is_auto_sett is null");
            return (Criteria) this;
        }

        public Criteria andIsAutoSettIsNotNull() {
            addCriterion("is_auto_sett is not null");
            return (Criteria) this;
        }

        public Criteria andIsAutoSettEqualTo(Integer value) {
            addCriterion("is_auto_sett =", value, "isAutoSett");
            return (Criteria) this;
        }

        public Criteria andIsAutoSettNotEqualTo(Integer value) {
            addCriterion("is_auto_sett <>", value, "isAutoSett");
            return (Criteria) this;
        }

        public Criteria andIsAutoSettGreaterThan(Integer value) {
            addCriterion("is_auto_sett >", value, "isAutoSett");
            return (Criteria) this;
        }

        public Criteria andIsAutoSettGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_auto_sett >=", value, "isAutoSett");
            return (Criteria) this;
        }

        public Criteria andIsAutoSettLessThan(Integer value) {
            addCriterion("is_auto_sett <", value, "isAutoSett");
            return (Criteria) this;
        }

        public Criteria andIsAutoSettLessThanOrEqualTo(Integer value) {
            addCriterion("is_auto_sett <=", value, "isAutoSett");
            return (Criteria) this;
        }

        public Criteria andIsAutoSettIn(List<Integer> values) {
            addCriterion("is_auto_sett in", values, "isAutoSett");
            return (Criteria) this;
        }

        public Criteria andIsAutoSettNotIn(List<Integer> values) {
            addCriterion("is_auto_sett not in", values, "isAutoSett");
            return (Criteria) this;
        }

        public Criteria andIsAutoSettBetween(Integer value1, Integer value2) {
            addCriterion("is_auto_sett between", value1, value2, "isAutoSett");
            return (Criteria) this;
        }

        public Criteria andIsAutoSettNotBetween(Integer value1, Integer value2) {
            addCriterion("is_auto_sett not between", value1, value2, "isAutoSett");
            return (Criteria) this;
        }

        public Criteria andCardBankCodeIsNull() {
            addCriterion("card_bank_code is null");
            return (Criteria) this;
        }

        public Criteria andCardBankCodeIsNotNull() {
            addCriterion("card_bank_code is not null");
            return (Criteria) this;
        }

        public Criteria andCardBankCodeEqualTo(String value) {
            addCriterion("card_bank_code =", value, "cardBankCode");
            return (Criteria) this;
        }

        public Criteria andCardBankCodeNotEqualTo(String value) {
            addCriterion("card_bank_code <>", value, "cardBankCode");
            return (Criteria) this;
        }

        public Criteria andCardBankCodeGreaterThan(String value) {
            addCriterion("card_bank_code >", value, "cardBankCode");
            return (Criteria) this;
        }

        public Criteria andCardBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("card_bank_code >=", value, "cardBankCode");
            return (Criteria) this;
        }

        public Criteria andCardBankCodeLessThan(String value) {
            addCriterion("card_bank_code <", value, "cardBankCode");
            return (Criteria) this;
        }

        public Criteria andCardBankCodeLessThanOrEqualTo(String value) {
            addCriterion("card_bank_code <=", value, "cardBankCode");
            return (Criteria) this;
        }

        public Criteria andCardBankCodeLike(String value) {
            addCriterion("card_bank_code like", value, "cardBankCode");
            return (Criteria) this;
        }

        public Criteria andCardBankCodeNotLike(String value) {
            addCriterion("card_bank_code not like", value, "cardBankCode");
            return (Criteria) this;
        }

        public Criteria andCardBankCodeIn(List<String> values) {
            addCriterion("card_bank_code in", values, "cardBankCode");
            return (Criteria) this;
        }

        public Criteria andCardBankCodeNotIn(List<String> values) {
            addCriterion("card_bank_code not in", values, "cardBankCode");
            return (Criteria) this;
        }

        public Criteria andCardBankCodeBetween(String value1, String value2) {
            addCriterion("card_bank_code between", value1, value2, "cardBankCode");
            return (Criteria) this;
        }

        public Criteria andCardBankCodeNotBetween(String value1, String value2) {
            addCriterion("card_bank_code not between", value1, value2, "cardBankCode");
            return (Criteria) this;
        }

        public Criteria andPayStaffIsNull() {
            addCriterion("pay_staff is null");
            return (Criteria) this;
        }

        public Criteria andPayStaffIsNotNull() {
            addCriterion("pay_staff is not null");
            return (Criteria) this;
        }

        public Criteria andPayStaffEqualTo(BigDecimal value) {
            addCriterion("pay_staff =", value, "payStaff");
            return (Criteria) this;
        }

        public Criteria andPayStaffNotEqualTo(BigDecimal value) {
            addCriterion("pay_staff <>", value, "payStaff");
            return (Criteria) this;
        }

        public Criteria andPayStaffGreaterThan(BigDecimal value) {
            addCriterion("pay_staff >", value, "payStaff");
            return (Criteria) this;
        }

        public Criteria andPayStaffGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_staff >=", value, "payStaff");
            return (Criteria) this;
        }

        public Criteria andPayStaffLessThan(BigDecimal value) {
            addCriterion("pay_staff <", value, "payStaff");
            return (Criteria) this;
        }

        public Criteria andPayStaffLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_staff <=", value, "payStaff");
            return (Criteria) this;
        }

        public Criteria andPayStaffIn(List<BigDecimal> values) {
            addCriterion("pay_staff in", values, "payStaff");
            return (Criteria) this;
        }

        public Criteria andPayStaffNotIn(List<BigDecimal> values) {
            addCriterion("pay_staff not in", values, "payStaff");
            return (Criteria) this;
        }

        public Criteria andPayStaffBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_staff between", value1, value2, "payStaff");
            return (Criteria) this;
        }

        public Criteria andPayStaffNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_staff not between", value1, value2, "payStaff");
            return (Criteria) this;
        }

        public Criteria andSettStaffIsNull() {
            addCriterion("sett_staff is null");
            return (Criteria) this;
        }

        public Criteria andSettStaffIsNotNull() {
            addCriterion("sett_staff is not null");
            return (Criteria) this;
        }

        public Criteria andSettStaffEqualTo(BigDecimal value) {
            addCriterion("sett_staff =", value, "settStaff");
            return (Criteria) this;
        }

        public Criteria andSettStaffNotEqualTo(BigDecimal value) {
            addCriterion("sett_staff <>", value, "settStaff");
            return (Criteria) this;
        }

        public Criteria andSettStaffGreaterThan(BigDecimal value) {
            addCriterion("sett_staff >", value, "settStaff");
            return (Criteria) this;
        }

        public Criteria andSettStaffGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sett_staff >=", value, "settStaff");
            return (Criteria) this;
        }

        public Criteria andSettStaffLessThan(BigDecimal value) {
            addCriterion("sett_staff <", value, "settStaff");
            return (Criteria) this;
        }

        public Criteria andSettStaffLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sett_staff <=", value, "settStaff");
            return (Criteria) this;
        }

        public Criteria andSettStaffIn(List<BigDecimal> values) {
            addCriterion("sett_staff in", values, "settStaff");
            return (Criteria) this;
        }

        public Criteria andSettStaffNotIn(List<BigDecimal> values) {
            addCriterion("sett_staff not in", values, "settStaff");
            return (Criteria) this;
        }

        public Criteria andSettStaffBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sett_staff between", value1, value2, "settStaff");
            return (Criteria) this;
        }

        public Criteria andSettStaffNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sett_staff not between", value1, value2, "settStaff");
            return (Criteria) this;
        }

        public Criteria andVipPayStaffIsNull() {
            addCriterion("vip_pay_staff is null");
            return (Criteria) this;
        }

        public Criteria andVipPayStaffIsNotNull() {
            addCriterion("vip_pay_staff is not null");
            return (Criteria) this;
        }

        public Criteria andVipPayStaffEqualTo(BigDecimal value) {
            addCriterion("vip_pay_staff =", value, "vipPayStaff");
            return (Criteria) this;
        }

        public Criteria andVipPayStaffNotEqualTo(BigDecimal value) {
            addCriterion("vip_pay_staff <>", value, "vipPayStaff");
            return (Criteria) this;
        }

        public Criteria andVipPayStaffGreaterThan(BigDecimal value) {
            addCriterion("vip_pay_staff >", value, "vipPayStaff");
            return (Criteria) this;
        }

        public Criteria andVipPayStaffGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_pay_staff >=", value, "vipPayStaff");
            return (Criteria) this;
        }

        public Criteria andVipPayStaffLessThan(BigDecimal value) {
            addCriterion("vip_pay_staff <", value, "vipPayStaff");
            return (Criteria) this;
        }

        public Criteria andVipPayStaffLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_pay_staff <=", value, "vipPayStaff");
            return (Criteria) this;
        }

        public Criteria andVipPayStaffIn(List<BigDecimal> values) {
            addCriterion("vip_pay_staff in", values, "vipPayStaff");
            return (Criteria) this;
        }

        public Criteria andVipPayStaffNotIn(List<BigDecimal> values) {
            addCriterion("vip_pay_staff not in", values, "vipPayStaff");
            return (Criteria) this;
        }

        public Criteria andVipPayStaffBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_pay_staff between", value1, value2, "vipPayStaff");
            return (Criteria) this;
        }

        public Criteria andVipPayStaffNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_pay_staff not between", value1, value2, "vipPayStaff");
            return (Criteria) this;
        }

        public Criteria andVipSettStaffIsNull() {
            addCriterion("vip_sett_staff is null");
            return (Criteria) this;
        }

        public Criteria andVipSettStaffIsNotNull() {
            addCriterion("vip_sett_staff is not null");
            return (Criteria) this;
        }

        public Criteria andVipSettStaffEqualTo(BigDecimal value) {
            addCriterion("vip_sett_staff =", value, "vipSettStaff");
            return (Criteria) this;
        }

        public Criteria andVipSettStaffNotEqualTo(BigDecimal value) {
            addCriterion("vip_sett_staff <>", value, "vipSettStaff");
            return (Criteria) this;
        }

        public Criteria andVipSettStaffGreaterThan(BigDecimal value) {
            addCriterion("vip_sett_staff >", value, "vipSettStaff");
            return (Criteria) this;
        }

        public Criteria andVipSettStaffGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_sett_staff >=", value, "vipSettStaff");
            return (Criteria) this;
        }

        public Criteria andVipSettStaffLessThan(BigDecimal value) {
            addCriterion("vip_sett_staff <", value, "vipSettStaff");
            return (Criteria) this;
        }

        public Criteria andVipSettStaffLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_sett_staff <=", value, "vipSettStaff");
            return (Criteria) this;
        }

        public Criteria andVipSettStaffIn(List<BigDecimal> values) {
            addCriterion("vip_sett_staff in", values, "vipSettStaff");
            return (Criteria) this;
        }

        public Criteria andVipSettStaffNotIn(List<BigDecimal> values) {
            addCriterion("vip_sett_staff not in", values, "vipSettStaff");
            return (Criteria) this;
        }

        public Criteria andVipSettStaffBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_sett_staff between", value1, value2, "vipSettStaff");
            return (Criteria) this;
        }

        public Criteria andVipSettStaffNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_sett_staff not between", value1, value2, "vipSettStaff");
            return (Criteria) this;
        }

        public Criteria andPayAlipayIsNull() {
            addCriterion("pay_alipay is null");
            return (Criteria) this;
        }

        public Criteria andPayAlipayIsNotNull() {
            addCriterion("pay_alipay is not null");
            return (Criteria) this;
        }

        public Criteria andPayAlipayEqualTo(Integer value) {
            addCriterion("pay_alipay =", value, "payAlipay");
            return (Criteria) this;
        }

        public Criteria andPayAlipayNotEqualTo(Integer value) {
            addCriterion("pay_alipay <>", value, "payAlipay");
            return (Criteria) this;
        }

        public Criteria andPayAlipayGreaterThan(Integer value) {
            addCriterion("pay_alipay >", value, "payAlipay");
            return (Criteria) this;
        }

        public Criteria andPayAlipayGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_alipay >=", value, "payAlipay");
            return (Criteria) this;
        }

        public Criteria andPayAlipayLessThan(Integer value) {
            addCriterion("pay_alipay <", value, "payAlipay");
            return (Criteria) this;
        }

        public Criteria andPayAlipayLessThanOrEqualTo(Integer value) {
            addCriterion("pay_alipay <=", value, "payAlipay");
            return (Criteria) this;
        }

        public Criteria andPayAlipayIn(List<Integer> values) {
            addCriterion("pay_alipay in", values, "payAlipay");
            return (Criteria) this;
        }

        public Criteria andPayAlipayNotIn(List<Integer> values) {
            addCriterion("pay_alipay not in", values, "payAlipay");
            return (Criteria) this;
        }

        public Criteria andPayAlipayBetween(Integer value1, Integer value2) {
            addCriterion("pay_alipay between", value1, value2, "payAlipay");
            return (Criteria) this;
        }

        public Criteria andPayAlipayNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_alipay not between", value1, value2, "payAlipay");
            return (Criteria) this;
        }

        public Criteria andPayQqpayIsNull() {
            addCriterion("pay_qqpay is null");
            return (Criteria) this;
        }

        public Criteria andPayQqpayIsNotNull() {
            addCriterion("pay_qqpay is not null");
            return (Criteria) this;
        }

        public Criteria andPayQqpayEqualTo(Integer value) {
            addCriterion("pay_qqpay =", value, "payQqpay");
            return (Criteria) this;
        }

        public Criteria andPayQqpayNotEqualTo(Integer value) {
            addCriterion("pay_qqpay <>", value, "payQqpay");
            return (Criteria) this;
        }

        public Criteria andPayQqpayGreaterThan(Integer value) {
            addCriterion("pay_qqpay >", value, "payQqpay");
            return (Criteria) this;
        }

        public Criteria andPayQqpayGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_qqpay >=", value, "payQqpay");
            return (Criteria) this;
        }

        public Criteria andPayQqpayLessThan(Integer value) {
            addCriterion("pay_qqpay <", value, "payQqpay");
            return (Criteria) this;
        }

        public Criteria andPayQqpayLessThanOrEqualTo(Integer value) {
            addCriterion("pay_qqpay <=", value, "payQqpay");
            return (Criteria) this;
        }

        public Criteria andPayQqpayIn(List<Integer> values) {
            addCriterion("pay_qqpay in", values, "payQqpay");
            return (Criteria) this;
        }

        public Criteria andPayQqpayNotIn(List<Integer> values) {
            addCriterion("pay_qqpay not in", values, "payQqpay");
            return (Criteria) this;
        }

        public Criteria andPayQqpayBetween(Integer value1, Integer value2) {
            addCriterion("pay_qqpay between", value1, value2, "payQqpay");
            return (Criteria) this;
        }

        public Criteria andPayQqpayNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_qqpay not between", value1, value2, "payQqpay");
            return (Criteria) this;
        }

        public Criteria andPayWxpayIsNull() {
            addCriterion("pay_wxpay is null");
            return (Criteria) this;
        }

        public Criteria andPayWxpayIsNotNull() {
            addCriterion("pay_wxpay is not null");
            return (Criteria) this;
        }

        public Criteria andPayWxpayEqualTo(Integer value) {
            addCriterion("pay_wxpay =", value, "payWxpay");
            return (Criteria) this;
        }

        public Criteria andPayWxpayNotEqualTo(Integer value) {
            addCriterion("pay_wxpay <>", value, "payWxpay");
            return (Criteria) this;
        }

        public Criteria andPayWxpayGreaterThan(Integer value) {
            addCriterion("pay_wxpay >", value, "payWxpay");
            return (Criteria) this;
        }

        public Criteria andPayWxpayGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_wxpay >=", value, "payWxpay");
            return (Criteria) this;
        }

        public Criteria andPayWxpayLessThan(Integer value) {
            addCriterion("pay_wxpay <", value, "payWxpay");
            return (Criteria) this;
        }

        public Criteria andPayWxpayLessThanOrEqualTo(Integer value) {
            addCriterion("pay_wxpay <=", value, "payWxpay");
            return (Criteria) this;
        }

        public Criteria andPayWxpayIn(List<Integer> values) {
            addCriterion("pay_wxpay in", values, "payWxpay");
            return (Criteria) this;
        }

        public Criteria andPayWxpayNotIn(List<Integer> values) {
            addCriterion("pay_wxpay not in", values, "payWxpay");
            return (Criteria) this;
        }

        public Criteria andPayWxpayBetween(Integer value1, Integer value2) {
            addCriterion("pay_wxpay between", value1, value2, "payWxpay");
            return (Criteria) this;
        }

        public Criteria andPayWxpayNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_wxpay not between", value1, value2, "payWxpay");
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