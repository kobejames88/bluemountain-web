package com.bluemoutain.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemOrderExample() {
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

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdIsNull() {
            addCriterion("out_order_id is null");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdIsNotNull() {
            addCriterion("out_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdEqualTo(String value) {
            addCriterion("out_order_id =", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdNotEqualTo(String value) {
            addCriterion("out_order_id <>", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdGreaterThan(String value) {
            addCriterion("out_order_id >", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("out_order_id >=", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdLessThan(String value) {
            addCriterion("out_order_id <", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdLessThanOrEqualTo(String value) {
            addCriterion("out_order_id <=", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdLike(String value) {
            addCriterion("out_order_id like", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdNotLike(String value) {
            addCriterion("out_order_id not like", value, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdIn(List<String> values) {
            addCriterion("out_order_id in", values, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdNotIn(List<String> values) {
            addCriterion("out_order_id not in", values, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdBetween(String value1, String value2) {
            addCriterion("out_order_id between", value1, value2, "outOrderId");
            return (Criteria) this;
        }

        public Criteria andOutOrderIdNotBetween(String value1, String value2) {
            addCriterion("out_order_id not between", value1, value2, "outOrderId");
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

        public Criteria andPaidTimeIsNull() {
            addCriterion("paid_time is null");
            return (Criteria) this;
        }

        public Criteria andPaidTimeIsNotNull() {
            addCriterion("paid_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaidTimeEqualTo(Date value) {
            addCriterion("paid_time =", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeNotEqualTo(Date value) {
            addCriterion("paid_time <>", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeGreaterThan(Date value) {
            addCriterion("paid_time >", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("paid_time >=", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeLessThan(Date value) {
            addCriterion("paid_time <", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeLessThanOrEqualTo(Date value) {
            addCriterion("paid_time <=", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeIn(List<Date> values) {
            addCriterion("paid_time in", values, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeNotIn(List<Date> values) {
            addCriterion("paid_time not in", values, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeBetween(Date value1, Date value2) {
            addCriterion("paid_time between", value1, value2, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeNotBetween(Date value1, Date value2) {
            addCriterion("paid_time not between", value1, value2, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidIsNull() {
            addCriterion("paid is null");
            return (Criteria) this;
        }

        public Criteria andPaidIsNotNull() {
            addCriterion("paid is not null");
            return (Criteria) this;
        }

        public Criteria andPaidEqualTo(BigDecimal value) {
            addCriterion("paid =", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidNotEqualTo(BigDecimal value) {
            addCriterion("paid <>", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidGreaterThan(BigDecimal value) {
            addCriterion("paid >", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("paid >=", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidLessThan(BigDecimal value) {
            addCriterion("paid <", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("paid <=", value, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidIn(List<BigDecimal> values) {
            addCriterion("paid in", values, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidNotIn(List<BigDecimal> values) {
            addCriterion("paid not in", values, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paid between", value1, value2, "paid");
            return (Criteria) this;
        }

        public Criteria andPaidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paid not between", value1, value2, "paid");
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

        public Criteria andContextIsNull() {
            addCriterion("context is null");
            return (Criteria) this;
        }

        public Criteria andContextIsNotNull() {
            addCriterion("context is not null");
            return (Criteria) this;
        }

        public Criteria andContextEqualTo(String value) {
            addCriterion("context =", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotEqualTo(String value) {
            addCriterion("context <>", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThan(String value) {
            addCriterion("context >", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThanOrEqualTo(String value) {
            addCriterion("context >=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThan(String value) {
            addCriterion("context <", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThanOrEqualTo(String value) {
            addCriterion("context <=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLike(String value) {
            addCriterion("context like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotLike(String value) {
            addCriterion("context not like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextIn(List<String> values) {
            addCriterion("context in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotIn(List<String> values) {
            addCriterion("context not in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextBetween(String value1, String value2) {
            addCriterion("context between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotBetween(String value1, String value2) {
            addCriterion("context not between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNull() {
            addCriterion("trade_status is null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNotNull() {
            addCriterion("trade_status is not null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusEqualTo(String value) {
            addCriterion("trade_status =", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotEqualTo(String value) {
            addCriterion("trade_status <>", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThan(String value) {
            addCriterion("trade_status >", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("trade_status >=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThan(String value) {
            addCriterion("trade_status <", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThanOrEqualTo(String value) {
            addCriterion("trade_status <=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLike(String value) {
            addCriterion("trade_status like", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotLike(String value) {
            addCriterion("trade_status not like", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIn(List<String> values) {
            addCriterion("trade_status in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotIn(List<String> values) {
            addCriterion("trade_status not in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusBetween(String value1, String value2) {
            addCriterion("trade_status between", value1, value2, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotBetween(String value1, String value2) {
            addCriterion("trade_status not between", value1, value2, "tradeStatus");
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

        public Criteria andNotifyUrlIsNull() {
            addCriterion("notify_url is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNotNull() {
            addCriterion("notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlEqualTo(String value) {
            addCriterion("notify_url =", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotEqualTo(String value) {
            addCriterion("notify_url <>", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThan(String value) {
            addCriterion("notify_url >", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("notify_url >=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThan(String value) {
            addCriterion("notify_url <", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("notify_url <=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLike(String value) {
            addCriterion("notify_url like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotLike(String value) {
            addCriterion("notify_url not like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIn(List<String> values) {
            addCriterion("notify_url in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotIn(List<String> values) {
            addCriterion("notify_url not in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlBetween(String value1, String value2) {
            addCriterion("notify_url between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("notify_url not between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNull() {
            addCriterion("return_url is null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNotNull() {
            addCriterion("return_url is not null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlEqualTo(String value) {
            addCriterion("return_url =", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotEqualTo(String value) {
            addCriterion("return_url <>", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThan(String value) {
            addCriterion("return_url >", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThanOrEqualTo(String value) {
            addCriterion("return_url >=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThan(String value) {
            addCriterion("return_url <", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThanOrEqualTo(String value) {
            addCriterion("return_url <=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLike(String value) {
            addCriterion("return_url like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotLike(String value) {
            addCriterion("return_url not like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIn(List<String> values) {
            addCriterion("return_url in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotIn(List<String> values) {
            addCriterion("return_url not in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlBetween(String value1, String value2) {
            addCriterion("return_url between", value1, value2, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotBetween(String value1, String value2) {
            addCriterion("return_url not between", value1, value2, "returnUrl");
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

        public Criteria andPrePayTypeIsNull() {
            addCriterion("pre_pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPrePayTypeIsNotNull() {
            addCriterion("pre_pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPrePayTypeEqualTo(Integer value) {
            addCriterion("pre_pay_type =", value, "prePayType");
            return (Criteria) this;
        }

        public Criteria andPrePayTypeNotEqualTo(Integer value) {
            addCriterion("pre_pay_type <>", value, "prePayType");
            return (Criteria) this;
        }

        public Criteria andPrePayTypeGreaterThan(Integer value) {
            addCriterion("pre_pay_type >", value, "prePayType");
            return (Criteria) this;
        }

        public Criteria andPrePayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_pay_type >=", value, "prePayType");
            return (Criteria) this;
        }

        public Criteria andPrePayTypeLessThan(Integer value) {
            addCriterion("pre_pay_type <", value, "prePayType");
            return (Criteria) this;
        }

        public Criteria andPrePayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pre_pay_type <=", value, "prePayType");
            return (Criteria) this;
        }

        public Criteria andPrePayTypeIn(List<Integer> values) {
            addCriterion("pre_pay_type in", values, "prePayType");
            return (Criteria) this;
        }

        public Criteria andPrePayTypeNotIn(List<Integer> values) {
            addCriterion("pre_pay_type not in", values, "prePayType");
            return (Criteria) this;
        }

        public Criteria andPrePayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pre_pay_type between", value1, value2, "prePayType");
            return (Criteria) this;
        }

        public Criteria andPrePayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_pay_type not between", value1, value2, "prePayType");
            return (Criteria) this;
        }

        public Criteria andPreAccountIsNull() {
            addCriterion("pre_account is null");
            return (Criteria) this;
        }

        public Criteria andPreAccountIsNotNull() {
            addCriterion("pre_account is not null");
            return (Criteria) this;
        }

        public Criteria andPreAccountEqualTo(String value) {
            addCriterion("pre_account =", value, "preAccount");
            return (Criteria) this;
        }

        public Criteria andPreAccountNotEqualTo(String value) {
            addCriterion("pre_account <>", value, "preAccount");
            return (Criteria) this;
        }

        public Criteria andPreAccountGreaterThan(String value) {
            addCriterion("pre_account >", value, "preAccount");
            return (Criteria) this;
        }

        public Criteria andPreAccountGreaterThanOrEqualTo(String value) {
            addCriterion("pre_account >=", value, "preAccount");
            return (Criteria) this;
        }

        public Criteria andPreAccountLessThan(String value) {
            addCriterion("pre_account <", value, "preAccount");
            return (Criteria) this;
        }

        public Criteria andPreAccountLessThanOrEqualTo(String value) {
            addCriterion("pre_account <=", value, "preAccount");
            return (Criteria) this;
        }

        public Criteria andPreAccountLike(String value) {
            addCriterion("pre_account like", value, "preAccount");
            return (Criteria) this;
        }

        public Criteria andPreAccountNotLike(String value) {
            addCriterion("pre_account not like", value, "preAccount");
            return (Criteria) this;
        }

        public Criteria andPreAccountIn(List<String> values) {
            addCriterion("pre_account in", values, "preAccount");
            return (Criteria) this;
        }

        public Criteria andPreAccountNotIn(List<String> values) {
            addCriterion("pre_account not in", values, "preAccount");
            return (Criteria) this;
        }

        public Criteria andPreAccountBetween(String value1, String value2) {
            addCriterion("pre_account between", value1, value2, "preAccount");
            return (Criteria) this;
        }

        public Criteria andPreAccountNotBetween(String value1, String value2) {
            addCriterion("pre_account not between", value1, value2, "preAccount");
            return (Criteria) this;
        }

        public Criteria andPreZsNameIsNull() {
            addCriterion("pre_zs_name is null");
            return (Criteria) this;
        }

        public Criteria andPreZsNameIsNotNull() {
            addCriterion("pre_zs_name is not null");
            return (Criteria) this;
        }

        public Criteria andPreZsNameEqualTo(String value) {
            addCriterion("pre_zs_name =", value, "preZsName");
            return (Criteria) this;
        }

        public Criteria andPreZsNameNotEqualTo(String value) {
            addCriterion("pre_zs_name <>", value, "preZsName");
            return (Criteria) this;
        }

        public Criteria andPreZsNameGreaterThan(String value) {
            addCriterion("pre_zs_name >", value, "preZsName");
            return (Criteria) this;
        }

        public Criteria andPreZsNameGreaterThanOrEqualTo(String value) {
            addCriterion("pre_zs_name >=", value, "preZsName");
            return (Criteria) this;
        }

        public Criteria andPreZsNameLessThan(String value) {
            addCriterion("pre_zs_name <", value, "preZsName");
            return (Criteria) this;
        }

        public Criteria andPreZsNameLessThanOrEqualTo(String value) {
            addCriterion("pre_zs_name <=", value, "preZsName");
            return (Criteria) this;
        }

        public Criteria andPreZsNameLike(String value) {
            addCriterion("pre_zs_name like", value, "preZsName");
            return (Criteria) this;
        }

        public Criteria andPreZsNameNotLike(String value) {
            addCriterion("pre_zs_name not like", value, "preZsName");
            return (Criteria) this;
        }

        public Criteria andPreZsNameIn(List<String> values) {
            addCriterion("pre_zs_name in", values, "preZsName");
            return (Criteria) this;
        }

        public Criteria andPreZsNameNotIn(List<String> values) {
            addCriterion("pre_zs_name not in", values, "preZsName");
            return (Criteria) this;
        }

        public Criteria andPreZsNameBetween(String value1, String value2) {
            addCriterion("pre_zs_name between", value1, value2, "preZsName");
            return (Criteria) this;
        }

        public Criteria andPreZsNameNotBetween(String value1, String value2) {
            addCriterion("pre_zs_name not between", value1, value2, "preZsName");
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

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andIpAddrIsNull() {
            addCriterion("ip_addr is null");
            return (Criteria) this;
        }

        public Criteria andIpAddrIsNotNull() {
            addCriterion("ip_addr is not null");
            return (Criteria) this;
        }

        public Criteria andIpAddrEqualTo(String value) {
            addCriterion("ip_addr =", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotEqualTo(String value) {
            addCriterion("ip_addr <>", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrGreaterThan(String value) {
            addCriterion("ip_addr >", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrGreaterThanOrEqualTo(String value) {
            addCriterion("ip_addr >=", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrLessThan(String value) {
            addCriterion("ip_addr <", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrLessThanOrEqualTo(String value) {
            addCriterion("ip_addr <=", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrLike(String value) {
            addCriterion("ip_addr like", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotLike(String value) {
            addCriterion("ip_addr not like", value, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrIn(List<String> values) {
            addCriterion("ip_addr in", values, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotIn(List<String> values) {
            addCriterion("ip_addr not in", values, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrBetween(String value1, String value2) {
            addCriterion("ip_addr between", value1, value2, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andIpAddrNotBetween(String value1, String value2) {
            addCriterion("ip_addr not between", value1, value2, "ipAddr");
            return (Criteria) this;
        }

        public Criteria andChangeSettIsNull() {
            addCriterion("change_sett is null");
            return (Criteria) this;
        }

        public Criteria andChangeSettIsNotNull() {
            addCriterion("change_sett is not null");
            return (Criteria) this;
        }

        public Criteria andChangeSettEqualTo(BigDecimal value) {
            addCriterion("change_sett =", value, "changeSett");
            return (Criteria) this;
        }

        public Criteria andChangeSettNotEqualTo(BigDecimal value) {
            addCriterion("change_sett <>", value, "changeSett");
            return (Criteria) this;
        }

        public Criteria andChangeSettGreaterThan(BigDecimal value) {
            addCriterion("change_sett >", value, "changeSett");
            return (Criteria) this;
        }

        public Criteria andChangeSettGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("change_sett >=", value, "changeSett");
            return (Criteria) this;
        }

        public Criteria andChangeSettLessThan(BigDecimal value) {
            addCriterion("change_sett <", value, "changeSett");
            return (Criteria) this;
        }

        public Criteria andChangeSettLessThanOrEqualTo(BigDecimal value) {
            addCriterion("change_sett <=", value, "changeSett");
            return (Criteria) this;
        }

        public Criteria andChangeSettIn(List<BigDecimal> values) {
            addCriterion("change_sett in", values, "changeSett");
            return (Criteria) this;
        }

        public Criteria andChangeSettNotIn(List<BigDecimal> values) {
            addCriterion("change_sett not in", values, "changeSett");
            return (Criteria) this;
        }

        public Criteria andChangeSettBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("change_sett between", value1, value2, "changeSett");
            return (Criteria) this;
        }

        public Criteria andChangeSettNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("change_sett not between", value1, value2, "changeSett");
            return (Criteria) this;
        }

        public Criteria andIsNotifyIsNull() {
            addCriterion("is_notify is null");
            return (Criteria) this;
        }

        public Criteria andIsNotifyIsNotNull() {
            addCriterion("is_notify is not null");
            return (Criteria) this;
        }

        public Criteria andIsNotifyEqualTo(Integer value) {
            addCriterion("is_notify =", value, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyNotEqualTo(Integer value) {
            addCriterion("is_notify <>", value, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyGreaterThan(Integer value) {
            addCriterion("is_notify >", value, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_notify >=", value, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyLessThan(Integer value) {
            addCriterion("is_notify <", value, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyLessThanOrEqualTo(Integer value) {
            addCriterion("is_notify <=", value, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyIn(List<Integer> values) {
            addCriterion("is_notify in", values, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyNotIn(List<Integer> values) {
            addCriterion("is_notify not in", values, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyBetween(Integer value1, Integer value2) {
            addCriterion("is_notify between", value1, value2, "isNotify");
            return (Criteria) this;
        }

        public Criteria andIsNotifyNotBetween(Integer value1, Integer value2) {
            addCriterion("is_notify not between", value1, value2, "isNotify");
            return (Criteria) this;
        }

        public Criteria andChTypeIsNull() {
            addCriterion("ch_type is null");
            return (Criteria) this;
        }

        public Criteria andChTypeIsNotNull() {
            addCriterion("ch_type is not null");
            return (Criteria) this;
        }

        public Criteria andChTypeEqualTo(Integer value) {
            addCriterion("ch_type =", value, "chType");
            return (Criteria) this;
        }

        public Criteria andChTypeNotEqualTo(Integer value) {
            addCriterion("ch_type <>", value, "chType");
            return (Criteria) this;
        }

        public Criteria andChTypeGreaterThan(Integer value) {
            addCriterion("ch_type >", value, "chType");
            return (Criteria) this;
        }

        public Criteria andChTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ch_type >=", value, "chType");
            return (Criteria) this;
        }

        public Criteria andChTypeLessThan(Integer value) {
            addCriterion("ch_type <", value, "chType");
            return (Criteria) this;
        }

        public Criteria andChTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ch_type <=", value, "chType");
            return (Criteria) this;
        }

        public Criteria andChTypeIn(List<Integer> values) {
            addCriterion("ch_type in", values, "chType");
            return (Criteria) this;
        }

        public Criteria andChTypeNotIn(List<Integer> values) {
            addCriterion("ch_type not in", values, "chType");
            return (Criteria) this;
        }

        public Criteria andChTypeBetween(Integer value1, Integer value2) {
            addCriterion("ch_type between", value1, value2, "chType");
            return (Criteria) this;
        }

        public Criteria andChTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ch_type not between", value1, value2, "chType");
            return (Criteria) this;
        }

        public Criteria andChNumIsNull() {
            addCriterion("ch_num is null");
            return (Criteria) this;
        }

        public Criteria andChNumIsNotNull() {
            addCriterion("ch_num is not null");
            return (Criteria) this;
        }

        public Criteria andChNumEqualTo(Integer value) {
            addCriterion("ch_num =", value, "chNum");
            return (Criteria) this;
        }

        public Criteria andChNumNotEqualTo(Integer value) {
            addCriterion("ch_num <>", value, "chNum");
            return (Criteria) this;
        }

        public Criteria andChNumGreaterThan(Integer value) {
            addCriterion("ch_num >", value, "chNum");
            return (Criteria) this;
        }

        public Criteria andChNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ch_num >=", value, "chNum");
            return (Criteria) this;
        }

        public Criteria andChNumLessThan(Integer value) {
            addCriterion("ch_num <", value, "chNum");
            return (Criteria) this;
        }

        public Criteria andChNumLessThanOrEqualTo(Integer value) {
            addCriterion("ch_num <=", value, "chNum");
            return (Criteria) this;
        }

        public Criteria andChNumIn(List<Integer> values) {
            addCriterion("ch_num in", values, "chNum");
            return (Criteria) this;
        }

        public Criteria andChNumNotIn(List<Integer> values) {
            addCriterion("ch_num not in", values, "chNum");
            return (Criteria) this;
        }

        public Criteria andChNumBetween(Integer value1, Integer value2) {
            addCriterion("ch_num between", value1, value2, "chNum");
            return (Criteria) this;
        }

        public Criteria andChNumNotBetween(Integer value1, Integer value2) {
            addCriterion("ch_num not between", value1, value2, "chNum");
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

        public Criteria andExtenKeyIsNull() {
            addCriterion("exten_key is null");
            return (Criteria) this;
        }

        public Criteria andExtenKeyIsNotNull() {
            addCriterion("exten_key is not null");
            return (Criteria) this;
        }

        public Criteria andExtenKeyEqualTo(String value) {
            addCriterion("exten_key =", value, "extenKey");
            return (Criteria) this;
        }

        public Criteria andExtenKeyNotEqualTo(String value) {
            addCriterion("exten_key <>", value, "extenKey");
            return (Criteria) this;
        }

        public Criteria andExtenKeyGreaterThan(String value) {
            addCriterion("exten_key >", value, "extenKey");
            return (Criteria) this;
        }

        public Criteria andExtenKeyGreaterThanOrEqualTo(String value) {
            addCriterion("exten_key >=", value, "extenKey");
            return (Criteria) this;
        }

        public Criteria andExtenKeyLessThan(String value) {
            addCriterion("exten_key <", value, "extenKey");
            return (Criteria) this;
        }

        public Criteria andExtenKeyLessThanOrEqualTo(String value) {
            addCriterion("exten_key <=", value, "extenKey");
            return (Criteria) this;
        }

        public Criteria andExtenKeyLike(String value) {
            addCriterion("exten_key like", value, "extenKey");
            return (Criteria) this;
        }

        public Criteria andExtenKeyNotLike(String value) {
            addCriterion("exten_key not like", value, "extenKey");
            return (Criteria) this;
        }

        public Criteria andExtenKeyIn(List<String> values) {
            addCriterion("exten_key in", values, "extenKey");
            return (Criteria) this;
        }

        public Criteria andExtenKeyNotIn(List<String> values) {
            addCriterion("exten_key not in", values, "extenKey");
            return (Criteria) this;
        }

        public Criteria andExtenKeyBetween(String value1, String value2) {
            addCriterion("exten_key between", value1, value2, "extenKey");
            return (Criteria) this;
        }

        public Criteria andExtenKeyNotBetween(String value1, String value2) {
            addCriterion("exten_key not between", value1, value2, "extenKey");
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