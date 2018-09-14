package com.bluemountain.modules.pc.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;

import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.modules.pc.entity.PcEntity;
import com.bluemountain.modules.pc.entity.view.PcView;
import com.bluemountain.modules.pc.entity.vo.PcVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 14:56:33
 */
public interface PcService extends IService<PcEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PcVO> selectListVO(Wrapper<PcEntity> wrapper);
   	
   	PcVO selectVO(@Param("ew") Wrapper<PcEntity> wrapper);
   	
   	List<PcView> selectListView(Wrapper<PcEntity> wrapper);
   	
   	PcView selectView(@Param("ew") Wrapper<PcEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params, Wrapper<PcEntity> wrapper);
}

