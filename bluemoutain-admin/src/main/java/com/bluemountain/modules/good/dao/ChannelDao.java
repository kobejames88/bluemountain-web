package com.bluemountain.modules.good.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.bluemountain.modules.good.entity.ChannelEntity;
import com.bluemountain.modules.good.entity.vo.ChannelVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 频道
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-28 17:34:00
 */
public interface ChannelDao extends BaseMapper<ChannelEntity> {
	
	List<ChannelVO> selectListVO(@Param("ew") Wrapper<ChannelEntity> wrapper);
	
	ChannelVO selectVO(@Param("ew") Wrapper<ChannelEntity> wrapper);
}
