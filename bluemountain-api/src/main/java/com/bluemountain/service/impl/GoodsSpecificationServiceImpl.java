/****************************************************
 * Description: ServiceImpl for 商品规格
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-04 zhanghejie Create File
**************************************************/

package com.bluemountain.service.impl;


import com.bluemountain.business.goods.dao.GoodsSpecificationDao;
import com.bluemountain.business.goods.entity.GoodsSpecificationEntity;
import com.bluemountain.service.GoodsSpecificationService;
import com.bluemoutain.dao.XjjDAO;
import com.bluemoutain.service.XjjServiceSupport;
import com.bluemoutain.web.support.XJJParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsSpecificationServiceImpl extends XjjServiceSupport<GoodsSpecificationEntity> implements GoodsSpecificationService {

	@Autowired
	private GoodsSpecificationDao goodsSpecificationDao;

	@Override
	public XjjDAO<GoodsSpecificationEntity> getDao() {
		
		return goodsSpecificationDao;
	}
	
	private class VO {
        private String name;
        private List<GoodsSpecificationEntity> valueList;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public List<GoodsSpecificationEntity> getValueList() {
            return valueList;
        }

        public void setValueList(List<GoodsSpecificationEntity> valueList) {
            this.valueList = valueList;
        }
    }

    /**
     * [
     *  {
     *      name: '',
     *      valueList: [ {}, {}]
     *  },
     *  {
     *      name: '',
     *      valueList: [ {}, {}]
     *  }
     *  ]
     *
     * @param id
     * @return
     */
    public Object getSpecificationVoList(Long id) {
        List<GoodsSpecificationEntity> goodsSpecificationList = findListByGoodsId(id);

        Map<String, VO> map = new HashMap<>();
        List<VO> specificationVoList = new ArrayList<>();

        for(GoodsSpecificationEntity goodsSpecification : goodsSpecificationList){
            String specification = goodsSpecification.getSpecification();
            VO goodsSpecificationVo = map.get(specification);
            if(goodsSpecificationVo == null){
                goodsSpecificationVo = new VO();
                goodsSpecificationVo.setName(specification);
                List<GoodsSpecificationEntity> valueList = new ArrayList<>();
                valueList.add(goodsSpecification);
                goodsSpecificationVo.setValueList(valueList);
                map.put(specification, goodsSpecificationVo);
                specificationVoList.add(goodsSpecificationVo);
            }
            else{
                List<GoodsSpecificationEntity> valueList = goodsSpecificationVo.getValueList();
                valueList.add(goodsSpecification);
            }
        }

        return specificationVoList;
    }
    
    
    /**
	 * 根据商品id查询product列表
	 * @param goodsId
	 * @return
	 */
	public List<GoodsSpecificationEntity> findListByGoodsId(Long goodsId)
	{
		XJJParameter query = new XJJParameter();
		query.addQuery("query.goodsId@eq@l", goodsId);
		List<GoodsSpecificationEntity> list = goodsSpecificationDao.findList(query.getQueryMap());
		return list;
	}
}