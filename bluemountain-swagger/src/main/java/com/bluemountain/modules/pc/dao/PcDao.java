package modules.pc.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import modules.pc.entity.PcEntity;
import modules.pc.entity.view.PcView;
import modules.pc.entity.vo.PcVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 14:56:33
 */
public interface PcDao extends BaseMapper<PcEntity> {
	
	List<PcVO> selectListVO(@Param("ew") Wrapper<PcEntity> wrapper);
	
	PcVO selectVO(@Param("ew") Wrapper<PcEntity> wrapper);
	
	
	List<PcView> selectListView(@Param("ew") Wrapper<PcEntity> wrapper);

	List<PcView> selectListView(Pagination page, @Param("ew") Wrapper<PcEntity> wrapper);
	
	PcView selectView(@Param("ew") Wrapper<PcEntity> wrapper);
}
