package com.bluemountain.modules.adverts.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.adverts.dao.AdvertsDetailDao;
import com.bluemountain.modules.adverts.entity.AdvertsDetailEntity;
import com.bluemountain.modules.adverts.entity.view.AdvertsDetailView;
import com.bluemountain.modules.adverts.entity.vo.AdvertsDetailVO;
import com.bluemountain.modules.adverts.service.AdvertsDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("advertsDetailService")
public class AdvertsDetailServiceImpl extends ServiceImpl<AdvertsDetailDao, AdvertsDetailEntity> implements AdvertsDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AdvertsDetailEntity> page = this.selectPage(
                new Query<AdvertsDetailEntity>(params).getPage(),
                new EntityWrapper<AdvertsDetailEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<AdvertsDetailEntity> wrapper) {
		  Page<AdvertsDetailView> page =new Query<AdvertsDetailView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<AdvertsDetailVO> selectListVO(Wrapper<AdvertsDetailEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public AdvertsDetailVO selectVO( Wrapper<AdvertsDetailEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<AdvertsDetailView> selectListView(Wrapper<AdvertsDetailEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AdvertsDetailView selectView(Wrapper<AdvertsDetailEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
