package com.bluemountain.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.modules.good.entity.GoodAttributeEntity;
import com.bluemountain.modules.good.entity.view.GoodAttributeView;
import com.bluemountain.modules.good.entity.vo.GoodAttributeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 商品属性表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-30 17:28:16
 */
public interface GoodAttributeService extends IService<GoodAttributeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoodAttributeVO> selectListVO(Wrapper<GoodAttributeEntity> wrapper);
   	
   	GoodAttributeVO selectVO(@Param("ew") Wrapper<GoodAttributeEntity> wrapper);
   	
   	List<GoodAttributeView> selectListView(Wrapper<GoodAttributeEntity> wrapper);
   	
   	GoodAttributeView selectView(@Param("ew") Wrapper<GoodAttributeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params, Wrapper<GoodAttributeEntity> wrapper);
}

