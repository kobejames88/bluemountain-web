package com.bluemountain.modules.good.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.good.dao.GoodDao;
import com.bluemountain.modules.good.entity.GoodEntity;
import com.bluemountain.modules.good.entity.vo.GoodVO;
import com.bluemountain.modules.good.service.GoodService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("goodService")
public class GoodServiceImpl extends ServiceImpl<GoodDao, GoodEntity> implements GoodService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodEntity> page = this.selectPage(
                new Query<GoodEntity>(params).getPage(),
                new EntityWrapper<GoodEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public List<GoodVO> selectListVO(Wrapper<GoodEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoodVO selectVO( Wrapper<GoodEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

	@Override
	public 	List<GoodVO> selectGoodAndGoodAttr(Wrapper<GoodEntity> wrapper) {
		// TODO Auto-generated method stub
		return baseMapper.selectGoodAndGoodAttr(wrapper);
	}
	
	

}
