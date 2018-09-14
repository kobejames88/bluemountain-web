package com.bluemountain.modules.channel.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import com.bluemountain.common.utils.R;
import com.bluemountain.modules.channel.service.ChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.bluemountain.modules.channel.entity.ChannelEntity;
import com.bluemountain.modules.channel.entity.view.ChannelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-06-08 14:46:17
 */
@RestController
@RequestMapping("channel")
@Api(tags="频道接口")
public class ChannelController {
    @Autowired
    private ChannelService channelService;
    /**
     * 获取频道列表
     */
    @GetMapping("/list")
    @ApiOperation("频道列表")
    public R list(){
        EntityWrapper<ChannelEntity> channelEntityWrapper=new EntityWrapper<ChannelEntity>();
        List<ChannelEntity> channelEntityList=channelService.selectList(channelEntityWrapper);
        //channelEntityList.forEach(e-> System.out.println(e.getName()));
        List<ChannelView> channelViewList=new ArrayList<ChannelView>();
        Iterator<ChannelEntity> channelEntityListIt=channelEntityList.iterator();
        while(channelEntityListIt.hasNext()){
            ChannelEntity channelEntity=channelEntityListIt.next();
            ChannelView channelView=new ChannelView(channelEntity);
            System.out.println(channelEntity.getName());
            System.out.println(channelView.getName());
            channelViewList.add(channelView);
        }
        return R.ok().put("data",channelViewList);
    }
}
