package com.bluemountain.modules.pc.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.bluemountain.modules.pc.entity.PcEntity;
import com.bluemountain.modules.pc.entity.view.PcView;
import com.bluemountain.modules.pc.entity.vo.PcVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 15:47:02
 */
public interface PcDao extends BaseMapper<PcEntity> {
	
	List<PcVO> selectListVO(@Param("ew") Wrapper<PcEntity> wrapper);
	
	PcVO selectVO(@Param("ew") Wrapper<PcEntity> wrapper);
	
	
	List<PcView> selectListView(@Param("ew") Wrapper<PcEntity> wrapper);

	List<PcView> selectListView(Pagination page, @Param("ew") Wrapper<PcEntity> wrapper);
	
	PcView selectView(@Param("ew") Wrapper<PcEntity> wrapper);
}
