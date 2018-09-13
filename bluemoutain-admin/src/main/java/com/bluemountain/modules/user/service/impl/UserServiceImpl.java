package com.bluemountain.modules.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.user.dao.UserDao;
import com.bluemountain.modules.user.entity.UserEntity;
import com.bluemountain.modules.user.entity.model.UserModel;
import com.bluemountain.modules.user.entity.view.UserView;
import com.bluemountain.modules.user.entity.vo.UserVO;
import com.bluemountain.modules.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserEntity> page = this.selectPage(
                new Query<UserEntity>(params).getPage(),
                new EntityWrapper<UserEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
    public PageUtils queryPage(Map<String, Object> params, UserModel userModel) {
    	 
     	EntityWrapper ew =new EntityWrapper<UserEntity>();
     	Map<String, Object> map = BeanUtil.beanToMap(userModel, true, true);
     	map.forEach((k,v)->{
      		ew.like(k, v.toString());
     	});
          Page<UserEntity> page = this.selectPage(
                new Query<UserEntity>(params).getPage(),
               ew
        );

        return new PageUtils(page);
    }
	public PageUtils queryPage(Map<String, Object> params, Wrapper<UserEntity> wrapper) {
		  Page<UserView> page =new Query<UserView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<UserVO> selectListVO(Wrapper<UserEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public UserVO selectVO( Wrapper<UserEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<UserView> selectListView(Wrapper<UserEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public UserView selectView(Wrapper<UserEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
