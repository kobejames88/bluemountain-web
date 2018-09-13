package com.bluemountain.modules.pc.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.bluemountain.modules.pc.entity.SchoolEntity;
import com.bluemountain.modules.pc.entity.view.SchoolView;
import com.bluemountain.modules.pc.entity.vo.SchoolVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 12:40:06
 */
public interface SchoolDao extends BaseMapper<SchoolEntity> {
	
	List<SchoolVO> selectListVO(@Param("ew") Wrapper<SchoolEntity> wrapper);
	
	SchoolVO selectVO(@Param("ew") Wrapper<SchoolEntity> wrapper);
	
	
	List<SchoolView> selectListView(@Param("ew") Wrapper<SchoolEntity> wrapper);

	SchoolView selectView(@Param("ew") Wrapper<SchoolEntity> wrapper);
}
