package com.bluemoutain.po;

import java.util.ArrayList;
import java.util.List;

public class SystemPayConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemPayConfigExample() {
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

        public Criteria andEpayIdIsNull() {
            addCriterion("epay_id is null");
            return (Criteria) this;
        }

        public Criteria andEpayIdIsNotNull() {
            addCriterion("epay_id is not null");
            return (Criteria) this;
        }

        public Criteria andEpayIdEqualTo(String value) {
            addCriterion("epay_id =", value, "epayId");
            return (Criteria) this;
        }

        public Criteria andEpayIdNotEqualTo(String value) {
            addCriterion("epay_id <>", value, "epayId");
            return (Criteria) this;
        }

        public Criteria andEpayIdGreaterThan(String value) {
            addCriterion("epay_id >", value, "epayId");
            return (Criteria) this;
        }

        public Criteria andEpayIdGreaterThanOrEqualTo(String value) {
            addCriterion("epay_id >=", value, "epayId");
            return (Criteria) this;
        }

        public Criteria andEpayIdLessThan(String value) {
            addCriterion("epay_id <", value, "epayId");
            return (Criteria) this;
        }

        public Criteria andEpayIdLessThanOrEqualTo(String value) {
            addCriterion("epay_id <=", value, "epayId");
            return (Criteria) this;
        }

        public Criteria andEpayIdLike(String value) {
            addCriterion("epay_id like", value, "epayId");
            return (Criteria) this;
        }

        public Criteria andEpayIdNotLike(String value) {
            addCriterion("epay_id not like", value, "epayId");
            return (Criteria) this;
        }

        public Criteria andEpayIdIn(List<String> values) {
            addCriterion("epay_id in", values, "epayId");
            return (Criteria) this;
        }

        public Criteria andEpayIdNotIn(List<String> values) {
            addCriterion("epay_id not in", values, "epayId");
            return (Criteria) this;
        }

        public Criteria andEpayIdBetween(String value1, String value2) {
            addCriterion("epay_id between", value1, value2, "epayId");
            return (Criteria) this;
        }

        public Criteria andEpayIdNotBetween(String value1, String value2) {
            addCriterion("epay_id not between", value1, value2, "epayId");
            return (Criteria) this;
        }

        public Criteria andEpayKeyIsNull() {
            addCriterion("epay_key is null");
            return (Criteria) this;
        }

        public Criteria andEpayKeyIsNotNull() {
            addCriterion("epay_key is not null");
            return (Criteria) this;
        }

        public Criteria andEpayKeyEqualTo(String value) {
            addCriterion("epay_key =", value, "epayKey");
            return (Criteria) this;
        }

        public Criteria andEpayKeyNotEqualTo(String value) {
            addCriterion("epay_key <>", value, "epayKey");
            return (Criteria) this;
        }

        public Criteria andEpayKeyGreaterThan(String value) {
            addCriterion("epay_key >", value, "epayKey");
            return (Criteria) this;
        }

        public Criteria andEpayKeyGreaterThanOrEqualTo(String value) {
            addCriterion("epay_key >=", value, "epayKey");
            return (Criteria) this;
        }

        public Criteria andEpayKeyLessThan(String value) {
            addCriterion("epay_key <", value, "epayKey");
            return (Criteria) this;
        }

        public Criteria andEpayKeyLessThanOrEqualTo(String value) {
            addCriterion("epay_key <=", value, "epayKey");
            return (Criteria) this;
        }

        public Criteria andEpayKeyLike(String value) {
            addCriterion("epay_key like", value, "epayKey");
            return (Criteria) this;
        }

        public Criteria andEpayKeyNotLike(String value) {
            addCriterion("epay_key not like", value, "epayKey");
            return (Criteria) this;
        }

        public Criteria andEpayKeyIn(List<String> values) {
            addCriterion("epay_key in", values, "epayKey");
            return (Criteria) this;
        }

        public Criteria andEpayKeyNotIn(List<String> values) {
            addCriterion("epay_key not in", values, "epayKey");
            return (Criteria) this;
        }

        public Criteria andEpayKeyBetween(String value1, String value2) {
            addCriterion("epay_key between", value1, value2, "epayKey");
            return (Criteria) this;
        }

        public Criteria andEpayKeyNotBetween(String value1, String value2) {
            addCriterion("epay_key not between", value1, value2, "epayKey");
            return (Criteria) this;
        }

        public Criteria andRetDomainIsNull() {
            addCriterion("ret_domain is null");
            return (Criteria) this;
        }

        public Criteria andRetDomainIsNotNull() {
            addCriterion("ret_domain is not null");
            return (Criteria) this;
        }

        public Criteria andRetDomainEqualTo(String value) {
            addCriterion("ret_domain =", value, "retDomain");
            return (Criteria) this;
        }

        public Criteria andRetDomainNotEqualTo(String value) {
            addCriterion("ret_domain <>", value, "retDomain");
            return (Criteria) this;
        }

        public Criteria andRetDomainGreaterThan(String value) {
            addCriterion("ret_domain >", value, "retDomain");
            return (Criteria) this;
        }

        public Criteria andRetDomainGreaterThanOrEqualTo(String value) {
            addCriterion("ret_domain >=", value, "retDomain");
            return (Criteria) this;
        }

        public Criteria andRetDomainLessThan(String value) {
            addCriterion("ret_domain <", value, "retDomain");
            return (Criteria) this;
        }

        public Criteria andRetDomainLessThanOrEqualTo(String value) {
            addCriterion("ret_domain <=", value, "retDomain");
            return (Criteria) this;
        }

        public Criteria andRetDomainLike(String value) {
            addCriterion("ret_domain like", value, "retDomain");
            return (Criteria) this;
        }

        public Criteria andRetDomainNotLike(String value) {
            addCriterion("ret_domain not like", value, "retDomain");
            return (Criteria) this;
        }

        public Criteria andRetDomainIn(List<String> values) {
            addCriterion("ret_domain in", values, "retDomain");
            return (Criteria) this;
        }

        public Criteria andRetDomainNotIn(List<String> values) {
            addCriterion("ret_domain not in", values, "retDomain");
            return (Criteria) this;
        }

        public Criteria andRetDomainBetween(String value1, String value2) {
            addCriterion("ret_domain between", value1, value2, "retDomain");
            return (Criteria) this;
        }

        public Criteria andRetDomainNotBetween(String value1, String value2) {
            addCriterion("ret_domain not between", value1, value2, "retDomain");
            return (Criteria) this;
        }

        public Criteria andAlipayPartherIsNull() {
            addCriterion("alipay_parther is null");
            return (Criteria) this;
        }

        public Criteria andAlipayPartherIsNotNull() {
            addCriterion("alipay_parther is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayPartherEqualTo(String value) {
            addCriterion("alipay_parther =", value, "alipayParther");
            return (Criteria) this;
        }

        public Criteria andAlipayPartherNotEqualTo(String value) {
            addCriterion("alipay_parther <>", value, "alipayParther");
            return (Criteria) this;
        }

        public Criteria andAlipayPartherGreaterThan(String value) {
            addCriterion("alipay_parther >", value, "alipayParther");
            return (Criteria) this;
        }

        public Criteria andAlipayPartherGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_parther >=", value, "alipayParther");
            return (Criteria) this;
        }

        public Criteria andAlipayPartherLessThan(String value) {
            addCriterion("alipay_parther <", value, "alipayParther");
            return (Criteria) this;
        }

        public Criteria andAlipayPartherLessThanOrEqualTo(String value) {
            addCriterion("alipay_parther <=", value, "alipayParther");
            return (Criteria) this;
        }

        public Criteria andAlipayPartherLike(String value) {
            addCriterion("alipay_parther like", value, "alipayParther");
            return (Criteria) this;
        }

        public Criteria andAlipayPartherNotLike(String value) {
            addCriterion("alipay_parther not like", value, "alipayParther");
            return (Criteria) this;
        }

        public Criteria andAlipayPartherIn(List<String> values) {
            addCriterion("alipay_parther in", values, "alipayParther");
            return (Criteria) this;
        }

        public Criteria andAlipayPartherNotIn(List<String> values) {
            addCriterion("alipay_parther not in", values, "alipayParther");
            return (Criteria) this;
        }

        public Criteria andAlipayPartherBetween(String value1, String value2) {
            addCriterion("alipay_parther between", value1, value2, "alipayParther");
            return (Criteria) this;
        }

        public Criteria andAlipayPartherNotBetween(String value1, String value2) {
            addCriterion("alipay_parther not between", value1, value2, "alipayParther");
            return (Criteria) this;
        }

        public Criteria andAlipayOpenAppIdIsNull() {
            addCriterion("alipay_open_app_id is null");
            return (Criteria) this;
        }

        public Criteria andAlipayOpenAppIdIsNotNull() {
            addCriterion("alipay_open_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayOpenAppIdEqualTo(String value) {
            addCriterion("alipay_open_app_id =", value, "alipayOpenAppId");
            return (Criteria) this;
        }

        public Criteria andAlipayOpenAppIdNotEqualTo(String value) {
            addCriterion("alipay_open_app_id <>", value, "alipayOpenAppId");
            return (Criteria) this;
        }

        public Criteria andAlipayOpenAppIdGreaterThan(String value) {
            addCriterion("alipay_open_app_id >", value, "alipayOpenAppId");
            return (Criteria) this;
        }

        public Criteria andAlipayOpenAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("alipay_open_app_id >=", value, "alipayOpenAppId");
            return (Criteria) this;
        }

        public Criteria andAlipayOpenAppIdLessThan(String value) {
            addCriterion("alipay_open_app_id <", value, "alipayOpenAppId");
            return (Criteria) this;
        }

        public Criteria andAlipayOpenAppIdLessThanOrEqualTo(String value) {
            addCriterion("alipay_open_app_id <=", value, "alipayOpenAppId");
            return (Criteria) this;
        }

        public Criteria andAlipayOpenAppIdLike(String value) {
            addCriterion("alipay_open_app_id like", value, "alipayOpenAppId");
            return (Criteria) this;
        }

        public Criteria andAlipayOpenAppIdNotLike(String value) {
            addCriterion("alipay_open_app_id not like", value, "alipayOpenAppId");
            return (Criteria) this;
        }

        public Criteria andAlipayOpenAppIdIn(List<String> values) {
            addCriterion("alipay_open_app_id in", values, "alipayOpenAppId");
            return (Criteria) this;
        }

        public Criteria andAlipayOpenAppIdNotIn(List<String> values) {
            addCriterion("alipay_open_app_id not in", values, "alipayOpenAppId");
            return (Criteria) this;
        }

        public Criteria andAlipayOpenAppIdBetween(String value1, String value2) {
            addCriterion("alipay_open_app_id between", value1, value2, "alipayOpenAppId");
            return (Criteria) this;
        }

        public Criteria andAlipayOpenAppIdNotBetween(String value1, String value2) {
            addCriterion("alipay_open_app_id not between", value1, value2, "alipayOpenAppId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdIsNull() {
            addCriterion("wxpay_mch_id is null");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdIsNotNull() {
            addCriterion("wxpay_mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdEqualTo(String value) {
            addCriterion("wxpay_mch_id =", value, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdNotEqualTo(String value) {
            addCriterion("wxpay_mch_id <>", value, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdGreaterThan(String value) {
            addCriterion("wxpay_mch_id >", value, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("wxpay_mch_id >=", value, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdLessThan(String value) {
            addCriterion("wxpay_mch_id <", value, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdLessThanOrEqualTo(String value) {
            addCriterion("wxpay_mch_id <=", value, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdLike(String value) {
            addCriterion("wxpay_mch_id like", value, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdNotLike(String value) {
            addCriterion("wxpay_mch_id not like", value, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdIn(List<String> values) {
            addCriterion("wxpay_mch_id in", values, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdNotIn(List<String> values) {
            addCriterion("wxpay_mch_id not in", values, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdBetween(String value1, String value2) {
            addCriterion("wxpay_mch_id between", value1, value2, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayMchIdNotBetween(String value1, String value2) {
            addCriterion("wxpay_mch_id not between", value1, value2, "wxpayMchId");
            return (Criteria) this;
        }

        public Criteria andWxpayPaternerKeyIsNull() {
            addCriterion("wxpay_paterner_key is null");
            return (Criteria) this;
        }

        public Criteria andWxpayPaternerKeyIsNotNull() {
            addCriterion("wxpay_paterner_key is not null");
            return (Criteria) this;
        }

        public Criteria andWxpayPaternerKeyEqualTo(String value) {
            addCriterion("wxpay_paterner_key =", value, "wxpayPaternerKey");
            return (Criteria) this;
        }

        public Criteria andWxpayPaternerKeyNotEqualTo(String value) {
            addCriterion("wxpay_paterner_key <>", value, "wxpayPaternerKey");
            return (Criteria) this;
        }

        public Criteria andWxpayPaternerKeyGreaterThan(String value) {
            addCriterion("wxpay_paterner_key >", value, "wxpayPaternerKey");
            return (Criteria) this;
        }

        public Criteria andWxpayPaternerKeyGreaterThanOrEqualTo(String value) {
            addCriterion("wxpay_paterner_key >=", value, "wxpayPaternerKey");
            return (Criteria) this;
        }

        public Criteria andWxpayPaternerKeyLessThan(String value) {
            addCriterion("wxpay_paterner_key <", value, "wxpayPaternerKey");
            return (Criteria) this;
        }

        public Criteria andWxpayPaternerKeyLessThanOrEqualTo(String value) {
            addCriterion("wxpay_paterner_key <=", value, "wxpayPaternerKey");
            return (Criteria) this;
        }

        public Criteria andWxpayPaternerKeyLike(String value) {
            addCriterion("wxpay_paterner_key like", value, "wxpayPaternerKey");
            return (Criteria) this;
        }

        public Criteria andWxpayPaternerKeyNotLike(String value) {
            addCriterion("wxpay_paterner_key not like", value, "wxpayPaternerKey");
            return (Criteria) this;
        }

        public Criteria andWxpayPaternerKeyIn(List<String> values) {
            addCriterion("wxpay_paterner_key in", values, "wxpayPaternerKey");
            return (Criteria) this;
        }

        public Criteria andWxpayPaternerKeyNotIn(List<String> values) {
            addCriterion("wxpay_paterner_key not in", values, "wxpayPaternerKey");
            return (Criteria) this;
        }

        public Criteria andWxpayPaternerKeyBetween(String value1, String value2) {
            addCriterion("wxpay_paterner_key between", value1, value2, "wxpayPaternerKey");
            return (Criteria) this;
        }

        public Criteria andWxpayPaternerKeyNotBetween(String value1, String value2) {
            addCriterion("wxpay_paterner_key not between", value1, value2, "wxpayPaternerKey");
            return (Criteria) this;
        }

        public Criteria andWxpayAppIdIsNull() {
            addCriterion("wxpay_app_id is null");
            return (Criteria) this;
        }

        public Criteria andWxpayAppIdIsNotNull() {
            addCriterion("wxpay_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andWxpayAppIdEqualTo(String value) {
            addCriterion("wxpay_app_id =", value, "wxpayAppId");
            return (Criteria) this;
        }

        public Criteria andWxpayAppIdNotEqualTo(String value) {
            addCriterion("wxpay_app_id <>", value, "wxpayAppId");
            return (Criteria) this;
        }

        public Criteria andWxpayAppIdGreaterThan(String value) {
            addCriterion("wxpay_app_id >", value, "wxpayAppId");
            return (Criteria) this;
        }

        public Criteria andWxpayAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("wxpay_app_id >=", value, "wxpayAppId");
            return (Criteria) this;
        }

        public Criteria andWxpayAppIdLessThan(String value) {
            addCriterion("wxpay_app_id <", value, "wxpayAppId");
            return (Criteria) this;
        }

        public Criteria andWxpayAppIdLessThanOrEqualTo(String value) {
            addCriterion("wxpay_app_id <=", value, "wxpayAppId");
            return (Criteria) this;
        }

        public Criteria andWxpayAppIdLike(String value) {
            addCriterion("wxpay_app_id like", value, "wxpayAppId");
            return (Criteria) this;
        }

        public Criteria andWxpayAppIdNotLike(String value) {
            addCriterion("wxpay_app_id not like", value, "wxpayAppId");
            return (Criteria) this;
        }

        public Criteria andWxpayAppIdIn(List<String> values) {
            addCriterion("wxpay_app_id in", values, "wxpayAppId");
            return (Criteria) this;
        }

        public Criteria andWxpayAppIdNotIn(List<String> values) {
            addCriterion("wxpay_app_id not in", values, "wxpayAppId");
            return (Criteria) this;
        }

        public Criteria andWxpayAppIdBetween(String value1, String value2) {
            addCriterion("wxpay_app_id between", value1, value2, "wxpayAppId");
            return (Criteria) this;
        }

        public Criteria andWxpayAppIdNotBetween(String value1, String value2) {
            addCriterion("wxpay_app_id not between", value1, value2, "wxpayAppId");
            return (Criteria) this;
        }

        public Criteria andWxpayAppsecrtIsNull() {
            addCriterion("wxpay_appsecrt is null");
            return (Criteria) this;
        }

        public Criteria andWxpayAppsecrtIsNotNull() {
            addCriterion("wxpay_appsecrt is not null");
            return (Criteria) this;
        }

        public Criteria andWxpayAppsecrtEqualTo(String value) {
            addCriterion("wxpay_appsecrt =", value, "wxpayAppsecrt");
            return (Criteria) this;
        }

        public Criteria andWxpayAppsecrtNotEqualTo(String value) {
            addCriterion("wxpay_appsecrt <>", value, "wxpayAppsecrt");
            return (Criteria) this;
        }

        public Criteria andWxpayAppsecrtGreaterThan(String value) {
            addCriterion("wxpay_appsecrt >", value, "wxpayAppsecrt");
            return (Criteria) this;
        }

        public Criteria andWxpayAppsecrtGreaterThanOrEqualTo(String value) {
            addCriterion("wxpay_appsecrt >=", value, "wxpayAppsecrt");
            return (Criteria) this;
        }

        public Criteria andWxpayAppsecrtLessThan(String value) {
            addCriterion("wxpay_appsecrt <", value, "wxpayAppsecrt");
            return (Criteria) this;
        }

        public Criteria andWxpayAppsecrtLessThanOrEqualTo(String value) {
            addCriterion("wxpay_appsecrt <=", value, "wxpayAppsecrt");
            return (Criteria) this;
        }

        public Criteria andWxpayAppsecrtLike(String value) {
            addCriterion("wxpay_appsecrt like", value, "wxpayAppsecrt");
            return (Criteria) this;
        }

        public Criteria andWxpayAppsecrtNotLike(String value) {
            addCriterion("wxpay_appsecrt not like", value, "wxpayAppsecrt");
            return (Criteria) this;
        }

        public Criteria andWxpayAppsecrtIn(List<String> values) {
            addCriterion("wxpay_appsecrt in", values, "wxpayAppsecrt");
            return (Criteria) this;
        }

        public Criteria andWxpayAppsecrtNotIn(List<String> values) {
            addCriterion("wxpay_appsecrt not in", values, "wxpayAppsecrt");
            return (Criteria) this;
        }

        public Criteria andWxpayAppsecrtBetween(String value1, String value2) {
            addCriterion("wxpay_appsecrt between", value1, value2, "wxpayAppsecrt");
            return (Criteria) this;
        }

        public Criteria andWxpayAppsecrtNotBetween(String value1, String value2) {
            addCriterion("wxpay_appsecrt not between", value1, value2, "wxpayAppsecrt");
            return (Criteria) this;
        }

        public Criteria andQqpayMchIdIsNull() {
            addCriterion("qqpay_mch_id is null");
            return (Criteria) this;
        }

        public Criteria andQqpayMchIdIsNotNull() {
            addCriterion("qqpay_mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andQqpayMchIdEqualTo(String value) {
            addCriterion("qqpay_mch_id =", value, "qqpayMchId");
            return (Criteria) this;
        }

        public Criteria andQqpayMchIdNotEqualTo(String value) {
            addCriterion("qqpay_mch_id <>", value, "qqpayMchId");
            return (Criteria) this;
        }

        public Criteria andQqpayMchIdGreaterThan(String value) {
            addCriterion("qqpay_mch_id >", value, "qqpayMchId");
            return (Criteria) this;
        }

        public Criteria andQqpayMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("qqpay_mch_id >=", value, "qqpayMchId");
            return (Criteria) this;
        }

        public Criteria andQqpayMchIdLessThan(String value) {
            addCriterion("qqpay_mch_id <", value, "qqpayMchId");
            return (Criteria) this;
        }

        public Criteria andQqpayMchIdLessThanOrEqualTo(String value) {
            addCriterion("qqpay_mch_id <=", value, "qqpayMchId");
            return (Criteria) this;
        }

        public Criteria andQqpayMchIdLike(String value) {
            addCriterion("qqpay_mch_id like", value, "qqpayMchId");
            return (Criteria) this;
        }

        public Criteria andQqpayMchIdNotLike(String value) {
            addCriterion("qqpay_mch_id not like", value, "qqpayMchId");
            return (Criteria) this;
        }

        public Criteria andQqpayMchIdIn(List<String> values) {
            addCriterion("qqpay_mch_id in", values, "qqpayMchId");
            return (Criteria) this;
        }

        public Criteria andQqpayMchIdNotIn(List<String> values) {
            addCriterion("qqpay_mch_id not in", values, "qqpayMchId");
            return (Criteria) this;
        }

        public Criteria andQqpayMchIdBetween(String value1, String value2) {
            addCriterion("qqpay_mch_id between", value1, value2, "qqpayMchId");
            return (Criteria) this;
        }

        public Criteria andQqpayMchIdNotBetween(String value1, String value2) {
            addCriterion("qqpay_mch_id not between", value1, value2, "qqpayMchId");
            return (Criteria) this;
        }

        public Criteria andQqpayPrivateKeyIsNull() {
            addCriterion("qqpay_private_key is null");
            return (Criteria) this;
        }

        public Criteria andQqpayPrivateKeyIsNotNull() {
            addCriterion("qqpay_private_key is not null");
            return (Criteria) this;
        }

        public Criteria andQqpayPrivateKeyEqualTo(String value) {
            addCriterion("qqpay_private_key =", value, "qqpayPrivateKey");
            return (Criteria) this;
        }

        public Criteria andQqpayPrivateKeyNotEqualTo(String value) {
            addCriterion("qqpay_private_key <>", value, "qqpayPrivateKey");
            return (Criteria) this;
        }

        public Criteria andQqpayPrivateKeyGreaterThan(String value) {
            addCriterion("qqpay_private_key >", value, "qqpayPrivateKey");
            return (Criteria) this;
        }

        public Criteria andQqpayPrivateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("qqpay_private_key >=", value, "qqpayPrivateKey");
            return (Criteria) this;
        }

        public Criteria andQqpayPrivateKeyLessThan(String value) {
            addCriterion("qqpay_private_key <", value, "qqpayPrivateKey");
            return (Criteria) this;
        }

        public Criteria andQqpayPrivateKeyLessThanOrEqualTo(String value) {
            addCriterion("qqpay_private_key <=", value, "qqpayPrivateKey");
            return (Criteria) this;
        }

        public Criteria andQqpayPrivateKeyLike(String value) {
            addCriterion("qqpay_private_key like", value, "qqpayPrivateKey");
            return (Criteria) this;
        }

        public Criteria andQqpayPrivateKeyNotLike(String value) {
            addCriterion("qqpay_private_key not like", value, "qqpayPrivateKey");
            return (Criteria) this;
        }

        public Criteria andQqpayPrivateKeyIn(List<String> values) {
            addCriterion("qqpay_private_key in", values, "qqpayPrivateKey");
            return (Criteria) this;
        }

        public Criteria andQqpayPrivateKeyNotIn(List<String> values) {
            addCriterion("qqpay_private_key not in", values, "qqpayPrivateKey");
            return (Criteria) this;
        }

        public Criteria andQqpayPrivateKeyBetween(String value1, String value2) {
            addCriterion("qqpay_private_key between", value1, value2, "qqpayPrivateKey");
            return (Criteria) this;
        }

        public Criteria andQqpayPrivateKeyNotBetween(String value1, String value2) {
            addCriterion("qqpay_private_key not between", value1, value2, "qqpayPrivateKey");
            return (Criteria) this;
        }

        public Criteria andQqpayPwIsNull() {
            addCriterion("qqpay_pw is null");
            return (Criteria) this;
        }

        public Criteria andQqpayPwIsNotNull() {
            addCriterion("qqpay_pw is not null");
            return (Criteria) this;
        }

        public Criteria andQqpayPwEqualTo(String value) {
            addCriterion("qqpay_pw =", value, "qqpayPw");
            return (Criteria) this;
        }

        public Criteria andQqpayPwNotEqualTo(String value) {
            addCriterion("qqpay_pw <>", value, "qqpayPw");
            return (Criteria) this;
        }

        public Criteria andQqpayPwGreaterThan(String value) {
            addCriterion("qqpay_pw >", value, "qqpayPw");
            return (Criteria) this;
        }

        public Criteria andQqpayPwGreaterThanOrEqualTo(String value) {
            addCriterion("qqpay_pw >=", value, "qqpayPw");
            return (Criteria) this;
        }

        public Criteria andQqpayPwLessThan(String value) {
            addCriterion("qqpay_pw <", value, "qqpayPw");
            return (Criteria) this;
        }

        public Criteria andQqpayPwLessThanOrEqualTo(String value) {
            addCriterion("qqpay_pw <=", value, "qqpayPw");
            return (Criteria) this;
        }

        public Criteria andQqpayPwLike(String value) {
            addCriterion("qqpay_pw like", value, "qqpayPw");
            return (Criteria) this;
        }

        public Criteria andQqpayPwNotLike(String value) {
            addCriterion("qqpay_pw not like", value, "qqpayPw");
            return (Criteria) this;
        }

        public Criteria andQqpayPwIn(List<String> values) {
            addCriterion("qqpay_pw in", values, "qqpayPw");
            return (Criteria) this;
        }

        public Criteria andQqpayPwNotIn(List<String> values) {
            addCriterion("qqpay_pw not in", values, "qqpayPw");
            return (Criteria) this;
        }

        public Criteria andQqpayPwBetween(String value1, String value2) {
            addCriterion("qqpay_pw between", value1, value2, "qqpayPw");
            return (Criteria) this;
        }

        public Criteria andQqpayPwNotBetween(String value1, String value2) {
            addCriterion("qqpay_pw not between", value1, value2, "qqpayPw");
            return (Criteria) this;
        }

        public Criteria andMailHostIsNull() {
            addCriterion("mail_host is null");
            return (Criteria) this;
        }

        public Criteria andMailHostIsNotNull() {
            addCriterion("mail_host is not null");
            return (Criteria) this;
        }

        public Criteria andMailHostEqualTo(String value) {
            addCriterion("mail_host =", value, "mailHost");
            return (Criteria) this;
        }

        public Criteria andMailHostNotEqualTo(String value) {
            addCriterion("mail_host <>", value, "mailHost");
            return (Criteria) this;
        }

        public Criteria andMailHostGreaterThan(String value) {
            addCriterion("mail_host >", value, "mailHost");
            return (Criteria) this;
        }

        public Criteria andMailHostGreaterThanOrEqualTo(String value) {
            addCriterion("mail_host >=", value, "mailHost");
            return (Criteria) this;
        }

        public Criteria andMailHostLessThan(String value) {
            addCriterion("mail_host <", value, "mailHost");
            return (Criteria) this;
        }

        public Criteria andMailHostLessThanOrEqualTo(String value) {
            addCriterion("mail_host <=", value, "mailHost");
            return (Criteria) this;
        }

        public Criteria andMailHostLike(String value) {
            addCriterion("mail_host like", value, "mailHost");
            return (Criteria) this;
        }

        public Criteria andMailHostNotLike(String value) {
            addCriterion("mail_host not like", value, "mailHost");
            return (Criteria) this;
        }

        public Criteria andMailHostIn(List<String> values) {
            addCriterion("mail_host in", values, "mailHost");
            return (Criteria) this;
        }

        public Criteria andMailHostNotIn(List<String> values) {
            addCriterion("mail_host not in", values, "mailHost");
            return (Criteria) this;
        }

        public Criteria andMailHostBetween(String value1, String value2) {
            addCriterion("mail_host between", value1, value2, "mailHost");
            return (Criteria) this;
        }

        public Criteria andMailHostNotBetween(String value1, String value2) {
            addCriterion("mail_host not between", value1, value2, "mailHost");
            return (Criteria) this;
        }

        public Criteria andMailPostIsNull() {
            addCriterion("mail_post is null");
            return (Criteria) this;
        }

        public Criteria andMailPostIsNotNull() {
            addCriterion("mail_post is not null");
            return (Criteria) this;
        }

        public Criteria andMailPostEqualTo(Integer value) {
            addCriterion("mail_post =", value, "mailPost");
            return (Criteria) this;
        }

        public Criteria andMailPostNotEqualTo(Integer value) {
            addCriterion("mail_post <>", value, "mailPost");
            return (Criteria) this;
        }

        public Criteria andMailPostGreaterThan(Integer value) {
            addCriterion("mail_post >", value, "mailPost");
            return (Criteria) this;
        }

        public Criteria andMailPostGreaterThanOrEqualTo(Integer value) {
            addCriterion("mail_post >=", value, "mailPost");
            return (Criteria) this;
        }

        public Criteria andMailPostLessThan(Integer value) {
            addCriterion("mail_post <", value, "mailPost");
            return (Criteria) this;
        }

        public Criteria andMailPostLessThanOrEqualTo(Integer value) {
            addCriterion("mail_post <=", value, "mailPost");
            return (Criteria) this;
        }

        public Criteria andMailPostIn(List<Integer> values) {
            addCriterion("mail_post in", values, "mailPost");
            return (Criteria) this;
        }

        public Criteria andMailPostNotIn(List<Integer> values) {
            addCriterion("mail_post not in", values, "mailPost");
            return (Criteria) this;
        }

        public Criteria andMailPostBetween(Integer value1, Integer value2) {
            addCriterion("mail_post between", value1, value2, "mailPost");
            return (Criteria) this;
        }

        public Criteria andMailPostNotBetween(Integer value1, Integer value2) {
            addCriterion("mail_post not between", value1, value2, "mailPost");
            return (Criteria) this;
        }

        public Criteria andMailUserIsNull() {
            addCriterion("mail_user is null");
            return (Criteria) this;
        }

        public Criteria andMailUserIsNotNull() {
            addCriterion("mail_user is not null");
            return (Criteria) this;
        }

        public Criteria andMailUserEqualTo(String value) {
            addCriterion("mail_user =", value, "mailUser");
            return (Criteria) this;
        }

        public Criteria andMailUserNotEqualTo(String value) {
            addCriterion("mail_user <>", value, "mailUser");
            return (Criteria) this;
        }

        public Criteria andMailUserGreaterThan(String value) {
            addCriterion("mail_user >", value, "mailUser");
            return (Criteria) this;
        }

        public Criteria andMailUserGreaterThanOrEqualTo(String value) {
            addCriterion("mail_user >=", value, "mailUser");
            return (Criteria) this;
        }

        public Criteria andMailUserLessThan(String value) {
            addCriterion("mail_user <", value, "mailUser");
            return (Criteria) this;
        }

        public Criteria andMailUserLessThanOrEqualTo(String value) {
            addCriterion("mail_user <=", value, "mailUser");
            return (Criteria) this;
        }

        public Criteria andMailUserLike(String value) {
            addCriterion("mail_user like", value, "mailUser");
            return (Criteria) this;
        }

        public Criteria andMailUserNotLike(String value) {
            addCriterion("mail_user not like", value, "mailUser");
            return (Criteria) this;
        }

        public Criteria andMailUserIn(List<String> values) {
            addCriterion("mail_user in", values, "mailUser");
            return (Criteria) this;
        }

        public Criteria andMailUserNotIn(List<String> values) {
            addCriterion("mail_user not in", values, "mailUser");
            return (Criteria) this;
        }

        public Criteria andMailUserBetween(String value1, String value2) {
            addCriterion("mail_user between", value1, value2, "mailUser");
            return (Criteria) this;
        }

        public Criteria andMailUserNotBetween(String value1, String value2) {
            addCriterion("mail_user not between", value1, value2, "mailUser");
            return (Criteria) this;
        }

        public Criteria andMailPwIsNull() {
            addCriterion("mail_pw is null");
            return (Criteria) this;
        }

        public Criteria andMailPwIsNotNull() {
            addCriterion("mail_pw is not null");
            return (Criteria) this;
        }

        public Criteria andMailPwEqualTo(String value) {
            addCriterion("mail_pw =", value, "mailPw");
            return (Criteria) this;
        }

        public Criteria andMailPwNotEqualTo(String value) {
            addCriterion("mail_pw <>", value, "mailPw");
            return (Criteria) this;
        }

        public Criteria andMailPwGreaterThan(String value) {
            addCriterion("mail_pw >", value, "mailPw");
            return (Criteria) this;
        }

        public Criteria andMailPwGreaterThanOrEqualTo(String value) {
            addCriterion("mail_pw >=", value, "mailPw");
            return (Criteria) this;
        }

        public Criteria andMailPwLessThan(String value) {
            addCriterion("mail_pw <", value, "mailPw");
            return (Criteria) this;
        }

        public Criteria andMailPwLessThanOrEqualTo(String value) {
            addCriterion("mail_pw <=", value, "mailPw");
            return (Criteria) this;
        }

        public Criteria andMailPwLike(String value) {
            addCriterion("mail_pw like", value, "mailPw");
            return (Criteria) this;
        }

        public Criteria andMailPwNotLike(String value) {
            addCriterion("mail_pw not like", value, "mailPw");
            return (Criteria) this;
        }

        public Criteria andMailPwIn(List<String> values) {
            addCriterion("mail_pw in", values, "mailPw");
            return (Criteria) this;
        }

        public Criteria andMailPwNotIn(List<String> values) {
            addCriterion("mail_pw not in", values, "mailPw");
            return (Criteria) this;
        }

        public Criteria andMailPwBetween(String value1, String value2) {
            addCriterion("mail_pw between", value1, value2, "mailPw");
            return (Criteria) this;
        }

        public Criteria andMailPwNotBetween(String value1, String value2) {
            addCriterion("mail_pw not between", value1, value2, "mailPw");
            return (Criteria) this;
        }

        public Criteria andEpayApiIsNull() {
            addCriterion("epay_api is null");
            return (Criteria) this;
        }

        public Criteria andEpayApiIsNotNull() {
            addCriterion("epay_api is not null");
            return (Criteria) this;
        }

        public Criteria andEpayApiEqualTo(String value) {
            addCriterion("epay_api =", value, "epayApi");
            return (Criteria) this;
        }

        public Criteria andEpayApiNotEqualTo(String value) {
            addCriterion("epay_api <>", value, "epayApi");
            return (Criteria) this;
        }

        public Criteria andEpayApiGreaterThan(String value) {
            addCriterion("epay_api >", value, "epayApi");
            return (Criteria) this;
        }

        public Criteria andEpayApiGreaterThanOrEqualTo(String value) {
            addCriterion("epay_api >=", value, "epayApi");
            return (Criteria) this;
        }

        public Criteria andEpayApiLessThan(String value) {
            addCriterion("epay_api <", value, "epayApi");
            return (Criteria) this;
        }

        public Criteria andEpayApiLessThanOrEqualTo(String value) {
            addCriterion("epay_api <=", value, "epayApi");
            return (Criteria) this;
        }

        public Criteria andEpayApiLike(String value) {
            addCriterion("epay_api like", value, "epayApi");
            return (Criteria) this;
        }

        public Criteria andEpayApiNotLike(String value) {
            addCriterion("epay_api not like", value, "epayApi");
            return (Criteria) this;
        }

        public Criteria andEpayApiIn(List<String> values) {
            addCriterion("epay_api in", values, "epayApi");
            return (Criteria) this;
        }

        public Criteria andEpayApiNotIn(List<String> values) {
            addCriterion("epay_api not in", values, "epayApi");
            return (Criteria) this;
        }

        public Criteria andEpayApiBetween(String value1, String value2) {
            addCriterion("epay_api between", value1, value2, "epayApi");
            return (Criteria) this;
        }

        public Criteria andEpayApiNotBetween(String value1, String value2) {
            addCriterion("epay_api not between", value1, value2, "epayApi");
            return (Criteria) this;
        }

        public Criteria andEpayId2IsNull() {
            addCriterion("epay_id2 is null");
            return (Criteria) this;
        }

        public Criteria andEpayId2IsNotNull() {
            addCriterion("epay_id2 is not null");
            return (Criteria) this;
        }

        public Criteria andEpayId2EqualTo(String value) {
            addCriterion("epay_id2 =", value, "epayId2");
            return (Criteria) this;
        }

        public Criteria andEpayId2NotEqualTo(String value) {
            addCriterion("epay_id2 <>", value, "epayId2");
            return (Criteria) this;
        }

        public Criteria andEpayId2GreaterThan(String value) {
            addCriterion("epay_id2 >", value, "epayId2");
            return (Criteria) this;
        }

        public Criteria andEpayId2GreaterThanOrEqualTo(String value) {
            addCriterion("epay_id2 >=", value, "epayId2");
            return (Criteria) this;
        }

        public Criteria andEpayId2LessThan(String value) {
            addCriterion("epay_id2 <", value, "epayId2");
            return (Criteria) this;
        }

        public Criteria andEpayId2LessThanOrEqualTo(String value) {
            addCriterion("epay_id2 <=", value, "epayId2");
            return (Criteria) this;
        }

        public Criteria andEpayId2Like(String value) {
            addCriterion("epay_id2 like", value, "epayId2");
            return (Criteria) this;
        }

        public Criteria andEpayId2NotLike(String value) {
            addCriterion("epay_id2 not like", value, "epayId2");
            return (Criteria) this;
        }

        public Criteria andEpayId2In(List<String> values) {
            addCriterion("epay_id2 in", values, "epayId2");
            return (Criteria) this;
        }

        public Criteria andEpayId2NotIn(List<String> values) {
            addCriterion("epay_id2 not in", values, "epayId2");
            return (Criteria) this;
        }

        public Criteria andEpayId2Between(String value1, String value2) {
            addCriterion("epay_id2 between", value1, value2, "epayId2");
            return (Criteria) this;
        }

        public Criteria andEpayId2NotBetween(String value1, String value2) {
            addCriterion("epay_id2 not between", value1, value2, "epayId2");
            return (Criteria) this;
        }

        public Criteria andEpayKey2IsNull() {
            addCriterion("epay_key2 is null");
            return (Criteria) this;
        }

        public Criteria andEpayKey2IsNotNull() {
            addCriterion("epay_key2 is not null");
            return (Criteria) this;
        }

        public Criteria andEpayKey2EqualTo(String value) {
            addCriterion("epay_key2 =", value, "epayKey2");
            return (Criteria) this;
        }

        public Criteria andEpayKey2NotEqualTo(String value) {
            addCriterion("epay_key2 <>", value, "epayKey2");
            return (Criteria) this;
        }

        public Criteria andEpayKey2GreaterThan(String value) {
            addCriterion("epay_key2 >", value, "epayKey2");
            return (Criteria) this;
        }

        public Criteria andEpayKey2GreaterThanOrEqualTo(String value) {
            addCriterion("epay_key2 >=", value, "epayKey2");
            return (Criteria) this;
        }

        public Criteria andEpayKey2LessThan(String value) {
            addCriterion("epay_key2 <", value, "epayKey2");
            return (Criteria) this;
        }

        public Criteria andEpayKey2LessThanOrEqualTo(String value) {
            addCriterion("epay_key2 <=", value, "epayKey2");
            return (Criteria) this;
        }

        public Criteria andEpayKey2Like(String value) {
            addCriterion("epay_key2 like", value, "epayKey2");
            return (Criteria) this;
        }

        public Criteria andEpayKey2NotLike(String value) {
            addCriterion("epay_key2 not like", value, "epayKey2");
            return (Criteria) this;
        }

        public Criteria andEpayKey2In(List<String> values) {
            addCriterion("epay_key2 in", values, "epayKey2");
            return (Criteria) this;
        }

        public Criteria andEpayKey2NotIn(List<String> values) {
            addCriterion("epay_key2 not in", values, "epayKey2");
            return (Criteria) this;
        }

        public Criteria andEpayKey2Between(String value1, String value2) {
            addCriterion("epay_key2 between", value1, value2, "epayKey2");
            return (Criteria) this;
        }

        public Criteria andEpayKey2NotBetween(String value1, String value2) {
            addCriterion("epay_key2 not between", value1, value2, "epayKey2");
            return (Criteria) this;
        }

        public Criteria andEpayApi2IsNull() {
            addCriterion("epay_api2 is null");
            return (Criteria) this;
        }

        public Criteria andEpayApi2IsNotNull() {
            addCriterion("epay_api2 is not null");
            return (Criteria) this;
        }

        public Criteria andEpayApi2EqualTo(String value) {
            addCriterion("epay_api2 =", value, "epayApi2");
            return (Criteria) this;
        }

        public Criteria andEpayApi2NotEqualTo(String value) {
            addCriterion("epay_api2 <>", value, "epayApi2");
            return (Criteria) this;
        }

        public Criteria andEpayApi2GreaterThan(String value) {
            addCriterion("epay_api2 >", value, "epayApi2");
            return (Criteria) this;
        }

        public Criteria andEpayApi2GreaterThanOrEqualTo(String value) {
            addCriterion("epay_api2 >=", value, "epayApi2");
            return (Criteria) this;
        }

        public Criteria andEpayApi2LessThan(String value) {
            addCriterion("epay_api2 <", value, "epayApi2");
            return (Criteria) this;
        }

        public Criteria andEpayApi2LessThanOrEqualTo(String value) {
            addCriterion("epay_api2 <=", value, "epayApi2");
            return (Criteria) this;
        }

        public Criteria andEpayApi2Like(String value) {
            addCriterion("epay_api2 like", value, "epayApi2");
            return (Criteria) this;
        }

        public Criteria andEpayApi2NotLike(String value) {
            addCriterion("epay_api2 not like", value, "epayApi2");
            return (Criteria) this;
        }

        public Criteria andEpayApi2In(List<String> values) {
            addCriterion("epay_api2 in", values, "epayApi2");
            return (Criteria) this;
        }

        public Criteria andEpayApi2NotIn(List<String> values) {
            addCriterion("epay_api2 not in", values, "epayApi2");
            return (Criteria) this;
        }

        public Criteria andEpayApi2Between(String value1, String value2) {
            addCriterion("epay_api2 between", value1, value2, "epayApi2");
            return (Criteria) this;
        }

        public Criteria andEpayApi2NotBetween(String value1, String value2) {
            addCriterion("epay_api2 not between", value1, value2, "epayApi2");
            return (Criteria) this;
        }

        public Criteria andEpayId3IsNull() {
            addCriterion("epay_id3 is null");
            return (Criteria) this;
        }

        public Criteria andEpayId3IsNotNull() {
            addCriterion("epay_id3 is not null");
            return (Criteria) this;
        }

        public Criteria andEpayId3EqualTo(String value) {
            addCriterion("epay_id3 =", value, "epayId3");
            return (Criteria) this;
        }

        public Criteria andEpayId3NotEqualTo(String value) {
            addCriterion("epay_id3 <>", value, "epayId3");
            return (Criteria) this;
        }

        public Criteria andEpayId3GreaterThan(String value) {
            addCriterion("epay_id3 >", value, "epayId3");
            return (Criteria) this;
        }

        public Criteria andEpayId3GreaterThanOrEqualTo(String value) {
            addCriterion("epay_id3 >=", value, "epayId3");
            return (Criteria) this;
        }

        public Criteria andEpayId3LessThan(String value) {
            addCriterion("epay_id3 <", value, "epayId3");
            return (Criteria) this;
        }

        public Criteria andEpayId3LessThanOrEqualTo(String value) {
            addCriterion("epay_id3 <=", value, "epayId3");
            return (Criteria) this;
        }

        public Criteria andEpayId3Like(String value) {
            addCriterion("epay_id3 like", value, "epayId3");
            return (Criteria) this;
        }

        public Criteria andEpayId3NotLike(String value) {
            addCriterion("epay_id3 not like", value, "epayId3");
            return (Criteria) this;
        }

        public Criteria andEpayId3In(List<String> values) {
            addCriterion("epay_id3 in", values, "epayId3");
            return (Criteria) this;
        }

        public Criteria andEpayId3NotIn(List<String> values) {
            addCriterion("epay_id3 not in", values, "epayId3");
            return (Criteria) this;
        }

        public Criteria andEpayId3Between(String value1, String value2) {
            addCriterion("epay_id3 between", value1, value2, "epayId3");
            return (Criteria) this;
        }

        public Criteria andEpayId3NotBetween(String value1, String value2) {
            addCriterion("epay_id3 not between", value1, value2, "epayId3");
            return (Criteria) this;
        }

        public Criteria andEpayKey3IsNull() {
            addCriterion("epay_key3 is null");
            return (Criteria) this;
        }

        public Criteria andEpayKey3IsNotNull() {
            addCriterion("epay_key3 is not null");
            return (Criteria) this;
        }

        public Criteria andEpayKey3EqualTo(String value) {
            addCriterion("epay_key3 =", value, "epayKey3");
            return (Criteria) this;
        }

        public Criteria andEpayKey3NotEqualTo(String value) {
            addCriterion("epay_key3 <>", value, "epayKey3");
            return (Criteria) this;
        }

        public Criteria andEpayKey3GreaterThan(String value) {
            addCriterion("epay_key3 >", value, "epayKey3");
            return (Criteria) this;
        }

        public Criteria andEpayKey3GreaterThanOrEqualTo(String value) {
            addCriterion("epay_key3 >=", value, "epayKey3");
            return (Criteria) this;
        }

        public Criteria andEpayKey3LessThan(String value) {
            addCriterion("epay_key3 <", value, "epayKey3");
            return (Criteria) this;
        }

        public Criteria andEpayKey3LessThanOrEqualTo(String value) {
            addCriterion("epay_key3 <=", value, "epayKey3");
            return (Criteria) this;
        }

        public Criteria andEpayKey3Like(String value) {
            addCriterion("epay_key3 like", value, "epayKey3");
            return (Criteria) this;
        }

        public Criteria andEpayKey3NotLike(String value) {
            addCriterion("epay_key3 not like", value, "epayKey3");
            return (Criteria) this;
        }

        public Criteria andEpayKey3In(List<String> values) {
            addCriterion("epay_key3 in", values, "epayKey3");
            return (Criteria) this;
        }

        public Criteria andEpayKey3NotIn(List<String> values) {
            addCriterion("epay_key3 not in", values, "epayKey3");
            return (Criteria) this;
        }

        public Criteria andEpayKey3Between(String value1, String value2) {
            addCriterion("epay_key3 between", value1, value2, "epayKey3");
            return (Criteria) this;
        }

        public Criteria andEpayKey3NotBetween(String value1, String value2) {
            addCriterion("epay_key3 not between", value1, value2, "epayKey3");
            return (Criteria) this;
        }

        public Criteria andEpayApi3IsNull() {
            addCriterion("epay_api3 is null");
            return (Criteria) this;
        }

        public Criteria andEpayApi3IsNotNull() {
            addCriterion("epay_api3 is not null");
            return (Criteria) this;
        }

        public Criteria andEpayApi3EqualTo(String value) {
            addCriterion("epay_api3 =", value, "epayApi3");
            return (Criteria) this;
        }

        public Criteria andEpayApi3NotEqualTo(String value) {
            addCriterion("epay_api3 <>", value, "epayApi3");
            return (Criteria) this;
        }

        public Criteria andEpayApi3GreaterThan(String value) {
            addCriterion("epay_api3 >", value, "epayApi3");
            return (Criteria) this;
        }

        public Criteria andEpayApi3GreaterThanOrEqualTo(String value) {
            addCriterion("epay_api3 >=", value, "epayApi3");
            return (Criteria) this;
        }

        public Criteria andEpayApi3LessThan(String value) {
            addCriterion("epay_api3 <", value, "epayApi3");
            return (Criteria) this;
        }

        public Criteria andEpayApi3LessThanOrEqualTo(String value) {
            addCriterion("epay_api3 <=", value, "epayApi3");
            return (Criteria) this;
        }

        public Criteria andEpayApi3Like(String value) {
            addCriterion("epay_api3 like", value, "epayApi3");
            return (Criteria) this;
        }

        public Criteria andEpayApi3NotLike(String value) {
            addCriterion("epay_api3 not like", value, "epayApi3");
            return (Criteria) this;
        }

        public Criteria andEpayApi3In(List<String> values) {
            addCriterion("epay_api3 in", values, "epayApi3");
            return (Criteria) this;
        }

        public Criteria andEpayApi3NotIn(List<String> values) {
            addCriterion("epay_api3 not in", values, "epayApi3");
            return (Criteria) this;
        }

        public Criteria andEpayApi3Between(String value1, String value2) {
            addCriterion("epay_api3 between", value1, value2, "epayApi3");
            return (Criteria) this;
        }

        public Criteria andEpayApi3NotBetween(String value1, String value2) {
            addCriterion("epay_api3 not between", value1, value2, "epayApi3");
            return (Criteria) this;
        }

        public Criteria andCodepayIdIsNull() {
            addCriterion("codepay_id is null");
            return (Criteria) this;
        }

        public Criteria andCodepayIdIsNotNull() {
            addCriterion("codepay_id is not null");
            return (Criteria) this;
        }

        public Criteria andCodepayIdEqualTo(String value) {
            addCriterion("codepay_id =", value, "codepayId");
            return (Criteria) this;
        }

        public Criteria andCodepayIdNotEqualTo(String value) {
            addCriterion("codepay_id <>", value, "codepayId");
            return (Criteria) this;
        }

        public Criteria andCodepayIdGreaterThan(String value) {
            addCriterion("codepay_id >", value, "codepayId");
            return (Criteria) this;
        }

        public Criteria andCodepayIdGreaterThanOrEqualTo(String value) {
            addCriterion("codepay_id >=", value, "codepayId");
            return (Criteria) this;
        }

        public Criteria andCodepayIdLessThan(String value) {
            addCriterion("codepay_id <", value, "codepayId");
            return (Criteria) this;
        }

        public Criteria andCodepayIdLessThanOrEqualTo(String value) {
            addCriterion("codepay_id <=", value, "codepayId");
            return (Criteria) this;
        }

        public Criteria andCodepayIdLike(String value) {
            addCriterion("codepay_id like", value, "codepayId");
            return (Criteria) this;
        }

        public Criteria andCodepayIdNotLike(String value) {
            addCriterion("codepay_id not like", value, "codepayId");
            return (Criteria) this;
        }

        public Criteria andCodepayIdIn(List<String> values) {
            addCriterion("codepay_id in", values, "codepayId");
            return (Criteria) this;
        }

        public Criteria andCodepayIdNotIn(List<String> values) {
            addCriterion("codepay_id not in", values, "codepayId");
            return (Criteria) this;
        }

        public Criteria andCodepayIdBetween(String value1, String value2) {
            addCriterion("codepay_id between", value1, value2, "codepayId");
            return (Criteria) this;
        }

        public Criteria andCodepayIdNotBetween(String value1, String value2) {
            addCriterion("codepay_id not between", value1, value2, "codepayId");
            return (Criteria) this;
        }

        public Criteria andCodepayApiIsNull() {
            addCriterion("codepay_api is null");
            return (Criteria) this;
        }

        public Criteria andCodepayApiIsNotNull() {
            addCriterion("codepay_api is not null");
            return (Criteria) this;
        }

        public Criteria andCodepayApiEqualTo(String value) {
            addCriterion("codepay_api =", value, "codepayApi");
            return (Criteria) this;
        }

        public Criteria andCodepayApiNotEqualTo(String value) {
            addCriterion("codepay_api <>", value, "codepayApi");
            return (Criteria) this;
        }

        public Criteria andCodepayApiGreaterThan(String value) {
            addCriterion("codepay_api >", value, "codepayApi");
            return (Criteria) this;
        }

        public Criteria andCodepayApiGreaterThanOrEqualTo(String value) {
            addCriterion("codepay_api >=", value, "codepayApi");
            return (Criteria) this;
        }

        public Criteria andCodepayApiLessThan(String value) {
            addCriterion("codepay_api <", value, "codepayApi");
            return (Criteria) this;
        }

        public Criteria andCodepayApiLessThanOrEqualTo(String value) {
            addCriterion("codepay_api <=", value, "codepayApi");
            return (Criteria) this;
        }

        public Criteria andCodepayApiLike(String value) {
            addCriterion("codepay_api like", value, "codepayApi");
            return (Criteria) this;
        }

        public Criteria andCodepayApiNotLike(String value) {
            addCriterion("codepay_api not like", value, "codepayApi");
            return (Criteria) this;
        }

        public Criteria andCodepayApiIn(List<String> values) {
            addCriterion("codepay_api in", values, "codepayApi");
            return (Criteria) this;
        }

        public Criteria andCodepayApiNotIn(List<String> values) {
            addCriterion("codepay_api not in", values, "codepayApi");
            return (Criteria) this;
        }

        public Criteria andCodepayApiBetween(String value1, String value2) {
            addCriterion("codepay_api between", value1, value2, "codepayApi");
            return (Criteria) this;
        }

        public Criteria andCodepayApiNotBetween(String value1, String value2) {
            addCriterion("codepay_api not between", value1, value2, "codepayApi");
            return (Criteria) this;
        }

        public Criteria andCodepayKeyIsNull() {
            addCriterion("codepay_key is null");
            return (Criteria) this;
        }

        public Criteria andCodepayKeyIsNotNull() {
            addCriterion("codepay_key is not null");
            return (Criteria) this;
        }

        public Criteria andCodepayKeyEqualTo(String value) {
            addCriterion("codepay_key =", value, "codepayKey");
            return (Criteria) this;
        }

        public Criteria andCodepayKeyNotEqualTo(String value) {
            addCriterion("codepay_key <>", value, "codepayKey");
            return (Criteria) this;
        }

        public Criteria andCodepayKeyGreaterThan(String value) {
            addCriterion("codepay_key >", value, "codepayKey");
            return (Criteria) this;
        }

        public Criteria andCodepayKeyGreaterThanOrEqualTo(String value) {
            addCriterion("codepay_key >=", value, "codepayKey");
            return (Criteria) this;
        }

        public Criteria andCodepayKeyLessThan(String value) {
            addCriterion("codepay_key <", value, "codepayKey");
            return (Criteria) this;
        }

        public Criteria andCodepayKeyLessThanOrEqualTo(String value) {
            addCriterion("codepay_key <=", value, "codepayKey");
            return (Criteria) this;
        }

        public Criteria andCodepayKeyLike(String value) {
            addCriterion("codepay_key like", value, "codepayKey");
            return (Criteria) this;
        }

        public Criteria andCodepayKeyNotLike(String value) {
            addCriterion("codepay_key not like", value, "codepayKey");
            return (Criteria) this;
        }

        public Criteria andCodepayKeyIn(List<String> values) {
            addCriterion("codepay_key in", values, "codepayKey");
            return (Criteria) this;
        }

        public Criteria andCodepayKeyNotIn(List<String> values) {
            addCriterion("codepay_key not in", values, "codepayKey");
            return (Criteria) this;
        }

        public Criteria andCodepayKeyBetween(String value1, String value2) {
            addCriterion("codepay_key between", value1, value2, "codepayKey");
            return (Criteria) this;
        }

        public Criteria andCodepayKeyNotBetween(String value1, String value2) {
            addCriterion("codepay_key not between", value1, value2, "codepayKey");
            return (Criteria) this;
        }

        public Criteria andCodepayNotifyUrlIsNull() {
            addCriterion("codepay_notify_url is null");
            return (Criteria) this;
        }

        public Criteria andCodepayNotifyUrlIsNotNull() {
            addCriterion("codepay_notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andCodepayNotifyUrlEqualTo(String value) {
            addCriterion("codepay_notify_url =", value, "codepayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andCodepayNotifyUrlNotEqualTo(String value) {
            addCriterion("codepay_notify_url <>", value, "codepayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andCodepayNotifyUrlGreaterThan(String value) {
            addCriterion("codepay_notify_url >", value, "codepayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andCodepayNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("codepay_notify_url >=", value, "codepayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andCodepayNotifyUrlLessThan(String value) {
            addCriterion("codepay_notify_url <", value, "codepayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andCodepayNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("codepay_notify_url <=", value, "codepayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andCodepayNotifyUrlLike(String value) {
            addCriterion("codepay_notify_url like", value, "codepayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andCodepayNotifyUrlNotLike(String value) {
            addCriterion("codepay_notify_url not like", value, "codepayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andCodepayNotifyUrlIn(List<String> values) {
            addCriterion("codepay_notify_url in", values, "codepayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andCodepayNotifyUrlNotIn(List<String> values) {
            addCriterion("codepay_notify_url not in", values, "codepayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andCodepayNotifyUrlBetween(String value1, String value2) {
            addCriterion("codepay_notify_url between", value1, value2, "codepayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andCodepayNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("codepay_notify_url not between", value1, value2, "codepayNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andWxMpayModeIsNull() {
            addCriterion("wx_mpay_mode is null");
            return (Criteria) this;
        }

        public Criteria andWxMpayModeIsNotNull() {
            addCriterion("wx_mpay_mode is not null");
            return (Criteria) this;
        }

        public Criteria andWxMpayModeEqualTo(Integer value) {
            addCriterion("wx_mpay_mode =", value, "wxMpayMode");
            return (Criteria) this;
        }

        public Criteria andWxMpayModeNotEqualTo(Integer value) {
            addCriterion("wx_mpay_mode <>", value, "wxMpayMode");
            return (Criteria) this;
        }

        public Criteria andWxMpayModeGreaterThan(Integer value) {
            addCriterion("wx_mpay_mode >", value, "wxMpayMode");
            return (Criteria) this;
        }

        public Criteria andWxMpayModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("wx_mpay_mode >=", value, "wxMpayMode");
            return (Criteria) this;
        }

        public Criteria andWxMpayModeLessThan(Integer value) {
            addCriterion("wx_mpay_mode <", value, "wxMpayMode");
            return (Criteria) this;
        }

        public Criteria andWxMpayModeLessThanOrEqualTo(Integer value) {
            addCriterion("wx_mpay_mode <=", value, "wxMpayMode");
            return (Criteria) this;
        }

        public Criteria andWxMpayModeIn(List<Integer> values) {
            addCriterion("wx_mpay_mode in", values, "wxMpayMode");
            return (Criteria) this;
        }

        public Criteria andWxMpayModeNotIn(List<Integer> values) {
            addCriterion("wx_mpay_mode not in", values, "wxMpayMode");
            return (Criteria) this;
        }

        public Criteria andWxMpayModeBetween(Integer value1, Integer value2) {
            addCriterion("wx_mpay_mode between", value1, value2, "wxMpayMode");
            return (Criteria) this;
        }

        public Criteria andWxMpayModeNotBetween(Integer value1, Integer value2) {
            addCriterion("wx_mpay_mode not between", value1, value2, "wxMpayMode");
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