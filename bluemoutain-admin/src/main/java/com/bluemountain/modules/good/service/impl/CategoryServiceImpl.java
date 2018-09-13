package com.bluemountain.modules.good.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.good.dao.CategoryDao;
import com.bluemountain.modules.good.entity.CategoryEntity;
import com.bluemountain.modules.good.entity.view.CategoryView;
import com.bluemountain.modules.good.entity.vo.CategoryVO;
import com.bluemountain.modules.good.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CategoryEntity> page = this.selectPage(
                new Query<CategoryEntity>(params).getPage(),
                new EntityWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public List<CategoryVO> selectListVO( Wrapper<CategoryEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CategoryVO selectVO(Wrapper<CategoryEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<CategoryView> selectListView(Wrapper<CategoryEntity> wrapper) {
		// TODO Auto-generated method stub
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CategoryView selectView(Wrapper<CategoryEntity> wrapper) {
		// TODO Auto-generated method stub
		return baseMapper.selectView(wrapper);
	}

}
