package com.bluemountain.modules.pc.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.modules.pc.entity.SchoolEntity;
import com.bluemountain.modules.pc.entity.view.SchoolView;
import com.bluemountain.modules.pc.entity.vo.SchoolVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 12:40:06
 */
public interface SchoolService extends IService<SchoolEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SchoolVO> selectListVO(Wrapper<SchoolEntity> wrapper);
   	
   	SchoolVO selectVO(@Param("ew") Wrapper<SchoolEntity> wrapper);
   	
   	List<SchoolView> selectListView(Wrapper<SchoolEntity> wrapper);
   	
   	SchoolView selectView(@Param("ew") Wrapper<SchoolEntity> wrapper);
}

