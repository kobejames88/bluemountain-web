package com.bluemountain.modules.pc.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.bluemountain.modules.pc.entity.StudentEntity;
import com.bluemountain.modules.pc.entity.view.StudentView;
import com.bluemountain.modules.pc.entity.vo.StudentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 15:47:02
 */
public interface StudentDao extends BaseMapper<StudentEntity> {
	
	List<StudentVO> selectListVO(@Param("ew") Wrapper<StudentEntity> wrapper);
	
	StudentVO selectVO(@Param("ew") Wrapper<StudentEntity> wrapper);
	
	
	List<StudentView> selectListView(@Param("ew") Wrapper<StudentEntity> wrapper);

	List<StudentView> selectListView(Pagination page, @Param("ew") Wrapper<StudentEntity> wrapper);
	
	StudentView selectView(@Param("ew") Wrapper<StudentEntity> wrapper);
}
