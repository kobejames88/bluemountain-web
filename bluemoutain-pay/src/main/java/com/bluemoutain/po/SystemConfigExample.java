package com.bluemoutain.po;

import java.util.ArrayList;
import java.util.List;

public class SystemConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemConfigExample() {
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

        public Criteria andSitenameIsNull() {
            addCriterion("sitename is null");
            return (Criteria) this;
        }

        public Criteria andSitenameIsNotNull() {
            addCriterion("sitename is not null");
            return (Criteria) this;
        }

        public Criteria andSitenameEqualTo(String value) {
            addCriterion("sitename =", value, "sitename");
            return (Criteria) this;
        }

        public Criteria andSitenameNotEqualTo(String value) {
            addCriterion("sitename <>", value, "sitename");
            return (Criteria) this;
        }

        public Criteria andSitenameGreaterThan(String value) {
            addCriterion("sitename >", value, "sitename");
            return (Criteria) this;
        }

        public Criteria andSitenameGreaterThanOrEqualTo(String value) {
            addCriterion("sitename >=", value, "sitename");
            return (Criteria) this;
        }

        public Criteria andSitenameLessThan(String value) {
            addCriterion("sitename <", value, "sitename");
            return (Criteria) this;
        }

        public Criteria andSitenameLessThanOrEqualTo(String value) {
            addCriterion("sitename <=", value, "sitename");
            return (Criteria) this;
        }

        public Criteria andSitenameLike(String value) {
            addCriterion("sitename like", value, "sitename");
            return (Criteria) this;
        }

        public Criteria andSitenameNotLike(String value) {
            addCriterion("sitename not like", value, "sitename");
            return (Criteria) this;
        }

        public Criteria andSitenameIn(List<String> values) {
            addCriterion("sitename in", values, "sitename");
            return (Criteria) this;
        }

        public Criteria andSitenameNotIn(List<String> values) {
            addCriterion("sitename not in", values, "sitename");
            return (Criteria) this;
        }

        public Criteria andSitenameBetween(String value1, String value2) {
            addCriterion("sitename between", value1, value2, "sitename");
            return (Criteria) this;
        }

        public Criteria andSitenameNotBetween(String value1, String value2) {
            addCriterion("sitename not between", value1, value2, "sitename");
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

        public Criteria andYmIsNull() {
            addCriterion("ym is null");
            return (Criteria) this;
        }

        public Criteria andYmIsNotNull() {
            addCriterion("ym is not null");
            return (Criteria) this;
        }

        public Criteria andYmEqualTo(String value) {
            addCriterion("ym =", value, "ym");
            return (Criteria) this;
        }

        public Criteria andYmNotEqualTo(String value) {
            addCriterion("ym <>", value, "ym");
            return (Criteria) this;
        }

        public Criteria andYmGreaterThan(String value) {
            addCriterion("ym >", value, "ym");
            return (Criteria) this;
        }

        public Criteria andYmGreaterThanOrEqualTo(String value) {
            addCriterion("ym >=", value, "ym");
            return (Criteria) this;
        }

        public Criteria andYmLessThan(String value) {
            addCriterion("ym <", value, "ym");
            return (Criteria) this;
        }

        public Criteria andYmLessThanOrEqualTo(String value) {
            addCriterion("ym <=", value, "ym");
            return (Criteria) this;
        }

        public Criteria andYmLike(String value) {
            addCriterion("ym like", value, "ym");
            return (Criteria) this;
        }

        public Criteria andYmNotLike(String value) {
            addCriterion("ym not like", value, "ym");
            return (Criteria) this;
        }

        public Criteria andYmIn(List<String> values) {
            addCriterion("ym in", values, "ym");
            return (Criteria) this;
        }

        public Criteria andYmNotIn(List<String> values) {
            addCriterion("ym not in", values, "ym");
            return (Criteria) this;
        }

        public Criteria andYmBetween(String value1, String value2) {
            addCriterion("ym between", value1, value2, "ym");
            return (Criteria) this;
        }

        public Criteria andYmNotBetween(String value1, String value2) {
            addCriterion("ym not between", value1, value2, "ym");
            return (Criteria) this;
        }

        public Criteria andGgIsNull() {
            addCriterion("gg is null");
            return (Criteria) this;
        }

        public Criteria andGgIsNotNull() {
            addCriterion("gg is not null");
            return (Criteria) this;
        }

        public Criteria andGgEqualTo(String value) {
            addCriterion("gg =", value, "gg");
            return (Criteria) this;
        }

        public Criteria andGgNotEqualTo(String value) {
            addCriterion("gg <>", value, "gg");
            return (Criteria) this;
        }

        public Criteria andGgGreaterThan(String value) {
            addCriterion("gg >", value, "gg");
            return (Criteria) this;
        }

        public Criteria andGgGreaterThanOrEqualTo(String value) {
            addCriterion("gg >=", value, "gg");
            return (Criteria) this;
        }

        public Criteria andGgLessThan(String value) {
            addCriterion("gg <", value, "gg");
            return (Criteria) this;
        }

        public Criteria andGgLessThanOrEqualTo(String value) {
            addCriterion("gg <=", value, "gg");
            return (Criteria) this;
        }

        public Criteria andGgLike(String value) {
            addCriterion("gg like", value, "gg");
            return (Criteria) this;
        }

        public Criteria andGgNotLike(String value) {
            addCriterion("gg not like", value, "gg");
            return (Criteria) this;
        }

        public Criteria andGgIn(List<String> values) {
            addCriterion("gg in", values, "gg");
            return (Criteria) this;
        }

        public Criteria andGgNotIn(List<String> values) {
            addCriterion("gg not in", values, "gg");
            return (Criteria) this;
        }

        public Criteria andGgBetween(String value1, String value2) {
            addCriterion("gg between", value1, value2, "gg");
            return (Criteria) this;
        }

        public Criteria andGgNotBetween(String value1, String value2) {
            addCriterion("gg not between", value1, value2, "gg");
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