package com.bluemountain.modules.adverts.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.modules.adverts.entity.AdvertsEntity;
import com.bluemountain.modules.adverts.entity.view.AdvertsView;
import com.bluemountain.modules.adverts.entity.vo.AdvertsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 广告位表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-11 16:44:18
 */
public interface AdvertsService extends IService<AdvertsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<AdvertsVO> selectListVO(Wrapper<AdvertsEntity> wrapper);
   	
   	AdvertsVO selectVO(@Param("ew") Wrapper<AdvertsEntity> wrapper);
   	
   	List<AdvertsView> selectListView(Wrapper<AdvertsEntity> wrapper);
   	
   	AdvertsView selectView(@Param("ew") Wrapper<AdvertsEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params, Wrapper<AdvertsEntity> wrapper);
}

