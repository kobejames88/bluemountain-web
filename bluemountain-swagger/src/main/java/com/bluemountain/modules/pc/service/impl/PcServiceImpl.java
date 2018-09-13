package modules.pc.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import modules.pc.dao.PcDao;
import modules.pc.entity.PcEntity;
import modules.pc.entity.view.PcView;
import modules.pc.entity.vo.PcVO;
import modules.pc.service.PcService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("pcService")
public class PcServiceImpl extends ServiceImpl<PcDao, PcEntity> implements PcService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PcEntity> page = this.selectPage(
                new Query<PcEntity>(params).getPage(),
                new EntityWrapper<PcEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PcEntity> wrapper) {
		  Page<PcView> page =new Query<PcView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<PcVO> selectListVO(Wrapper<PcEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PcVO selectVO( Wrapper<PcEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PcView> selectListView(Wrapper<PcEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PcView selectView(Wrapper<PcEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
