package com.bluemountain.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.modules.good.entity.ChannelEntity;
import com.bluemountain.modules.good.entity.vo.ChannelVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 频道
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-28 17:34:00
 */
public interface ChannelService extends IService<ChannelEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChannelVO> selectListVO(Wrapper<ChannelEntity> wrapper);
   	
   	ChannelVO selectVO(@Param("ew") Wrapper<ChannelEntity> wrapper);
}

