package com.bluemountain.modules.good.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.good.dao.GoodParameterDao;
import com.bluemountain.modules.good.entity.GoodParameterEntity;
import com.bluemountain.modules.good.entity.view.GoodParameterView;
import com.bluemountain.modules.good.entity.vo.GoodParameterVO;
import com.bluemountain.modules.good.service.GoodParameterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("goodParameterService")
public class GoodParameterServiceImpl extends ServiceImpl<GoodParameterDao, GoodParameterEntity> implements GoodParameterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodParameterEntity> page = this.selectPage(
                new Query<GoodParameterEntity>(params).getPage(),
                new EntityWrapper<GoodParameterEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public List<GoodParameterVO> selectListVO(Wrapper<GoodParameterEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoodParameterVO selectVO( Wrapper<GoodParameterEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GoodParameterView> selectListView(Wrapper<GoodParameterEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GoodParameterView selectView(Wrapper<GoodParameterEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
