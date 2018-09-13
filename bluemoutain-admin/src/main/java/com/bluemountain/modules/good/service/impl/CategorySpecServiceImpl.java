package com.bluemountain.modules.good.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.good.dao.CategorySpecDao;
import com.bluemountain.modules.good.entity.CategorySpecEntity;
import com.bluemountain.modules.good.entity.view.CategorySpecView;
import com.bluemountain.modules.good.entity.vo.CategorySpecVO;
import com.bluemountain.modules.good.service.CategorySpecService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("categorySpecService")
public class CategorySpecServiceImpl extends ServiceImpl<CategorySpecDao, CategorySpecEntity> implements CategorySpecService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CategorySpecEntity> page = this.selectPage(
                new Query<CategorySpecEntity>(params).getPage(),
                new EntityWrapper<CategorySpecEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
    public  Page<CategorySpecView> queryPageCategorySpecView(Map<String, Object> params, Wrapper<CategorySpecEntity> wrapper) {
         
    	  Page<CategorySpecView> page =new Query<CategorySpecView>(params).getPage();
        return page.setRecords(baseMapper.selectListView(page,wrapper));
    }
    
    @Override
	public List<CategorySpecVO> selectListVO(Wrapper<CategorySpecEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CategorySpecVO selectVO( Wrapper<CategorySpecEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CategorySpecView> selectListView(Wrapper<CategorySpecEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CategorySpecView selectView(Wrapper<CategorySpecEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
