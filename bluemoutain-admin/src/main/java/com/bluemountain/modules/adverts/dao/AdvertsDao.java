package com.bluemountain.modules.adverts.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.bluemountain.modules.adverts.entity.AdvertsEntity;
import com.bluemountain.modules.adverts.entity.view.AdvertsView;
import com.bluemountain.modules.adverts.entity.vo.AdvertsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 广告位表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-11 16:44:18
 */
public interface AdvertsDao extends BaseMapper<AdvertsEntity> {
	
	List<AdvertsVO> selectListVO(@Param("ew") Wrapper<AdvertsEntity> wrapper);
	
	AdvertsVO selectVO(@Param("ew") Wrapper<AdvertsEntity> wrapper);
	
	
	List<AdvertsView> selectListView(@Param("ew") Wrapper<AdvertsEntity> wrapper);

	List<AdvertsView> selectListView(Pagination page, @Param("ew") Wrapper<AdvertsEntity> wrapper);
	
	AdvertsView selectView(@Param("ew") Wrapper<AdvertsEntity> wrapper);
}
