package com.bluemoutain.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SystemWebExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemWebExample() {
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

        public Criteria andPayStaff1IsNull() {
            addCriterion("pay_staff1 is null");
            return (Criteria) this;
        }

        public Criteria andPayStaff1IsNotNull() {
            addCriterion("pay_staff1 is not null");
            return (Criteria) this;
        }

        public Criteria andPayStaff1EqualTo(Double value) {
            addCriterion("pay_staff1 =", value, "payStaff1");
            return (Criteria) this;
        }

        public Criteria andPayStaff1NotEqualTo(Double value) {
            addCriterion("pay_staff1 <>", value, "payStaff1");
            return (Criteria) this;
        }

        public Criteria andPayStaff1GreaterThan(Double value) {
            addCriterion("pay_staff1 >", value, "payStaff1");
            return (Criteria) this;
        }

        public Criteria andPayStaff1GreaterThanOrEqualTo(Double value) {
            addCriterion("pay_staff1 >=", value, "payStaff1");
            return (Criteria) this;
        }

        public Criteria andPayStaff1LessThan(Double value) {
            addCriterion("pay_staff1 <", value, "payStaff1");
            return (Criteria) this;
        }

        public Criteria andPayStaff1LessThanOrEqualTo(Double value) {
            addCriterion("pay_staff1 <=", value, "payStaff1");
            return (Criteria) this;
        }

        public Criteria andPayStaff1In(List<Double> values) {
            addCriterion("pay_staff1 in", values, "payStaff1");
            return (Criteria) this;
        }

        public Criteria andPayStaff1NotIn(List<Double> values) {
            addCriterion("pay_staff1 not in", values, "payStaff1");
            return (Criteria) this;
        }

        public Criteria andPayStaff1Between(Double value1, Double value2) {
            addCriterion("pay_staff1 between", value1, value2, "payStaff1");
            return (Criteria) this;
        }

        public Criteria andPayStaff1NotBetween(Double value1, Double value2) {
            addCriterion("pay_staff1 not between", value1, value2, "payStaff1");
            return (Criteria) this;
        }

        public Criteria andPayStaff2IsNull() {
            addCriterion("pay_staff2 is null");
            return (Criteria) this;
        }

        public Criteria andPayStaff2IsNotNull() {
            addCriterion("pay_staff2 is not null");
            return (Criteria) this;
        }

        public Criteria andPayStaff2EqualTo(Double value) {
            addCriterion("pay_staff2 =", value, "payStaff2");
            return (Criteria) this;
        }

        public Criteria andPayStaff2NotEqualTo(Double value) {
            addCriterion("pay_staff2 <>", value, "payStaff2");
            return (Criteria) this;
        }

        public Criteria andPayStaff2GreaterThan(Double value) {
            addCriterion("pay_staff2 >", value, "payStaff2");
            return (Criteria) this;
        }

        public Criteria andPayStaff2GreaterThanOrEqualTo(Double value) {
            addCriterion("pay_staff2 >=", value, "payStaff2");
            return (Criteria) this;
        }

        public Criteria andPayStaff2LessThan(Double value) {
            addCriterion("pay_staff2 <", value, "payStaff2");
            return (Criteria) this;
        }

        public Criteria andPayStaff2LessThanOrEqualTo(Double value) {
            addCriterion("pay_staff2 <=", value, "payStaff2");
            return (Criteria) this;
        }

        public Criteria andPayStaff2In(List<Double> values) {
            addCriterion("pay_staff2 in", values, "payStaff2");
            return (Criteria) this;
        }

        public Criteria andPayStaff2NotIn(List<Double> values) {
            addCriterion("pay_staff2 not in", values, "payStaff2");
            return (Criteria) this;
        }

        public Criteria andPayStaff2Between(Double value1, Double value2) {
            addCriterion("pay_staff2 between", value1, value2, "payStaff2");
            return (Criteria) this;
        }

        public Criteria andPayStaff2NotBetween(Double value1, Double value2) {
            addCriterion("pay_staff2 not between", value1, value2, "payStaff2");
            return (Criteria) this;
        }

        public Criteria andKfqqqIsNull() {
            addCriterion("kfqqq is null");
            return (Criteria) this;
        }

        public Criteria andKfqqqIsNotNull() {
            addCriterion("kfqqq is not null");
            return (Criteria) this;
        }

        public Criteria andKfqqqEqualTo(String value) {
            addCriterion("kfqqq =", value, "kfqqq");
            return (Criteria) this;
        }

        public Criteria andKfqqqNotEqualTo(String value) {
            addCriterion("kfqqq <>", value, "kfqqq");
            return (Criteria) this;
        }

        public Criteria andKfqqqGreaterThan(String value) {
            addCriterion("kfqqq >", value, "kfqqq");
            return (Criteria) this;
        }

        public Criteria andKfqqqGreaterThanOrEqualTo(String value) {
            addCriterion("kfqqq >=", value, "kfqqq");
            return (Criteria) this;
        }

        public Criteria andKfqqqLessThan(String value) {
            addCriterion("kfqqq <", value, "kfqqq");
            return (Criteria) this;
        }

        public Criteria andKfqqqLessThanOrEqualTo(String value) {
            addCriterion("kfqqq <=", value, "kfqqq");
            return (Criteria) this;
        }

        public Criteria andKfqqqLike(String value) {
            addCriterion("kfqqq like", value, "kfqqq");
            return (Criteria) this;
        }

        public Criteria andKfqqqNotLike(String value) {
            addCriterion("kfqqq not like", value, "kfqqq");
            return (Criteria) this;
        }

        public Criteria andKfqqqIn(List<String> values) {
            addCriterion("kfqqq in", values, "kfqqq");
            return (Criteria) this;
        }

        public Criteria andKfqqqNotIn(List<String> values) {
            addCriterion("kfqqq not in", values, "kfqqq");
            return (Criteria) this;
        }

        public Criteria andKfqqqBetween(String value1, String value2) {
            addCriterion("kfqqq between", value1, value2, "kfqqq");
            return (Criteria) this;
        }

        public Criteria andKfqqqNotBetween(String value1, String value2) {
            addCriterion("kfqqq not between", value1, value2, "kfqqq");
            return (Criteria) this;
        }

        public Criteria andKfqqIsNull() {
            addCriterion("kfqq is null");
            return (Criteria) this;
        }

        public Criteria andKfqqIsNotNull() {
            addCriterion("kfqq is not null");
            return (Criteria) this;
        }

        public Criteria andKfqqEqualTo(String value) {
            addCriterion("kfqq =", value, "kfqq");
            return (Criteria) this;
        }

        public Criteria andKfqqNotEqualTo(String value) {
            addCriterion("kfqq <>", value, "kfqq");
            return (Criteria) this;
        }

        public Criteria andKfqqGreaterThan(String value) {
            addCriterion("kfqq >", value, "kfqq");
            return (Criteria) this;
        }

        public Criteria andKfqqGreaterThanOrEqualTo(String value) {
            addCriterion("kfqq >=", value, "kfqq");
            return (Criteria) this;
        }

        public Criteria andKfqqLessThan(String value) {
            addCriterion("kfqq <", value, "kfqq");
            return (Criteria) this;
        }

        public Criteria andKfqqLessThanOrEqualTo(String value) {
            addCriterion("kfqq <=", value, "kfqq");
            return (Criteria) this;
        }

        public Criteria andKfqqLike(String value) {
            addCriterion("kfqq like", value, "kfqq");
            return (Criteria) this;
        }

        public Criteria andKfqqNotLike(String value) {
            addCriterion("kfqq not like", value, "kfqq");
            return (Criteria) this;
        }

        public Criteria andKfqqIn(List<String> values) {
            addCriterion("kfqq in", values, "kfqq");
            return (Criteria) this;
        }

        public Criteria andKfqqNotIn(List<String> values) {
            addCriterion("kfqq not in", values, "kfqq");
            return (Criteria) this;
        }

        public Criteria andKfqqBetween(String value1, String value2) {
            addCriterion("kfqq between", value1, value2, "kfqq");
            return (Criteria) this;
        }

        public Criteria andKfqqNotBetween(String value1, String value2) {
            addCriterion("kfqq not between", value1, value2, "kfqq");
            return (Criteria) this;
        }

        public Criteria andSettMinIsNull() {
            addCriterion("sett_min is null");
            return (Criteria) this;
        }

        public Criteria andSettMinIsNotNull() {
            addCriterion("sett_min is not null");
            return (Criteria) this;
        }

        public Criteria andSettMinEqualTo(Double value) {
            addCriterion("sett_min =", value, "settMin");
            return (Criteria) this;
        }

        public Criteria andSettMinNotEqualTo(Double value) {
            addCriterion("sett_min <>", value, "settMin");
            return (Criteria) this;
        }

        public Criteria andSettMinGreaterThan(Double value) {
            addCriterion("sett_min >", value, "settMin");
            return (Criteria) this;
        }

        public Criteria andSettMinGreaterThanOrEqualTo(Double value) {
            addCriterion("sett_min >=", value, "settMin");
            return (Criteria) this;
        }

        public Criteria andSettMinLessThan(Double value) {
            addCriterion("sett_min <", value, "settMin");
            return (Criteria) this;
        }

        public Criteria andSettMinLessThanOrEqualTo(Double value) {
            addCriterion("sett_min <=", value, "settMin");
            return (Criteria) this;
        }

        public Criteria andSettMinIn(List<Double> values) {
            addCriterion("sett_min in", values, "settMin");
            return (Criteria) this;
        }

        public Criteria andSettMinNotIn(List<Double> values) {
            addCriterion("sett_min not in", values, "settMin");
            return (Criteria) this;
        }

        public Criteria andSettMinBetween(Double value1, Double value2) {
            addCriterion("sett_min between", value1, value2, "settMin");
            return (Criteria) this;
        }

        public Criteria andSettMinNotBetween(Double value1, Double value2) {
            addCriterion("sett_min not between", value1, value2, "settMin");
            return (Criteria) this;
        }

        public Criteria andHttpUrlIsNull() {
            addCriterion("http_url is null");
            return (Criteria) this;
        }

        public Criteria andHttpUrlIsNotNull() {
            addCriterion("http_url is not null");
            return (Criteria) this;
        }

        public Criteria andHttpUrlEqualTo(String value) {
            addCriterion("http_url =", value, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlNotEqualTo(String value) {
            addCriterion("http_url <>", value, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlGreaterThan(String value) {
            addCriterion("http_url >", value, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlGreaterThanOrEqualTo(String value) {
            addCriterion("http_url >=", value, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlLessThan(String value) {
            addCriterion("http_url <", value, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlLessThanOrEqualTo(String value) {
            addCriterion("http_url <=", value, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlLike(String value) {
            addCriterion("http_url like", value, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlNotLike(String value) {
            addCriterion("http_url not like", value, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlIn(List<String> values) {
            addCriterion("http_url in", values, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlNotIn(List<String> values) {
            addCriterion("http_url not in", values, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlBetween(String value1, String value2) {
            addCriterion("http_url between", value1, value2, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andHttpUrlNotBetween(String value1, String value2) {
            addCriterion("http_url not between", value1, value2, "httpUrl");
            return (Criteria) this;
        }

        public Criteria andCopyrightIsNull() {
            addCriterion("copyright is null");
            return (Criteria) this;
        }

        public Criteria andCopyrightIsNotNull() {
            addCriterion("copyright is not null");
            return (Criteria) this;
        }

        public Criteria andCopyrightEqualTo(String value) {
            addCriterion("copyright =", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightNotEqualTo(String value) {
            addCriterion("copyright <>", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightGreaterThan(String value) {
            addCriterion("copyright >", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightGreaterThanOrEqualTo(String value) {
            addCriterion("copyright >=", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightLessThan(String value) {
            addCriterion("copyright <", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightLessThanOrEqualTo(String value) {
            addCriterion("copyright <=", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightLike(String value) {
            addCriterion("copyright like", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightNotLike(String value) {
            addCriterion("copyright not like", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightIn(List<String> values) {
            addCriterion("copyright in", values, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightNotIn(List<String> values) {
            addCriterion("copyright not in", values, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightBetween(String value1, String value2) {
            addCriterion("copyright between", value1, value2, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightNotBetween(String value1, String value2) {
            addCriterion("copyright not between", value1, value2, "copyright");
            return (Criteria) this;
        }

        public Criteria andIcpInfoIsNull() {
            addCriterion("icp_info is null");
            return (Criteria) this;
        }

        public Criteria andIcpInfoIsNotNull() {
            addCriterion("icp_info is not null");
            return (Criteria) this;
        }

        public Criteria andIcpInfoEqualTo(String value) {
            addCriterion("icp_info =", value, "icpInfo");
            return (Criteria) this;
        }

        public Criteria andIcpInfoNotEqualTo(String value) {
            addCriterion("icp_info <>", value, "icpInfo");
            return (Criteria) this;
        }

        public Criteria andIcpInfoGreaterThan(String value) {
            addCriterion("icp_info >", value, "icpInfo");
            return (Criteria) this;
        }

        public Criteria andIcpInfoGreaterThanOrEqualTo(String value) {
            addCriterion("icp_info >=", value, "icpInfo");
            return (Criteria) this;
        }

        public Criteria andIcpInfoLessThan(String value) {
            addCriterion("icp_info <", value, "icpInfo");
            return (Criteria) this;
        }

        public Criteria andIcpInfoLessThanOrEqualTo(String value) {
            addCriterion("icp_info <=", value, "icpInfo");
            return (Criteria) this;
        }

        public Criteria andIcpInfoLike(String value) {
            addCriterion("icp_info like", value, "icpInfo");
            return (Criteria) this;
        }

        public Criteria andIcpInfoNotLike(String value) {
            addCriterion("icp_info not like", value, "icpInfo");
            return (Criteria) this;
        }

        public Criteria andIcpInfoIn(List<String> values) {
            addCriterion("icp_info in", values, "icpInfo");
            return (Criteria) this;
        }

        public Criteria andIcpInfoNotIn(List<String> values) {
            addCriterion("icp_info not in", values, "icpInfo");
            return (Criteria) this;
        }

        public Criteria andIcpInfoBetween(String value1, String value2) {
            addCriterion("icp_info between", value1, value2, "icpInfo");
            return (Criteria) this;
        }

        public Criteria andIcpInfoNotBetween(String value1, String value2) {
            addCriterion("icp_info not between", value1, value2, "icpInfo");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("keywords not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andDecTextIsNull() {
            addCriterion("dec_text is null");
            return (Criteria) this;
        }

        public Criteria andDecTextIsNotNull() {
            addCriterion("dec_text is not null");
            return (Criteria) this;
        }

        public Criteria andDecTextEqualTo(String value) {
            addCriterion("dec_text =", value, "decText");
            return (Criteria) this;
        }

        public Criteria andDecTextNotEqualTo(String value) {
            addCriterion("dec_text <>", value, "decText");
            return (Criteria) this;
        }

        public Criteria andDecTextGreaterThan(String value) {
            addCriterion("dec_text >", value, "decText");
            return (Criteria) this;
        }

        public Criteria andDecTextGreaterThanOrEqualTo(String value) {
            addCriterion("dec_text >=", value, "decText");
            return (Criteria) this;
        }

        public Criteria andDecTextLessThan(String value) {
            addCriterion("dec_text <", value, "decText");
            return (Criteria) this;
        }

        public Criteria andDecTextLessThanOrEqualTo(String value) {
            addCriterion("dec_text <=", value, "decText");
            return (Criteria) this;
        }

        public Criteria andDecTextLike(String value) {
            addCriterion("dec_text like", value, "decText");
            return (Criteria) this;
        }

        public Criteria andDecTextNotLike(String value) {
            addCriterion("dec_text not like", value, "decText");
            return (Criteria) this;
        }

        public Criteria andDecTextIn(List<String> values) {
            addCriterion("dec_text in", values, "decText");
            return (Criteria) this;
        }

        public Criteria andDecTextNotIn(List<String> values) {
            addCriterion("dec_text not in", values, "decText");
            return (Criteria) this;
        }

        public Criteria andDecTextBetween(String value1, String value2) {
            addCriterion("dec_text between", value1, value2, "decText");
            return (Criteria) this;
        }

        public Criteria andDecTextNotBetween(String value1, String value2) {
            addCriterion("dec_text not between", value1, value2, "decText");
            return (Criteria) this;
        }

        public Criteria andSiteNameIsNull() {
            addCriterion("site_name is null");
            return (Criteria) this;
        }

        public Criteria andSiteNameIsNotNull() {
            addCriterion("site_name is not null");
            return (Criteria) this;
        }

        public Criteria andSiteNameEqualTo(String value) {
            addCriterion("site_name =", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotEqualTo(String value) {
            addCriterion("site_name <>", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameGreaterThan(String value) {
            addCriterion("site_name >", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameGreaterThanOrEqualTo(String value) {
            addCriterion("site_name >=", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLessThan(String value) {
            addCriterion("site_name <", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLessThanOrEqualTo(String value) {
            addCriterion("site_name <=", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLike(String value) {
            addCriterion("site_name like", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotLike(String value) {
            addCriterion("site_name not like", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameIn(List<String> values) {
            addCriterion("site_name in", values, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotIn(List<String> values) {
            addCriterion("site_name not in", values, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameBetween(String value1, String value2) {
            addCriterion("site_name between", value1, value2, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotBetween(String value1, String value2) {
            addCriterion("site_name not between", value1, value2, "siteName");
            return (Criteria) this;
        }

        public Criteria andMusicIsNull() {
            addCriterion("music is null");
            return (Criteria) this;
        }

        public Criteria andMusicIsNotNull() {
            addCriterion("music is not null");
            return (Criteria) this;
        }

        public Criteria andMusicEqualTo(String value) {
            addCriterion("music =", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicNotEqualTo(String value) {
            addCriterion("music <>", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicGreaterThan(String value) {
            addCriterion("music >", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicGreaterThanOrEqualTo(String value) {
            addCriterion("music >=", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicLessThan(String value) {
            addCriterion("music <", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicLessThanOrEqualTo(String value) {
            addCriterion("music <=", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicLike(String value) {
            addCriterion("music like", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicNotLike(String value) {
            addCriterion("music not like", value, "music");
            return (Criteria) this;
        }

        public Criteria andMusicIn(List<String> values) {
            addCriterion("music in", values, "music");
            return (Criteria) this;
        }

        public Criteria andMusicNotIn(List<String> values) {
            addCriterion("music not in", values, "music");
            return (Criteria) this;
        }

        public Criteria andMusicBetween(String value1, String value2) {
            addCriterion("music between", value1, value2, "music");
            return (Criteria) this;
        }

        public Criteria andMusicNotBetween(String value1, String value2) {
            addCriterion("music not between", value1, value2, "music");
            return (Criteria) this;
        }

        public Criteria andRegPriceIsNull() {
            addCriterion("reg_price is null");
            return (Criteria) this;
        }

        public Criteria andRegPriceIsNotNull() {
            addCriterion("reg_price is not null");
            return (Criteria) this;
        }

        public Criteria andRegPriceEqualTo(BigDecimal value) {
            addCriterion("reg_price =", value, "regPrice");
            return (Criteria) this;
        }

        public Criteria andRegPriceNotEqualTo(BigDecimal value) {
            addCriterion("reg_price <>", value, "regPrice");
            return (Criteria) this;
        }

        public Criteria andRegPriceGreaterThan(BigDecimal value) {
            addCriterion("reg_price >", value, "regPrice");
            return (Criteria) this;
        }

        public Criteria andRegPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reg_price >=", value, "regPrice");
            return (Criteria) this;
        }

        public Criteria andRegPriceLessThan(BigDecimal value) {
            addCriterion("reg_price <", value, "regPrice");
            return (Criteria) this;
        }

        public Criteria andRegPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reg_price <=", value, "regPrice");
            return (Criteria) this;
        }

        public Criteria andRegPriceIn(List<BigDecimal> values) {
            addCriterion("reg_price in", values, "regPrice");
            return (Criteria) this;
        }

        public Criteria andRegPriceNotIn(List<BigDecimal> values) {
            addCriterion("reg_price not in", values, "regPrice");
            return (Criteria) this;
        }

        public Criteria andRegPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reg_price between", value1, value2, "regPrice");
            return (Criteria) this;
        }

        public Criteria andRegPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reg_price not between", value1, value2, "regPrice");
            return (Criteria) this;
        }

        public Criteria andQunUrlIsNull() {
            addCriterion("qun_url is null");
            return (Criteria) this;
        }

        public Criteria andQunUrlIsNotNull() {
            addCriterion("qun_url is not null");
            return (Criteria) this;
        }

        public Criteria andQunUrlEqualTo(String value) {
            addCriterion("qun_url =", value, "qunUrl");
            return (Criteria) this;
        }

        public Criteria andQunUrlNotEqualTo(String value) {
            addCriterion("qun_url <>", value, "qunUrl");
            return (Criteria) this;
        }

        public Criteria andQunUrlGreaterThan(String value) {
            addCriterion("qun_url >", value, "qunUrl");
            return (Criteria) this;
        }

        public Criteria andQunUrlGreaterThanOrEqualTo(String value) {
            addCriterion("qun_url >=", value, "qunUrl");
            return (Criteria) this;
        }

        public Criteria andQunUrlLessThan(String value) {
            addCriterion("qun_url <", value, "qunUrl");
            return (Criteria) this;
        }

        public Criteria andQunUrlLessThanOrEqualTo(String value) {
            addCriterion("qun_url <=", value, "qunUrl");
            return (Criteria) this;
        }

        public Criteria andQunUrlLike(String value) {
            addCriterion("qun_url like", value, "qunUrl");
            return (Criteria) this;
        }

        public Criteria andQunUrlNotLike(String value) {
            addCriterion("qun_url not like", value, "qunUrl");
            return (Criteria) this;
        }

        public Criteria andQunUrlIn(List<String> values) {
            addCriterion("qun_url in", values, "qunUrl");
            return (Criteria) this;
        }

        public Criteria andQunUrlNotIn(List<String> values) {
            addCriterion("qun_url not in", values, "qunUrl");
            return (Criteria) this;
        }

        public Criteria andQunUrlBetween(String value1, String value2) {
            addCriterion("qun_url between", value1, value2, "qunUrl");
            return (Criteria) this;
        }

        public Criteria andQunUrlNotBetween(String value1, String value2) {
            addCriterion("qun_url not between", value1, value2, "qunUrl");
            return (Criteria) this;
        }

        public Criteria andIsVeryDomainIsNull() {
            addCriterion("is_very_domain is null");
            return (Criteria) this;
        }

        public Criteria andIsVeryDomainIsNotNull() {
            addCriterion("is_very_domain is not null");
            return (Criteria) this;
        }

        public Criteria andIsVeryDomainEqualTo(Integer value) {
            addCriterion("is_very_domain =", value, "isVeryDomain");
            return (Criteria) this;
        }

        public Criteria andIsVeryDomainNotEqualTo(Integer value) {
            addCriterion("is_very_domain <>", value, "isVeryDomain");
            return (Criteria) this;
        }

        public Criteria andIsVeryDomainGreaterThan(Integer value) {
            addCriterion("is_very_domain >", value, "isVeryDomain");
            return (Criteria) this;
        }

        public Criteria andIsVeryDomainGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_very_domain >=", value, "isVeryDomain");
            return (Criteria) this;
        }

        public Criteria andIsVeryDomainLessThan(Integer value) {
            addCriterion("is_very_domain <", value, "isVeryDomain");
            return (Criteria) this;
        }

        public Criteria andIsVeryDomainLessThanOrEqualTo(Integer value) {
            addCriterion("is_very_domain <=", value, "isVeryDomain");
            return (Criteria) this;
        }

        public Criteria andIsVeryDomainIn(List<Integer> values) {
            addCriterion("is_very_domain in", values, "isVeryDomain");
            return (Criteria) this;
        }

        public Criteria andIsVeryDomainNotIn(List<Integer> values) {
            addCriterion("is_very_domain not in", values, "isVeryDomain");
            return (Criteria) this;
        }

        public Criteria andIsVeryDomainBetween(Integer value1, Integer value2) {
            addCriterion("is_very_domain between", value1, value2, "isVeryDomain");
            return (Criteria) this;
        }

        public Criteria andIsVeryDomainNotBetween(Integer value1, Integer value2) {
            addCriterion("is_very_domain not between", value1, value2, "isVeryDomain");
            return (Criteria) this;
        }

        public Criteria andAutoSettPayIsNull() {
            addCriterion("auto_sett_pay is null");
            return (Criteria) this;
        }

        public Criteria andAutoSettPayIsNotNull() {
            addCriterion("auto_sett_pay is not null");
            return (Criteria) this;
        }

        public Criteria andAutoSettPayEqualTo(Integer value) {
            addCriterion("auto_sett_pay =", value, "autoSettPay");
            return (Criteria) this;
        }

        public Criteria andAutoSettPayNotEqualTo(Integer value) {
            addCriterion("auto_sett_pay <>", value, "autoSettPay");
            return (Criteria) this;
        }

        public Criteria andAutoSettPayGreaterThan(Integer value) {
            addCriterion("auto_sett_pay >", value, "autoSettPay");
            return (Criteria) this;
        }

        public Criteria andAutoSettPayGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_sett_pay >=", value, "autoSettPay");
            return (Criteria) this;
        }

        public Criteria andAutoSettPayLessThan(Integer value) {
            addCriterion("auto_sett_pay <", value, "autoSettPay");
            return (Criteria) this;
        }

        public Criteria andAutoSettPayLessThanOrEqualTo(Integer value) {
            addCriterion("auto_sett_pay <=", value, "autoSettPay");
            return (Criteria) this;
        }

        public Criteria andAutoSettPayIn(List<Integer> values) {
            addCriterion("auto_sett_pay in", values, "autoSettPay");
            return (Criteria) this;
        }

        public Criteria andAutoSettPayNotIn(List<Integer> values) {
            addCriterion("auto_sett_pay not in", values, "autoSettPay");
            return (Criteria) this;
        }

        public Criteria andAutoSettPayBetween(Integer value1, Integer value2) {
            addCriterion("auto_sett_pay between", value1, value2, "autoSettPay");
            return (Criteria) this;
        }

        public Criteria andAutoSettPayNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_sett_pay not between", value1, value2, "autoSettPay");
            return (Criteria) this;
        }

        public Criteria andRegRoleIsNull() {
            addCriterion("reg_role is null");
            return (Criteria) this;
        }

        public Criteria andRegRoleIsNotNull() {
            addCriterion("reg_role is not null");
            return (Criteria) this;
        }

        public Criteria andRegRoleEqualTo(Integer value) {
            addCriterion("reg_role =", value, "regRole");
            return (Criteria) this;
        }

        public Criteria andRegRoleNotEqualTo(Integer value) {
            addCriterion("reg_role <>", value, "regRole");
            return (Criteria) this;
        }

        public Criteria andRegRoleGreaterThan(Integer value) {
            addCriterion("reg_role >", value, "regRole");
            return (Criteria) this;
        }

        public Criteria andRegRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("reg_role >=", value, "regRole");
            return (Criteria) this;
        }

        public Criteria andRegRoleLessThan(Integer value) {
            addCriterion("reg_role <", value, "regRole");
            return (Criteria) this;
        }

        public Criteria andRegRoleLessThanOrEqualTo(Integer value) {
            addCriterion("reg_role <=", value, "regRole");
            return (Criteria) this;
        }

        public Criteria andRegRoleIn(List<Integer> values) {
            addCriterion("reg_role in", values, "regRole");
            return (Criteria) this;
        }

        public Criteria andRegRoleNotIn(List<Integer> values) {
            addCriterion("reg_role not in", values, "regRole");
            return (Criteria) this;
        }

        public Criteria andRegRoleBetween(Integer value1, Integer value2) {
            addCriterion("reg_role between", value1, value2, "regRole");
            return (Criteria) this;
        }

        public Criteria andRegRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("reg_role not between", value1, value2, "regRole");
            return (Criteria) this;
        }

        public Criteria andUserCreateRoleIsNull() {
            addCriterion("user_create_role is null");
            return (Criteria) this;
        }

        public Criteria andUserCreateRoleIsNotNull() {
            addCriterion("user_create_role is not null");
            return (Criteria) this;
        }

        public Criteria andUserCreateRoleEqualTo(Integer value) {
            addCriterion("user_create_role =", value, "userCreateRole");
            return (Criteria) this;
        }

        public Criteria andUserCreateRoleNotEqualTo(Integer value) {
            addCriterion("user_create_role <>", value, "userCreateRole");
            return (Criteria) this;
        }

        public Criteria andUserCreateRoleGreaterThan(Integer value) {
            addCriterion("user_create_role >", value, "userCreateRole");
            return (Criteria) this;
        }

        public Criteria andUserCreateRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_create_role >=", value, "userCreateRole");
            return (Criteria) this;
        }

        public Criteria andUserCreateRoleLessThan(Integer value) {
            addCriterion("user_create_role <", value, "userCreateRole");
            return (Criteria) this;
        }

        public Criteria andUserCreateRoleLessThanOrEqualTo(Integer value) {
            addCriterion("user_create_role <=", value, "userCreateRole");
            return (Criteria) this;
        }

        public Criteria andUserCreateRoleIn(List<Integer> values) {
            addCriterion("user_create_role in", values, "userCreateRole");
            return (Criteria) this;
        }

        public Criteria andUserCreateRoleNotIn(List<Integer> values) {
            addCriterion("user_create_role not in", values, "userCreateRole");
            return (Criteria) this;
        }

        public Criteria andUserCreateRoleBetween(Integer value1, Integer value2) {
            addCriterion("user_create_role between", value1, value2, "userCreateRole");
            return (Criteria) this;
        }

        public Criteria andUserCreateRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("user_create_role not between", value1, value2, "userCreateRole");
            return (Criteria) this;
        }

        public Criteria andPayUrlCheckIsNull() {
            addCriterion("pay_url_check is null");
            return (Criteria) this;
        }

        public Criteria andPayUrlCheckIsNotNull() {
            addCriterion("pay_url_check is not null");
            return (Criteria) this;
        }

        public Criteria andPayUrlCheckEqualTo(Integer value) {
            addCriterion("pay_url_check =", value, "payUrlCheck");
            return (Criteria) this;
        }

        public Criteria andPayUrlCheckNotEqualTo(Integer value) {
            addCriterion("pay_url_check <>", value, "payUrlCheck");
            return (Criteria) this;
        }

        public Criteria andPayUrlCheckGreaterThan(Integer value) {
            addCriterion("pay_url_check >", value, "payUrlCheck");
            return (Criteria) this;
        }

        public Criteria andPayUrlCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_url_check >=", value, "payUrlCheck");
            return (Criteria) this;
        }

        public Criteria andPayUrlCheckLessThan(Integer value) {
            addCriterion("pay_url_check <", value, "payUrlCheck");
            return (Criteria) this;
        }

        public Criteria andPayUrlCheckLessThanOrEqualTo(Integer value) {
            addCriterion("pay_url_check <=", value, "payUrlCheck");
            return (Criteria) this;
        }

        public Criteria andPayUrlCheckIn(List<Integer> values) {
            addCriterion("pay_url_check in", values, "payUrlCheck");
            return (Criteria) this;
        }

        public Criteria andPayUrlCheckNotIn(List<Integer> values) {
            addCriterion("pay_url_check not in", values, "payUrlCheck");
            return (Criteria) this;
        }

        public Criteria andPayUrlCheckBetween(Integer value1, Integer value2) {
            addCriterion("pay_url_check between", value1, value2, "payUrlCheck");
            return (Criteria) this;
        }

        public Criteria andPayUrlCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_url_check not between", value1, value2, "payUrlCheck");
            return (Criteria) this;
        }

        public Criteria andVipSaleIsNull() {
            addCriterion("vip_sale is null");
            return (Criteria) this;
        }

        public Criteria andVipSaleIsNotNull() {
            addCriterion("vip_sale is not null");
            return (Criteria) this;
        }

        public Criteria andVipSaleEqualTo(BigDecimal value) {
            addCriterion("vip_sale =", value, "vipSale");
            return (Criteria) this;
        }

        public Criteria andVipSaleNotEqualTo(BigDecimal value) {
            addCriterion("vip_sale <>", value, "vipSale");
            return (Criteria) this;
        }

        public Criteria andVipSaleGreaterThan(BigDecimal value) {
            addCriterion("vip_sale >", value, "vipSale");
            return (Criteria) this;
        }

        public Criteria andVipSaleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_sale >=", value, "vipSale");
            return (Criteria) this;
        }

        public Criteria andVipSaleLessThan(BigDecimal value) {
            addCriterion("vip_sale <", value, "vipSale");
            return (Criteria) this;
        }

        public Criteria andVipSaleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_sale <=", value, "vipSale");
            return (Criteria) this;
        }

        public Criteria andVipSaleIn(List<BigDecimal> values) {
            addCriterion("vip_sale in", values, "vipSale");
            return (Criteria) this;
        }

        public Criteria andVipSaleNotIn(List<BigDecimal> values) {
            addCriterion("vip_sale not in", values, "vipSale");
            return (Criteria) this;
        }

        public Criteria andVipSaleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_sale between", value1, value2, "vipSale");
            return (Criteria) this;
        }

        public Criteria andVipSaleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_sale not between", value1, value2, "vipSale");
            return (Criteria) this;
        }

        public Criteria andVipStaff2IsNull() {
            addCriterion("vip_staff2 is null");
            return (Criteria) this;
        }

        public Criteria andVipStaff2IsNotNull() {
            addCriterion("vip_staff2 is not null");
            return (Criteria) this;
        }

        public Criteria andVipStaff2EqualTo(BigDecimal value) {
            addCriterion("vip_staff2 =", value, "vipStaff2");
            return (Criteria) this;
        }

        public Criteria andVipStaff2NotEqualTo(BigDecimal value) {
            addCriterion("vip_staff2 <>", value, "vipStaff2");
            return (Criteria) this;
        }

        public Criteria andVipStaff2GreaterThan(BigDecimal value) {
            addCriterion("vip_staff2 >", value, "vipStaff2");
            return (Criteria) this;
        }

        public Criteria andVipStaff2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_staff2 >=", value, "vipStaff2");
            return (Criteria) this;
        }

        public Criteria andVipStaff2LessThan(BigDecimal value) {
            addCriterion("vip_staff2 <", value, "vipStaff2");
            return (Criteria) this;
        }

        public Criteria andVipStaff2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_staff2 <=", value, "vipStaff2");
            return (Criteria) this;
        }

        public Criteria andVipStaff2In(List<BigDecimal> values) {
            addCriterion("vip_staff2 in", values, "vipStaff2");
            return (Criteria) this;
        }

        public Criteria andVipStaff2NotIn(List<BigDecimal> values) {
            addCriterion("vip_staff2 not in", values, "vipStaff2");
            return (Criteria) this;
        }

        public Criteria andVipStaff2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_staff2 between", value1, value2, "vipStaff2");
            return (Criteria) this;
        }

        public Criteria andVipStaff2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_staff2 not between", value1, value2, "vipStaff2");
            return (Criteria) this;
        }

        public Criteria andVipStaff1IsNull() {
            addCriterion("vip_staff1 is null");
            return (Criteria) this;
        }

        public Criteria andVipStaff1IsNotNull() {
            addCriterion("vip_staff1 is not null");
            return (Criteria) this;
        }

        public Criteria andVipStaff1EqualTo(BigDecimal value) {
            addCriterion("vip_staff1 =", value, "vipStaff1");
            return (Criteria) this;
        }

        public Criteria andVipStaff1NotEqualTo(BigDecimal value) {
            addCriterion("vip_staff1 <>", value, "vipStaff1");
            return (Criteria) this;
        }

        public Criteria andVipStaff1GreaterThan(BigDecimal value) {
            addCriterion("vip_staff1 >", value, "vipStaff1");
            return (Criteria) this;
        }

        public Criteria andVipStaff1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_staff1 >=", value, "vipStaff1");
            return (Criteria) this;
        }

        public Criteria andVipStaff1LessThan(BigDecimal value) {
            addCriterion("vip_staff1 <", value, "vipStaff1");
            return (Criteria) this;
        }

        public Criteria andVipStaff1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("vip_staff1 <=", value, "vipStaff1");
            return (Criteria) this;
        }

        public Criteria andVipStaff1In(List<BigDecimal> values) {
            addCriterion("vip_staff1 in", values, "vipStaff1");
            return (Criteria) this;
        }

        public Criteria andVipStaff1NotIn(List<BigDecimal> values) {
            addCriterion("vip_staff1 not in", values, "vipStaff1");
            return (Criteria) this;
        }

        public Criteria andVipStaff1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_staff1 between", value1, value2, "vipStaff1");
            return (Criteria) this;
        }

        public Criteria andVipStaff1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vip_staff1 not between", value1, value2, "vipStaff1");
            return (Criteria) this;
        }

        public Criteria andVipMethodIsNull() {
            addCriterion("vip_method is null");
            return (Criteria) this;
        }

        public Criteria andVipMethodIsNotNull() {
            addCriterion("vip_method is not null");
            return (Criteria) this;
        }

        public Criteria andVipMethodEqualTo(Integer value) {
            addCriterion("vip_method =", value, "vipMethod");
            return (Criteria) this;
        }

        public Criteria andVipMethodNotEqualTo(Integer value) {
            addCriterion("vip_method <>", value, "vipMethod");
            return (Criteria) this;
        }

        public Criteria andVipMethodGreaterThan(Integer value) {
            addCriterion("vip_method >", value, "vipMethod");
            return (Criteria) this;
        }

        public Criteria andVipMethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("vip_method >=", value, "vipMethod");
            return (Criteria) this;
        }

        public Criteria andVipMethodLessThan(Integer value) {
            addCriterion("vip_method <", value, "vipMethod");
            return (Criteria) this;
        }

        public Criteria andVipMethodLessThanOrEqualTo(Integer value) {
            addCriterion("vip_method <=", value, "vipMethod");
            return (Criteria) this;
        }

        public Criteria andVipMethodIn(List<Integer> values) {
            addCriterion("vip_method in", values, "vipMethod");
            return (Criteria) this;
        }

        public Criteria andVipMethodNotIn(List<Integer> values) {
            addCriterion("vip_method not in", values, "vipMethod");
            return (Criteria) this;
        }

        public Criteria andVipMethodBetween(Integer value1, Integer value2) {
            addCriterion("vip_method between", value1, value2, "vipMethod");
            return (Criteria) this;
        }

        public Criteria andVipMethodNotBetween(Integer value1, Integer value2) {
            addCriterion("vip_method not between", value1, value2, "vipMethod");
            return (Criteria) this;
        }

        public Criteria andIsApiOpenIsNull() {
            addCriterion("is_api_open is null");
            return (Criteria) this;
        }

        public Criteria andIsApiOpenIsNotNull() {
            addCriterion("is_api_open is not null");
            return (Criteria) this;
        }

        public Criteria andIsApiOpenEqualTo(Integer value) {
            addCriterion("is_api_open =", value, "isApiOpen");
            return (Criteria) this;
        }

        public Criteria andIsApiOpenNotEqualTo(Integer value) {
            addCriterion("is_api_open <>", value, "isApiOpen");
            return (Criteria) this;
        }

        public Criteria andIsApiOpenGreaterThan(Integer value) {
            addCriterion("is_api_open >", value, "isApiOpen");
            return (Criteria) this;
        }

        public Criteria andIsApiOpenGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_api_open >=", value, "isApiOpen");
            return (Criteria) this;
        }

        public Criteria andIsApiOpenLessThan(Integer value) {
            addCriterion("is_api_open <", value, "isApiOpen");
            return (Criteria) this;
        }

        public Criteria andIsApiOpenLessThanOrEqualTo(Integer value) {
            addCriterion("is_api_open <=", value, "isApiOpen");
            return (Criteria) this;
        }

        public Criteria andIsApiOpenIn(List<Integer> values) {
            addCriterion("is_api_open in", values, "isApiOpen");
            return (Criteria) this;
        }

        public Criteria andIsApiOpenNotIn(List<Integer> values) {
            addCriterion("is_api_open not in", values, "isApiOpen");
            return (Criteria) this;
        }

        public Criteria andIsApiOpenBetween(Integer value1, Integer value2) {
            addCriterion("is_api_open between", value1, value2, "isApiOpen");
            return (Criteria) this;
        }

        public Criteria andIsApiOpenNotBetween(Integer value1, Integer value2) {
            addCriterion("is_api_open not between", value1, value2, "isApiOpen");
            return (Criteria) this;
        }

        public Criteria andCloseApiDetialIsNull() {
            addCriterion("close_api_detial is null");
            return (Criteria) this;
        }

        public Criteria andCloseApiDetialIsNotNull() {
            addCriterion("close_api_detial is not null");
            return (Criteria) this;
        }

        public Criteria andCloseApiDetialEqualTo(String value) {
            addCriterion("close_api_detial =", value, "closeApiDetial");
            return (Criteria) this;
        }

        public Criteria andCloseApiDetialNotEqualTo(String value) {
            addCriterion("close_api_detial <>", value, "closeApiDetial");
            return (Criteria) this;
        }

        public Criteria andCloseApiDetialGreaterThan(String value) {
            addCriterion("close_api_detial >", value, "closeApiDetial");
            return (Criteria) this;
        }

        public Criteria andCloseApiDetialGreaterThanOrEqualTo(String value) {
            addCriterion("close_api_detial >=", value, "closeApiDetial");
            return (Criteria) this;
        }

        public Criteria andCloseApiDetialLessThan(String value) {
            addCriterion("close_api_detial <", value, "closeApiDetial");
            return (Criteria) this;
        }

        public Criteria andCloseApiDetialLessThanOrEqualTo(String value) {
            addCriterion("close_api_detial <=", value, "closeApiDetial");
            return (Criteria) this;
        }

        public Criteria andCloseApiDetialLike(String value) {
            addCriterion("close_api_detial like", value, "closeApiDetial");
            return (Criteria) this;
        }

        public Criteria andCloseApiDetialNotLike(String value) {
            addCriterion("close_api_detial not like", value, "closeApiDetial");
            return (Criteria) this;
        }

        public Criteria andCloseApiDetialIn(List<String> values) {
            addCriterion("close_api_detial in", values, "closeApiDetial");
            return (Criteria) this;
        }

        public Criteria andCloseApiDetialNotIn(List<String> values) {
            addCriterion("close_api_detial not in", values, "closeApiDetial");
            return (Criteria) this;
        }

        public Criteria andCloseApiDetialBetween(String value1, String value2) {
            addCriterion("close_api_detial between", value1, value2, "closeApiDetial");
            return (Criteria) this;
        }

        public Criteria andCloseApiDetialNotBetween(String value1, String value2) {
            addCriterion("close_api_detial not between", value1, value2, "closeApiDetial");
            return (Criteria) this;
        }

        public Criteria andSysThreamsIsNull() {
            addCriterion("sys_threams is null");
            return (Criteria) this;
        }

        public Criteria andSysThreamsIsNotNull() {
            addCriterion("sys_threams is not null");
            return (Criteria) this;
        }

        public Criteria andSysThreamsEqualTo(Integer value) {
            addCriterion("sys_threams =", value, "sysThreams");
            return (Criteria) this;
        }

        public Criteria andSysThreamsNotEqualTo(Integer value) {
            addCriterion("sys_threams <>", value, "sysThreams");
            return (Criteria) this;
        }

        public Criteria andSysThreamsGreaterThan(Integer value) {
            addCriterion("sys_threams >", value, "sysThreams");
            return (Criteria) this;
        }

        public Criteria andSysThreamsGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_threams >=", value, "sysThreams");
            return (Criteria) this;
        }

        public Criteria andSysThreamsLessThan(Integer value) {
            addCriterion("sys_threams <", value, "sysThreams");
            return (Criteria) this;
        }

        public Criteria andSysThreamsLessThanOrEqualTo(Integer value) {
            addCriterion("sys_threams <=", value, "sysThreams");
            return (Criteria) this;
        }

        public Criteria andSysThreamsIn(List<Integer> values) {
            addCriterion("sys_threams in", values, "sysThreams");
            return (Criteria) this;
        }

        public Criteria andSysThreamsNotIn(List<Integer> values) {
            addCriterion("sys_threams not in", values, "sysThreams");
            return (Criteria) this;
        }

        public Criteria andSysThreamsBetween(Integer value1, Integer value2) {
            addCriterion("sys_threams between", value1, value2, "sysThreams");
            return (Criteria) this;
        }

        public Criteria andSysThreamsNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_threams not between", value1, value2, "sysThreams");
            return (Criteria) this;
        }

        public Criteria andUserRegIsNull() {
            addCriterion("user_reg is null");
            return (Criteria) this;
        }

        public Criteria andUserRegIsNotNull() {
            addCriterion("user_reg is not null");
            return (Criteria) this;
        }

        public Criteria andUserRegEqualTo(Integer value) {
            addCriterion("user_reg =", value, "userReg");
            return (Criteria) this;
        }

        public Criteria andUserRegNotEqualTo(Integer value) {
            addCriterion("user_reg <>", value, "userReg");
            return (Criteria) this;
        }

        public Criteria andUserRegGreaterThan(Integer value) {
            addCriterion("user_reg >", value, "userReg");
            return (Criteria) this;
        }

        public Criteria andUserRegGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_reg >=", value, "userReg");
            return (Criteria) this;
        }

        public Criteria andUserRegLessThan(Integer value) {
            addCriterion("user_reg <", value, "userReg");
            return (Criteria) this;
        }

        public Criteria andUserRegLessThanOrEqualTo(Integer value) {
            addCriterion("user_reg <=", value, "userReg");
            return (Criteria) this;
        }

        public Criteria andUserRegIn(List<Integer> values) {
            addCriterion("user_reg in", values, "userReg");
            return (Criteria) this;
        }

        public Criteria andUserRegNotIn(List<Integer> values) {
            addCriterion("user_reg not in", values, "userReg");
            return (Criteria) this;
        }

        public Criteria andUserRegBetween(Integer value1, Integer value2) {
            addCriterion("user_reg between", value1, value2, "userReg");
            return (Criteria) this;
        }

        public Criteria andUserRegNotBetween(Integer value1, Integer value2) {
            addCriterion("user_reg not between", value1, value2, "userReg");
            return (Criteria) this;
        }

        public Criteria andPayTitleIsNull() {
            addCriterion("pay_title is null");
            return (Criteria) this;
        }

        public Criteria andPayTitleIsNotNull() {
            addCriterion("pay_title is not null");
            return (Criteria) this;
        }

        public Criteria andPayTitleEqualTo(String value) {
            addCriterion("pay_title =", value, "payTitle");
            return (Criteria) this;
        }

        public Criteria andPayTitleNotEqualTo(String value) {
            addCriterion("pay_title <>", value, "payTitle");
            return (Criteria) this;
        }

        public Criteria andPayTitleGreaterThan(String value) {
            addCriterion("pay_title >", value, "payTitle");
            return (Criteria) this;
        }

        public Criteria andPayTitleGreaterThanOrEqualTo(String value) {
            addCriterion("pay_title >=", value, "payTitle");
            return (Criteria) this;
        }

        public Criteria andPayTitleLessThan(String value) {
            addCriterion("pay_title <", value, "payTitle");
            return (Criteria) this;
        }

        public Criteria andPayTitleLessThanOrEqualTo(String value) {
            addCriterion("pay_title <=", value, "payTitle");
            return (Criteria) this;
        }

        public Criteria andPayTitleLike(String value) {
            addCriterion("pay_title like", value, "payTitle");
            return (Criteria) this;
        }

        public Criteria andPayTitleNotLike(String value) {
            addCriterion("pay_title not like", value, "payTitle");
            return (Criteria) this;
        }

        public Criteria andPayTitleIn(List<String> values) {
            addCriterion("pay_title in", values, "payTitle");
            return (Criteria) this;
        }

        public Criteria andPayTitleNotIn(List<String> values) {
            addCriterion("pay_title not in", values, "payTitle");
            return (Criteria) this;
        }

        public Criteria andPayTitleBetween(String value1, String value2) {
            addCriterion("pay_title between", value1, value2, "payTitle");
            return (Criteria) this;
        }

        public Criteria andPayTitleNotBetween(String value1, String value2) {
            addCriterion("pay_title not between", value1, value2, "payTitle");
            return (Criteria) this;
        }

        public Criteria andUseUserQqIsNull() {
            addCriterion("use_user_qq is null");
            return (Criteria) this;
        }

        public Criteria andUseUserQqIsNotNull() {
            addCriterion("use_user_qq is not null");
            return (Criteria) this;
        }

        public Criteria andUseUserQqEqualTo(Integer value) {
            addCriterion("use_user_qq =", value, "useUserQq");
            return (Criteria) this;
        }

        public Criteria andUseUserQqNotEqualTo(Integer value) {
            addCriterion("use_user_qq <>", value, "useUserQq");
            return (Criteria) this;
        }

        public Criteria andUseUserQqGreaterThan(Integer value) {
            addCriterion("use_user_qq >", value, "useUserQq");
            return (Criteria) this;
        }

        public Criteria andUseUserQqGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_user_qq >=", value, "useUserQq");
            return (Criteria) this;
        }

        public Criteria andUseUserQqLessThan(Integer value) {
            addCriterion("use_user_qq <", value, "useUserQq");
            return (Criteria) this;
        }

        public Criteria andUseUserQqLessThanOrEqualTo(Integer value) {
            addCriterion("use_user_qq <=", value, "useUserQq");
            return (Criteria) this;
        }

        public Criteria andUseUserQqIn(List<Integer> values) {
            addCriterion("use_user_qq in", values, "useUserQq");
            return (Criteria) this;
        }

        public Criteria andUseUserQqNotIn(List<Integer> values) {
            addCriterion("use_user_qq not in", values, "useUserQq");
            return (Criteria) this;
        }

        public Criteria andUseUserQqBetween(Integer value1, Integer value2) {
            addCriterion("use_user_qq between", value1, value2, "useUserQq");
            return (Criteria) this;
        }

        public Criteria andUseUserQqNotBetween(Integer value1, Integer value2) {
            addCriterion("use_user_qq not between", value1, value2, "useUserQq");
            return (Criteria) this;
        }

        public Criteria andShowPayReadmeIsNull() {
            addCriterion("show_pay_readme is null");
            return (Criteria) this;
        }

        public Criteria andShowPayReadmeIsNotNull() {
            addCriterion("show_pay_readme is not null");
            return (Criteria) this;
        }

        public Criteria andShowPayReadmeEqualTo(Integer value) {
            addCriterion("show_pay_readme =", value, "showPayReadme");
            return (Criteria) this;
        }

        public Criteria andShowPayReadmeNotEqualTo(Integer value) {
            addCriterion("show_pay_readme <>", value, "showPayReadme");
            return (Criteria) this;
        }

        public Criteria andShowPayReadmeGreaterThan(Integer value) {
            addCriterion("show_pay_readme >", value, "showPayReadme");
            return (Criteria) this;
        }

        public Criteria andShowPayReadmeGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_pay_readme >=", value, "showPayReadme");
            return (Criteria) this;
        }

        public Criteria andShowPayReadmeLessThan(Integer value) {
            addCriterion("show_pay_readme <", value, "showPayReadme");
            return (Criteria) this;
        }

        public Criteria andShowPayReadmeLessThanOrEqualTo(Integer value) {
            addCriterion("show_pay_readme <=", value, "showPayReadme");
            return (Criteria) this;
        }

        public Criteria andShowPayReadmeIn(List<Integer> values) {
            addCriterion("show_pay_readme in", values, "showPayReadme");
            return (Criteria) this;
        }

        public Criteria andShowPayReadmeNotIn(List<Integer> values) {
            addCriterion("show_pay_readme not in", values, "showPayReadme");
            return (Criteria) this;
        }

        public Criteria andShowPayReadmeBetween(Integer value1, Integer value2) {
            addCriterion("show_pay_readme between", value1, value2, "showPayReadme");
            return (Criteria) this;
        }

        public Criteria andShowPayReadmeNotBetween(Integer value1, Integer value2) {
            addCriterion("show_pay_readme not between", value1, value2, "showPayReadme");
            return (Criteria) this;
        }

        public Criteria andPayToAlipayIsNull() {
            addCriterion("pay_to_alipay is null");
            return (Criteria) this;
        }

        public Criteria andPayToAlipayIsNotNull() {
            addCriterion("pay_to_alipay is not null");
            return (Criteria) this;
        }

        public Criteria andPayToAlipayEqualTo(Integer value) {
            addCriterion("pay_to_alipay =", value, "payToAlipay");
            return (Criteria) this;
        }

        public Criteria andPayToAlipayNotEqualTo(Integer value) {
            addCriterion("pay_to_alipay <>", value, "payToAlipay");
            return (Criteria) this;
        }

        public Criteria andPayToAlipayGreaterThan(Integer value) {
            addCriterion("pay_to_alipay >", value, "payToAlipay");
            return (Criteria) this;
        }

        public Criteria andPayToAlipayGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_to_alipay >=", value, "payToAlipay");
            return (Criteria) this;
        }

        public Criteria andPayToAlipayLessThan(Integer value) {
            addCriterion("pay_to_alipay <", value, "payToAlipay");
            return (Criteria) this;
        }

        public Criteria andPayToAlipayLessThanOrEqualTo(Integer value) {
            addCriterion("pay_to_alipay <=", value, "payToAlipay");
            return (Criteria) this;
        }

        public Criteria andPayToAlipayIn(List<Integer> values) {
            addCriterion("pay_to_alipay in", values, "payToAlipay");
            return (Criteria) this;
        }

        public Criteria andPayToAlipayNotIn(List<Integer> values) {
            addCriterion("pay_to_alipay not in", values, "payToAlipay");
            return (Criteria) this;
        }

        public Criteria andPayToAlipayBetween(Integer value1, Integer value2) {
            addCriterion("pay_to_alipay between", value1, value2, "payToAlipay");
            return (Criteria) this;
        }

        public Criteria andPayToAlipayNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_to_alipay not between", value1, value2, "payToAlipay");
            return (Criteria) this;
        }

        public Criteria andPayToWxpayIsNull() {
            addCriterion("pay_to_wxpay is null");
            return (Criteria) this;
        }

        public Criteria andPayToWxpayIsNotNull() {
            addCriterion("pay_to_wxpay is not null");
            return (Criteria) this;
        }

        public Criteria andPayToWxpayEqualTo(Integer value) {
            addCriterion("pay_to_wxpay =", value, "payToWxpay");
            return (Criteria) this;
        }

        public Criteria andPayToWxpayNotEqualTo(Integer value) {
            addCriterion("pay_to_wxpay <>", value, "payToWxpay");
            return (Criteria) this;
        }

        public Criteria andPayToWxpayGreaterThan(Integer value) {
            addCriterion("pay_to_wxpay >", value, "payToWxpay");
            return (Criteria) this;
        }

        public Criteria andPayToWxpayGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_to_wxpay >=", value, "payToWxpay");
            return (Criteria) this;
        }

        public Criteria andPayToWxpayLessThan(Integer value) {
            addCriterion("pay_to_wxpay <", value, "payToWxpay");
            return (Criteria) this;
        }

        public Criteria andPayToWxpayLessThanOrEqualTo(Integer value) {
            addCriterion("pay_to_wxpay <=", value, "payToWxpay");
            return (Criteria) this;
        }

        public Criteria andPayToWxpayIn(List<Integer> values) {
            addCriterion("pay_to_wxpay in", values, "payToWxpay");
            return (Criteria) this;
        }

        public Criteria andPayToWxpayNotIn(List<Integer> values) {
            addCriterion("pay_to_wxpay not in", values, "payToWxpay");
            return (Criteria) this;
        }

        public Criteria andPayToWxpayBetween(Integer value1, Integer value2) {
            addCriterion("pay_to_wxpay between", value1, value2, "payToWxpay");
            return (Criteria) this;
        }

        public Criteria andPayToWxpayNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_to_wxpay not between", value1, value2, "payToWxpay");
            return (Criteria) this;
        }

        public Criteria andPayToQqpayIsNull() {
            addCriterion("pay_to_qqpay is null");
            return (Criteria) this;
        }

        public Criteria andPayToQqpayIsNotNull() {
            addCriterion("pay_to_qqpay is not null");
            return (Criteria) this;
        }

        public Criteria andPayToQqpayEqualTo(Integer value) {
            addCriterion("pay_to_qqpay =", value, "payToQqpay");
            return (Criteria) this;
        }

        public Criteria andPayToQqpayNotEqualTo(Integer value) {
            addCriterion("pay_to_qqpay <>", value, "payToQqpay");
            return (Criteria) this;
        }

        public Criteria andPayToQqpayGreaterThan(Integer value) {
            addCriterion("pay_to_qqpay >", value, "payToQqpay");
            return (Criteria) this;
        }

        public Criteria andPayToQqpayGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_to_qqpay >=", value, "payToQqpay");
            return (Criteria) this;
        }

        public Criteria andPayToQqpayLessThan(Integer value) {
            addCriterion("pay_to_qqpay <", value, "payToQqpay");
            return (Criteria) this;
        }

        public Criteria andPayToQqpayLessThanOrEqualTo(Integer value) {
            addCriterion("pay_to_qqpay <=", value, "payToQqpay");
            return (Criteria) this;
        }

        public Criteria andPayToQqpayIn(List<Integer> values) {
            addCriterion("pay_to_qqpay in", values, "payToQqpay");
            return (Criteria) this;
        }

        public Criteria andPayToQqpayNotIn(List<Integer> values) {
            addCriterion("pay_to_qqpay not in", values, "payToQqpay");
            return (Criteria) this;
        }

        public Criteria andPayToQqpayBetween(Integer value1, Integer value2) {
            addCriterion("pay_to_qqpay between", value1, value2, "payToQqpay");
            return (Criteria) this;
        }

        public Criteria andPayToQqpayNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_to_qqpay not between", value1, value2, "payToQqpay");
            return (Criteria) this;
        }

        public Criteria andTestAlipayIsNull() {
            addCriterion("test_alipay is null");
            return (Criteria) this;
        }

        public Criteria andTestAlipayIsNotNull() {
            addCriterion("test_alipay is not null");
            return (Criteria) this;
        }

        public Criteria andTestAlipayEqualTo(Integer value) {
            addCriterion("test_alipay =", value, "testAlipay");
            return (Criteria) this;
        }

        public Criteria andTestAlipayNotEqualTo(Integer value) {
            addCriterion("test_alipay <>", value, "testAlipay");
            return (Criteria) this;
        }

        public Criteria andTestAlipayGreaterThan(Integer value) {
            addCriterion("test_alipay >", value, "testAlipay");
            return (Criteria) this;
        }

        public Criteria andTestAlipayGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_alipay >=", value, "testAlipay");
            return (Criteria) this;
        }

        public Criteria andTestAlipayLessThan(Integer value) {
            addCriterion("test_alipay <", value, "testAlipay");
            return (Criteria) this;
        }

        public Criteria andTestAlipayLessThanOrEqualTo(Integer value) {
            addCriterion("test_alipay <=", value, "testAlipay");
            return (Criteria) this;
        }

        public Criteria andTestAlipayIn(List<Integer> values) {
            addCriterion("test_alipay in", values, "testAlipay");
            return (Criteria) this;
        }

        public Criteria andTestAlipayNotIn(List<Integer> values) {
            addCriterion("test_alipay not in", values, "testAlipay");
            return (Criteria) this;
        }

        public Criteria andTestAlipayBetween(Integer value1, Integer value2) {
            addCriterion("test_alipay between", value1, value2, "testAlipay");
            return (Criteria) this;
        }

        public Criteria andTestAlipayNotBetween(Integer value1, Integer value2) {
            addCriterion("test_alipay not between", value1, value2, "testAlipay");
            return (Criteria) this;
        }

        public Criteria andTestQqpayIsNull() {
            addCriterion("test_qqpay is null");
            return (Criteria) this;
        }

        public Criteria andTestQqpayIsNotNull() {
            addCriterion("test_qqpay is not null");
            return (Criteria) this;
        }

        public Criteria andTestQqpayEqualTo(Integer value) {
            addCriterion("test_qqpay =", value, "testQqpay");
            return (Criteria) this;
        }

        public Criteria andTestQqpayNotEqualTo(Integer value) {
            addCriterion("test_qqpay <>", value, "testQqpay");
            return (Criteria) this;
        }

        public Criteria andTestQqpayGreaterThan(Integer value) {
            addCriterion("test_qqpay >", value, "testQqpay");
            return (Criteria) this;
        }

        public Criteria andTestQqpayGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_qqpay >=", value, "testQqpay");
            return (Criteria) this;
        }

        public Criteria andTestQqpayLessThan(Integer value) {
            addCriterion("test_qqpay <", value, "testQqpay");
            return (Criteria) this;
        }

        public Criteria andTestQqpayLessThanOrEqualTo(Integer value) {
            addCriterion("test_qqpay <=", value, "testQqpay");
            return (Criteria) this;
        }

        public Criteria andTestQqpayIn(List<Integer> values) {
            addCriterion("test_qqpay in", values, "testQqpay");
            return (Criteria) this;
        }

        public Criteria andTestQqpayNotIn(List<Integer> values) {
            addCriterion("test_qqpay not in", values, "testQqpay");
            return (Criteria) this;
        }

        public Criteria andTestQqpayBetween(Integer value1, Integer value2) {
            addCriterion("test_qqpay between", value1, value2, "testQqpay");
            return (Criteria) this;
        }

        public Criteria andTestQqpayNotBetween(Integer value1, Integer value2) {
            addCriterion("test_qqpay not between", value1, value2, "testQqpay");
            return (Criteria) this;
        }

        public Criteria andTestWxpayIsNull() {
            addCriterion("test_wxpay is null");
            return (Criteria) this;
        }

        public Criteria andTestWxpayIsNotNull() {
            addCriterion("test_wxpay is not null");
            return (Criteria) this;
        }

        public Criteria andTestWxpayEqualTo(Integer value) {
            addCriterion("test_wxpay =", value, "testWxpay");
            return (Criteria) this;
        }

        public Criteria andTestWxpayNotEqualTo(Integer value) {
            addCriterion("test_wxpay <>", value, "testWxpay");
            return (Criteria) this;
        }

        public Criteria andTestWxpayGreaterThan(Integer value) {
            addCriterion("test_wxpay >", value, "testWxpay");
            return (Criteria) this;
        }

        public Criteria andTestWxpayGreaterThanOrEqualTo(Integer value) {
            addCriterion("test_wxpay >=", value, "testWxpay");
            return (Criteria) this;
        }

        public Criteria andTestWxpayLessThan(Integer value) {
            addCriterion("test_wxpay <", value, "testWxpay");
            return (Criteria) this;
        }

        public Criteria andTestWxpayLessThanOrEqualTo(Integer value) {
            addCriterion("test_wxpay <=", value, "testWxpay");
            return (Criteria) this;
        }

        public Criteria andTestWxpayIn(List<Integer> values) {
            addCriterion("test_wxpay in", values, "testWxpay");
            return (Criteria) this;
        }

        public Criteria andTestWxpayNotIn(List<Integer> values) {
            addCriterion("test_wxpay not in", values, "testWxpay");
            return (Criteria) this;
        }

        public Criteria andTestWxpayBetween(Integer value1, Integer value2) {
            addCriterion("test_wxpay between", value1, value2, "testWxpay");
            return (Criteria) this;
        }

        public Criteria andTestWxpayNotBetween(Integer value1, Integer value2) {
            addCriterion("test_wxpay not between", value1, value2, "testWxpay");
            return (Criteria) this;
        }

        public Criteria andRegAlipayIsNull() {
            addCriterion("reg_alipay is null");
            return (Criteria) this;
        }

        public Criteria andRegAlipayIsNotNull() {
            addCriterion("reg_alipay is not null");
            return (Criteria) this;
        }

        public Criteria andRegAlipayEqualTo(Integer value) {
            addCriterion("reg_alipay =", value, "regAlipay");
            return (Criteria) this;
        }

        public Criteria andRegAlipayNotEqualTo(Integer value) {
            addCriterion("reg_alipay <>", value, "regAlipay");
            return (Criteria) this;
        }

        public Criteria andRegAlipayGreaterThan(Integer value) {
            addCriterion("reg_alipay >", value, "regAlipay");
            return (Criteria) this;
        }

        public Criteria andRegAlipayGreaterThanOrEqualTo(Integer value) {
            addCriterion("reg_alipay >=", value, "regAlipay");
            return (Criteria) this;
        }

        public Criteria andRegAlipayLessThan(Integer value) {
            addCriterion("reg_alipay <", value, "regAlipay");
            return (Criteria) this;
        }

        public Criteria andRegAlipayLessThanOrEqualTo(Integer value) {
            addCriterion("reg_alipay <=", value, "regAlipay");
            return (Criteria) this;
        }

        public Criteria andRegAlipayIn(List<Integer> values) {
            addCriterion("reg_alipay in", values, "regAlipay");
            return (Criteria) this;
        }

        public Criteria andRegAlipayNotIn(List<Integer> values) {
            addCriterion("reg_alipay not in", values, "regAlipay");
            return (Criteria) this;
        }

        public Criteria andRegAlipayBetween(Integer value1, Integer value2) {
            addCriterion("reg_alipay between", value1, value2, "regAlipay");
            return (Criteria) this;
        }

        public Criteria andRegAlipayNotBetween(Integer value1, Integer value2) {
            addCriterion("reg_alipay not between", value1, value2, "regAlipay");
            return (Criteria) this;
        }

        public Criteria andRegQqpayIsNull() {
            addCriterion("reg_qqpay is null");
            return (Criteria) this;
        }

        public Criteria andRegQqpayIsNotNull() {
            addCriterion("reg_qqpay is not null");
            return (Criteria) this;
        }

        public Criteria andRegQqpayEqualTo(Integer value) {
            addCriterion("reg_qqpay =", value, "regQqpay");
            return (Criteria) this;
        }

        public Criteria andRegQqpayNotEqualTo(Integer value) {
            addCriterion("reg_qqpay <>", value, "regQqpay");
            return (Criteria) this;
        }

        public Criteria andRegQqpayGreaterThan(Integer value) {
            addCriterion("reg_qqpay >", value, "regQqpay");
            return (Criteria) this;
        }

        public Criteria andRegQqpayGreaterThanOrEqualTo(Integer value) {
            addCriterion("reg_qqpay >=", value, "regQqpay");
            return (Criteria) this;
        }

        public Criteria andRegQqpayLessThan(Integer value) {
            addCriterion("reg_qqpay <", value, "regQqpay");
            return (Criteria) this;
        }

        public Criteria andRegQqpayLessThanOrEqualTo(Integer value) {
            addCriterion("reg_qqpay <=", value, "regQqpay");
            return (Criteria) this;
        }

        public Criteria andRegQqpayIn(List<Integer> values) {
            addCriterion("reg_qqpay in", values, "regQqpay");
            return (Criteria) this;
        }

        public Criteria andRegQqpayNotIn(List<Integer> values) {
            addCriterion("reg_qqpay not in", values, "regQqpay");
            return (Criteria) this;
        }

        public Criteria andRegQqpayBetween(Integer value1, Integer value2) {
            addCriterion("reg_qqpay between", value1, value2, "regQqpay");
            return (Criteria) this;
        }

        public Criteria andRegQqpayNotBetween(Integer value1, Integer value2) {
            addCriterion("reg_qqpay not between", value1, value2, "regQqpay");
            return (Criteria) this;
        }

        public Criteria andRegWxpayIsNull() {
            addCriterion("reg_wxpay is null");
            return (Criteria) this;
        }

        public Criteria andRegWxpayIsNotNull() {
            addCriterion("reg_wxpay is not null");
            return (Criteria) this;
        }

        public Criteria andRegWxpayEqualTo(Integer value) {
            addCriterion("reg_wxpay =", value, "regWxpay");
            return (Criteria) this;
        }

        public Criteria andRegWxpayNotEqualTo(Integer value) {
            addCriterion("reg_wxpay <>", value, "regWxpay");
            return (Criteria) this;
        }

        public Criteria andRegWxpayGreaterThan(Integer value) {
            addCriterion("reg_wxpay >", value, "regWxpay");
            return (Criteria) this;
        }

        public Criteria andRegWxpayGreaterThanOrEqualTo(Integer value) {
            addCriterion("reg_wxpay >=", value, "regWxpay");
            return (Criteria) this;
        }

        public Criteria andRegWxpayLessThan(Integer value) {
            addCriterion("reg_wxpay <", value, "regWxpay");
            return (Criteria) this;
        }

        public Criteria andRegWxpayLessThanOrEqualTo(Integer value) {
            addCriterion("reg_wxpay <=", value, "regWxpay");
            return (Criteria) this;
        }

        public Criteria andRegWxpayIn(List<Integer> values) {
            addCriterion("reg_wxpay in", values, "regWxpay");
            return (Criteria) this;
        }

        public Criteria andRegWxpayNotIn(List<Integer> values) {
            addCriterion("reg_wxpay not in", values, "regWxpay");
            return (Criteria) this;
        }

        public Criteria andRegWxpayBetween(Integer value1, Integer value2) {
            addCriterion("reg_wxpay between", value1, value2, "regWxpay");
            return (Criteria) this;
        }

        public Criteria andRegWxpayNotBetween(Integer value1, Integer value2) {
            addCriterion("reg_wxpay not between", value1, value2, "regWxpay");
            return (Criteria) this;
        }

        public Criteria andHomeLogoIsNull() {
            addCriterion("home_logo is null");
            return (Criteria) this;
        }

        public Criteria andHomeLogoIsNotNull() {
            addCriterion("home_logo is not null");
            return (Criteria) this;
        }

        public Criteria andHomeLogoEqualTo(String value) {
            addCriterion("home_logo =", value, "homeLogo");
            return (Criteria) this;
        }

        public Criteria andHomeLogoNotEqualTo(String value) {
            addCriterion("home_logo <>", value, "homeLogo");
            return (Criteria) this;
        }

        public Criteria andHomeLogoGreaterThan(String value) {
            addCriterion("home_logo >", value, "homeLogo");
            return (Criteria) this;
        }

        public Criteria andHomeLogoGreaterThanOrEqualTo(String value) {
            addCriterion("home_logo >=", value, "homeLogo");
            return (Criteria) this;
        }

        public Criteria andHomeLogoLessThan(String value) {
            addCriterion("home_logo <", value, "homeLogo");
            return (Criteria) this;
        }

        public Criteria andHomeLogoLessThanOrEqualTo(String value) {
            addCriterion("home_logo <=", value, "homeLogo");
            return (Criteria) this;
        }

        public Criteria andHomeLogoLike(String value) {
            addCriterion("home_logo like", value, "homeLogo");
            return (Criteria) this;
        }

        public Criteria andHomeLogoNotLike(String value) {
            addCriterion("home_logo not like", value, "homeLogo");
            return (Criteria) this;
        }

        public Criteria andHomeLogoIn(List<String> values) {
            addCriterion("home_logo in", values, "homeLogo");
            return (Criteria) this;
        }

        public Criteria andHomeLogoNotIn(List<String> values) {
            addCriterion("home_logo not in", values, "homeLogo");
            return (Criteria) this;
        }

        public Criteria andHomeLogoBetween(String value1, String value2) {
            addCriterion("home_logo between", value1, value2, "homeLogo");
            return (Criteria) this;
        }

        public Criteria andHomeLogoNotBetween(String value1, String value2) {
            addCriterion("home_logo not between", value1, value2, "homeLogo");
            return (Criteria) this;
        }

        public Criteria andHomeQrcodeIsNull() {
            addCriterion("home_qrcode is null");
            return (Criteria) this;
        }

        public Criteria andHomeQrcodeIsNotNull() {
            addCriterion("home_qrcode is not null");
            return (Criteria) this;
        }

        public Criteria andHomeQrcodeEqualTo(String value) {
            addCriterion("home_qrcode =", value, "homeQrcode");
            return (Criteria) this;
        }

        public Criteria andHomeQrcodeNotEqualTo(String value) {
            addCriterion("home_qrcode <>", value, "homeQrcode");
            return (Criteria) this;
        }

        public Criteria andHomeQrcodeGreaterThan(String value) {
            addCriterion("home_qrcode >", value, "homeQrcode");
            return (Criteria) this;
        }

        public Criteria andHomeQrcodeGreaterThanOrEqualTo(String value) {
            addCriterion("home_qrcode >=", value, "homeQrcode");
            return (Criteria) this;
        }

        public Criteria andHomeQrcodeLessThan(String value) {
            addCriterion("home_qrcode <", value, "homeQrcode");
            return (Criteria) this;
        }

        public Criteria andHomeQrcodeLessThanOrEqualTo(String value) {
            addCriterion("home_qrcode <=", value, "homeQrcode");
            return (Criteria) this;
        }

        public Criteria andHomeQrcodeLike(String value) {
            addCriterion("home_qrcode like", value, "homeQrcode");
            return (Criteria) this;
        }

        public Criteria andHomeQrcodeNotLike(String value) {
            addCriterion("home_qrcode not like", value, "homeQrcode");
            return (Criteria) this;
        }

        public Criteria andHomeQrcodeIn(List<String> values) {
            addCriterion("home_qrcode in", values, "homeQrcode");
            return (Criteria) this;
        }

        public Criteria andHomeQrcodeNotIn(List<String> values) {
            addCriterion("home_qrcode not in", values, "homeQrcode");
            return (Criteria) this;
        }

        public Criteria andHomeQrcodeBetween(String value1, String value2) {
            addCriterion("home_qrcode between", value1, value2, "homeQrcode");
            return (Criteria) this;
        }

        public Criteria andHomeQrcodeNotBetween(String value1, String value2) {
            addCriterion("home_qrcode not between", value1, value2, "homeQrcode");
            return (Criteria) this;
        }

        public Criteria andAutoSettIsNull() {
            addCriterion("auto_sett is null");
            return (Criteria) this;
        }

        public Criteria andAutoSettIsNotNull() {
            addCriterion("auto_sett is not null");
            return (Criteria) this;
        }

        public Criteria andAutoSettEqualTo(Integer value) {
            addCriterion("auto_sett =", value, "autoSett");
            return (Criteria) this;
        }

        public Criteria andAutoSettNotEqualTo(Integer value) {
            addCriterion("auto_sett <>", value, "autoSett");
            return (Criteria) this;
        }

        public Criteria andAutoSettGreaterThan(Integer value) {
            addCriterion("auto_sett >", value, "autoSett");
            return (Criteria) this;
        }

        public Criteria andAutoSettGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_sett >=", value, "autoSett");
            return (Criteria) this;
        }

        public Criteria andAutoSettLessThan(Integer value) {
            addCriterion("auto_sett <", value, "autoSett");
            return (Criteria) this;
        }

        public Criteria andAutoSettLessThanOrEqualTo(Integer value) {
            addCriterion("auto_sett <=", value, "autoSett");
            return (Criteria) this;
        }

        public Criteria andAutoSettIn(List<Integer> values) {
            addCriterion("auto_sett in", values, "autoSett");
            return (Criteria) this;
        }

        public Criteria andAutoSettNotIn(List<Integer> values) {
            addCriterion("auto_sett not in", values, "autoSett");
            return (Criteria) this;
        }

        public Criteria andAutoSettBetween(Integer value1, Integer value2) {
            addCriterion("auto_sett between", value1, value2, "autoSett");
            return (Criteria) this;
        }

        public Criteria andAutoSettNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_sett not between", value1, value2, "autoSett");
            return (Criteria) this;
        }

        public Criteria andAutoSettlePayIsNull() {
            addCriterion("auto_settle_pay is null");
            return (Criteria) this;
        }

        public Criteria andAutoSettlePayIsNotNull() {
            addCriterion("auto_settle_pay is not null");
            return (Criteria) this;
        }

        public Criteria andAutoSettlePayEqualTo(Integer value) {
            addCriterion("auto_settle_pay =", value, "autoSettlePay");
            return (Criteria) this;
        }

        public Criteria andAutoSettlePayNotEqualTo(Integer value) {
            addCriterion("auto_settle_pay <>", value, "autoSettlePay");
            return (Criteria) this;
        }

        public Criteria andAutoSettlePayGreaterThan(Integer value) {
            addCriterion("auto_settle_pay >", value, "autoSettlePay");
            return (Criteria) this;
        }

        public Criteria andAutoSettlePayGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_settle_pay >=", value, "autoSettlePay");
            return (Criteria) this;
        }

        public Criteria andAutoSettlePayLessThan(Integer value) {
            addCriterion("auto_settle_pay <", value, "autoSettlePay");
            return (Criteria) this;
        }

        public Criteria andAutoSettlePayLessThanOrEqualTo(Integer value) {
            addCriterion("auto_settle_pay <=", value, "autoSettlePay");
            return (Criteria) this;
        }

        public Criteria andAutoSettlePayIn(List<Integer> values) {
            addCriterion("auto_settle_pay in", values, "autoSettlePay");
            return (Criteria) this;
        }

        public Criteria andAutoSettlePayNotIn(List<Integer> values) {
            addCriterion("auto_settle_pay not in", values, "autoSettlePay");
            return (Criteria) this;
        }

        public Criteria andAutoSettlePayBetween(Integer value1, Integer value2) {
            addCriterion("auto_settle_pay between", value1, value2, "autoSettlePay");
            return (Criteria) this;
        }

        public Criteria andAutoSettlePayNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_settle_pay not between", value1, value2, "autoSettlePay");
            return (Criteria) this;
        }

        public Criteria andDisableShopPayIsNull() {
            addCriterion("disable_shop_pay is null");
            return (Criteria) this;
        }

        public Criteria andDisableShopPayIsNotNull() {
            addCriterion("disable_shop_pay is not null");
            return (Criteria) this;
        }

        public Criteria andDisableShopPayEqualTo(String value) {
            addCriterion("disable_shop_pay =", value, "disableShopPay");
            return (Criteria) this;
        }

        public Criteria andDisableShopPayNotEqualTo(String value) {
            addCriterion("disable_shop_pay <>", value, "disableShopPay");
            return (Criteria) this;
        }

        public Criteria andDisableShopPayGreaterThan(String value) {
            addCriterion("disable_shop_pay >", value, "disableShopPay");
            return (Criteria) this;
        }

        public Criteria andDisableShopPayGreaterThanOrEqualTo(String value) {
            addCriterion("disable_shop_pay >=", value, "disableShopPay");
            return (Criteria) this;
        }

        public Criteria andDisableShopPayLessThan(String value) {
            addCriterion("disable_shop_pay <", value, "disableShopPay");
            return (Criteria) this;
        }

        public Criteria andDisableShopPayLessThanOrEqualTo(String value) {
            addCriterion("disable_shop_pay <=", value, "disableShopPay");
            return (Criteria) this;
        }

        public Criteria andDisableShopPayLike(String value) {
            addCriterion("disable_shop_pay like", value, "disableShopPay");
            return (Criteria) this;
        }

        public Criteria andDisableShopPayNotLike(String value) {
            addCriterion("disable_shop_pay not like", value, "disableShopPay");
            return (Criteria) this;
        }

        public Criteria andDisableShopPayIn(List<String> values) {
            addCriterion("disable_shop_pay in", values, "disableShopPay");
            return (Criteria) this;
        }

        public Criteria andDisableShopPayNotIn(List<String> values) {
            addCriterion("disable_shop_pay not in", values, "disableShopPay");
            return (Criteria) this;
        }

        public Criteria andDisableShopPayBetween(String value1, String value2) {
            addCriterion("disable_shop_pay between", value1, value2, "disableShopPay");
            return (Criteria) this;
        }

        public Criteria andDisableShopPayNotBetween(String value1, String value2) {
            addCriterion("disable_shop_pay not between", value1, value2, "disableShopPay");
            return (Criteria) this;
        }

        public Criteria andExtenStatusIsNull() {
            addCriterion("exten_status is null");
            return (Criteria) this;
        }

        public Criteria andExtenStatusIsNotNull() {
            addCriterion("exten_status is not null");
            return (Criteria) this;
        }

        public Criteria andExtenStatusEqualTo(Integer value) {
            addCriterion("exten_status =", value, "extenStatus");
            return (Criteria) this;
        }

        public Criteria andExtenStatusNotEqualTo(Integer value) {
            addCriterion("exten_status <>", value, "extenStatus");
            return (Criteria) this;
        }

        public Criteria andExtenStatusGreaterThan(Integer value) {
            addCriterion("exten_status >", value, "extenStatus");
            return (Criteria) this;
        }

        public Criteria andExtenStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("exten_status >=", value, "extenStatus");
            return (Criteria) this;
        }

        public Criteria andExtenStatusLessThan(Integer value) {
            addCriterion("exten_status <", value, "extenStatus");
            return (Criteria) this;
        }

        public Criteria andExtenStatusLessThanOrEqualTo(Integer value) {
            addCriterion("exten_status <=", value, "extenStatus");
            return (Criteria) this;
        }

        public Criteria andExtenStatusIn(List<Integer> values) {
            addCriterion("exten_status in", values, "extenStatus");
            return (Criteria) this;
        }

        public Criteria andExtenStatusNotIn(List<Integer> values) {
            addCriterion("exten_status not in", values, "extenStatus");
            return (Criteria) this;
        }

        public Criteria andExtenStatusBetween(Integer value1, Integer value2) {
            addCriterion("exten_status between", value1, value2, "extenStatus");
            return (Criteria) this;
        }

        public Criteria andExtenStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("exten_status not between", value1, value2, "extenStatus");
            return (Criteria) this;
        }

        public Criteria andExtenMinMoneyIsNull() {
            addCriterion("exten_min_money is null");
            return (Criteria) this;
        }

        public Criteria andExtenMinMoneyIsNotNull() {
            addCriterion("exten_min_money is not null");
            return (Criteria) this;
        }

        public Criteria andExtenMinMoneyEqualTo(BigDecimal value) {
            addCriterion("exten_min_money =", value, "extenMinMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMinMoneyNotEqualTo(BigDecimal value) {
            addCriterion("exten_min_money <>", value, "extenMinMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMinMoneyGreaterThan(BigDecimal value) {
            addCriterion("exten_min_money >", value, "extenMinMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMinMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("exten_min_money >=", value, "extenMinMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMinMoneyLessThan(BigDecimal value) {
            addCriterion("exten_min_money <", value, "extenMinMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMinMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("exten_min_money <=", value, "extenMinMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMinMoneyIn(List<BigDecimal> values) {
            addCriterion("exten_min_money in", values, "extenMinMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMinMoneyNotIn(List<BigDecimal> values) {
            addCriterion("exten_min_money not in", values, "extenMinMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMinMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("exten_min_money between", value1, value2, "extenMinMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMinMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("exten_min_money not between", value1, value2, "extenMinMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMaxMoneyIsNull() {
            addCriterion("exten_max_money is null");
            return (Criteria) this;
        }

        public Criteria andExtenMaxMoneyIsNotNull() {
            addCriterion("exten_max_money is not null");
            return (Criteria) this;
        }

        public Criteria andExtenMaxMoneyEqualTo(BigDecimal value) {
            addCriterion("exten_max_money =", value, "extenMaxMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMaxMoneyNotEqualTo(BigDecimal value) {
            addCriterion("exten_max_money <>", value, "extenMaxMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMaxMoneyGreaterThan(BigDecimal value) {
            addCriterion("exten_max_money >", value, "extenMaxMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMaxMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("exten_max_money >=", value, "extenMaxMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMaxMoneyLessThan(BigDecimal value) {
            addCriterion("exten_max_money <", value, "extenMaxMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMaxMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("exten_max_money <=", value, "extenMaxMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMaxMoneyIn(List<BigDecimal> values) {
            addCriterion("exten_max_money in", values, "extenMaxMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMaxMoneyNotIn(List<BigDecimal> values) {
            addCriterion("exten_max_money not in", values, "extenMaxMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMaxMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("exten_max_money between", value1, value2, "extenMaxMoney");
            return (Criteria) this;
        }

        public Criteria andExtenMaxMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("exten_max_money not between", value1, value2, "extenMaxMoney");
            return (Criteria) this;
        }

        public Criteria andOrderFilterIsNull() {
            addCriterion("order_filter is null");
            return (Criteria) this;
        }

        public Criteria andOrderFilterIsNotNull() {
            addCriterion("order_filter is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFilterEqualTo(Integer value) {
            addCriterion("order_filter =", value, "orderFilter");
            return (Criteria) this;
        }

        public Criteria andOrderFilterNotEqualTo(Integer value) {
            addCriterion("order_filter <>", value, "orderFilter");
            return (Criteria) this;
        }

        public Criteria andOrderFilterGreaterThan(Integer value) {
            addCriterion("order_filter >", value, "orderFilter");
            return (Criteria) this;
        }

        public Criteria andOrderFilterGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_filter >=", value, "orderFilter");
            return (Criteria) this;
        }

        public Criteria andOrderFilterLessThan(Integer value) {
            addCriterion("order_filter <", value, "orderFilter");
            return (Criteria) this;
        }

        public Criteria andOrderFilterLessThanOrEqualTo(Integer value) {
            addCriterion("order_filter <=", value, "orderFilter");
            return (Criteria) this;
        }

        public Criteria andOrderFilterIn(List<Integer> values) {
            addCriterion("order_filter in", values, "orderFilter");
            return (Criteria) this;
        }

        public Criteria andOrderFilterNotIn(List<Integer> values) {
            addCriterion("order_filter not in", values, "orderFilter");
            return (Criteria) this;
        }

        public Criteria andOrderFilterBetween(Integer value1, Integer value2) {
            addCriterion("order_filter between", value1, value2, "orderFilter");
            return (Criteria) this;
        }

        public Criteria andOrderFilterNotBetween(Integer value1, Integer value2) {
            addCriterion("order_filter not between", value1, value2, "orderFilter");
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