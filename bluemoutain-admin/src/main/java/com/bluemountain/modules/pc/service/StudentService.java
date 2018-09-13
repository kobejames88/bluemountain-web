package com.bluemountain.modules.pc.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.modules.pc.entity.StudentEntity;
import com.bluemountain.modules.pc.entity.view.StudentView;
import com.bluemountain.modules.pc.entity.vo.StudentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 15:47:02
 */
public interface StudentService extends IService<StudentEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<StudentVO> selectListVO(Wrapper<StudentEntity> wrapper);
   	
   	StudentVO selectVO(@Param("ew") Wrapper<StudentEntity> wrapper);
   	
   	List<StudentView> selectListView(Wrapper<StudentEntity> wrapper);
   	
   	StudentView selectView(@Param("ew") Wrapper<StudentEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params, Wrapper<StudentEntity> wrapper);
}

