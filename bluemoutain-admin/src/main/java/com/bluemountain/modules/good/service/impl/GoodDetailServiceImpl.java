package com.bluemountain.modules.good.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.good.dao.GoodDetailDao;
import com.bluemountain.modules.good.entity.GoodDetailEntity;
import com.bluemountain.modules.good.entity.view.GoodDetailView;
import com.bluemountain.modules.good.entity.vo.GoodDetailVO;
import com.bluemountain.modules.good.service.GoodDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("goodDetailService")
public class GoodDetailServiceImpl extends ServiceImpl<GoodDetailDao, GoodDetailEntity> implements GoodDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodDetailEntity> page = this.selectPage(
                new Query<GoodDetailEntity>(params).getPage(),
                new EntityWrapper<GoodDetailEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public List<GoodDetailVO> selectListVO(Wrapper<GoodDetailEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoodDetailVO selectVO( Wrapper<GoodDetailEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GoodDetailView> selectListView(Wrapper<GoodDetailEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GoodDetailView selectView(Wrapper<GoodDetailEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
