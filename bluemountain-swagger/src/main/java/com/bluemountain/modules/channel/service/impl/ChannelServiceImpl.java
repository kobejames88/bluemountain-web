package com.bluemountain.modules.channel.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.channel.service.ChannelService;
import com.bluemountain.modules.channel.dao.ChannelDao;
import com.bluemountain.modules.channel.entity.ChannelEntity;
import org.springframework.stereotype.Service;

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

}
