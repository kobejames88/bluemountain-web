package com.bluemountain.modules.good.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.good.dao.ChannelDao;
import com.bluemountain.modules.good.entity.ChannelEntity;
import com.bluemountain.modules.good.entity.vo.ChannelVO;
import com.bluemountain.modules.good.service.ChannelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("channelService")
public class ChannelServiceImpl extends ServiceImpl<ChannelDao, ChannelEntity> implements ChannelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChannelEntity> page = this.selectPage(
                new Query<ChannelEntity>(params).getPage(),
                new EntityWrapper<ChannelEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public List<ChannelVO> selectListVO(Wrapper<ChannelEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChannelVO selectVO( Wrapper<ChannelEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

}
