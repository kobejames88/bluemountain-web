package com.bluemountain.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.modules.good.entity.GoodParameterEntity;
import com.bluemountain.modules.good.entity.vo.GoodParameterVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 商品参数表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
public interface GoodParameterService extends IService<GoodParameterEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoodParameterVO> selectListVO(Wrapper<GoodParameterEntity> wrapper);
   	
   	GoodParameterVO selectVO(@Param("ew") Wrapper<GoodParameterEntity> wrapper);
}

