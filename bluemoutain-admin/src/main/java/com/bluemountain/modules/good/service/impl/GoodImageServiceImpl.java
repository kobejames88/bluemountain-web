package com.bluemountain.modules.good.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.good.dao.GoodImageDao;
import com.bluemountain.modules.good.entity.GoodImageEntity;
import com.bluemountain.modules.good.entity.view.GoodImageView;
import com.bluemountain.modules.good.entity.vo.GoodImageVO;
import com.bluemountain.modules.good.service.GoodImageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("goodImageService")
public class GoodImageServiceImpl extends ServiceImpl<GoodImageDao, GoodImageEntity> implements GoodImageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodImageEntity> page = this.selectPage(
                new Query<GoodImageEntity>(params).getPage(),
                new EntityWrapper<GoodImageEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public List<GoodImageVO> selectListVO(Wrapper<GoodImageEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoodImageVO selectVO( Wrapper<GoodImageEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GoodImageView> selectListView(Wrapper<GoodImageEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GoodImageView selectView(Wrapper<GoodImageEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
