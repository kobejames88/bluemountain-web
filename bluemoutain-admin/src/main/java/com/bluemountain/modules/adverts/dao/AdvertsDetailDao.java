package com.bluemountain.modules.adverts.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.bluemountain.modules.adverts.entity.AdvertsDetailEntity;
import com.bluemountain.modules.adverts.entity.view.AdvertsDetailView;
import com.bluemountain.modules.adverts.entity.vo.AdvertsDetailVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 广告位详情
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-11 16:44:19
 */
public interface AdvertsDetailDao extends BaseMapper<AdvertsDetailEntity> {
	
	List<AdvertsDetailVO> selectListVO(@Param("ew") Wrapper<AdvertsDetailEntity> wrapper);
	
	AdvertsDetailVO selectVO(@Param("ew") Wrapper<AdvertsDetailEntity> wrapper);
	
	
	List<AdvertsDetailView> selectListView(@Param("ew") Wrapper<AdvertsDetailEntity> wrapper);

	List<AdvertsDetailView> selectListView(Pagination page, @Param("ew") Wrapper<AdvertsDetailEntity> wrapper);
	
	AdvertsDetailView selectView(@Param("ew") Wrapper<AdvertsDetailEntity> wrapper);
}
