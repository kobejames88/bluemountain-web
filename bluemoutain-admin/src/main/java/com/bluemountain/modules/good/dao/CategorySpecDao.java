package com.bluemountain.modules.good.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.bluemountain.modules.good.entity.CategorySpecEntity;
import com.bluemountain.modules.good.entity.view.CategorySpecView;
import com.bluemountain.modules.good.entity.vo.CategorySpecVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 分类规格表
 * 
 * @author michaelou
 * @email 1934615110@qq.com
 * @date 2018-08-31 18:32:07
 */
public interface CategorySpecDao extends BaseMapper<CategorySpecEntity> {
	
	List<CategorySpecVO> selectListVO(@Param("ew") Wrapper<CategorySpecEntity> wrapper);
	
	CategorySpecVO selectVO(@Param("ew") Wrapper<CategorySpecEntity> wrapper);
	
	
	List<CategorySpecView> selectListView(@Param("ew") Wrapper<CategorySpecEntity> wrapper);

	CategorySpecView selectView(@Param("ew") Wrapper<CategorySpecEntity> wrapper);
	
	List<CategorySpecView> selectListView(Pagination page, @Param("ew") Wrapper<CategorySpecEntity> wrapper);
}
