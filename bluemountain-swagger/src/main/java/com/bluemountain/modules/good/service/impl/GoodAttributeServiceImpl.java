package com.bluemountain.modules.good.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.good.dao.GoodAttributeDao;
import com.bluemountain.modules.good.entity.GoodAttributeEntity;
import com.bluemountain.modules.good.entity.vo.GoodAttributeVO;
import com.bluemountain.modules.good.service.GoodAttributeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("goodAttributeService")
public class GoodAttributeServiceImpl extends ServiceImpl<GoodAttributeDao, GoodAttributeEntity> implements GoodAttributeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodAttributeEntity> page = this.selectPage(
                new Query<GoodAttributeEntity>(params).getPage(),
                new EntityWrapper<GoodAttributeEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public List<GoodAttributeVO> selectListVO(Wrapper<GoodAttributeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoodAttributeVO selectVO( Wrapper<GoodAttributeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

}
