package modules.good.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.good.dao.GoodDetailDao;
import com.freeter.modules.good.entity.GoodDetailEntity;
import com.freeter.modules.good.entity.vo.GoodDetailVO;
import com.freeter.modules.good.service.GoodDetailService;
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
	public List<GoodDetailVO> selectListVO( Wrapper<GoodDetailEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoodDetailVO selectVO( Wrapper<GoodDetailEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

}
