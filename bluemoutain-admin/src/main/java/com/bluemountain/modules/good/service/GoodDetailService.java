package com.bluemountain.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.modules.good.entity.GoodDetailEntity;
import com.bluemountain.modules.good.entity.view.GoodDetailView;
import com.bluemountain.modules.good.entity.vo.GoodDetailVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 商品描述表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-07 15:43:06
 */
public interface GoodDetailService extends IService<GoodDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoodDetailVO> selectListVO(Wrapper<GoodDetailEntity> wrapper);
   	
   	GoodDetailVO selectVO(@Param("ew") Wrapper<GoodDetailEntity> wrapper);
   	
   	List<GoodDetailView> selectListView(Wrapper<GoodDetailEntity> wrapper);
   	
   	GoodDetailView selectView(@Param("ew") Wrapper<GoodDetailEntity> wrapper);
}

