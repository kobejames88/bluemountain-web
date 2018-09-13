package com.bluemountain.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.modules.good.entity.CategoryGoodEntity;
import com.bluemountain.modules.good.entity.view.CategoryGoodView;
import com.bluemountain.modules.good.entity.vo.CategoryGoodVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 分类表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-01 16:28:07
 */
public interface CategoryGoodService extends IService<CategoryGoodEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CategoryGoodVO> selectListVO(Wrapper<CategoryGoodEntity> wrapper);
   	
   	CategoryGoodVO selectVO(@Param("ew") Wrapper<CategoryGoodEntity> wrapper);
   	
   	List<CategoryGoodView> selectListView(Wrapper<CategoryGoodEntity> wrapper);
   	
   	CategoryGoodView selectView(@Param("ew") Wrapper<CategoryGoodEntity> wrapper);
}

