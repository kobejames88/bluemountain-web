package com.bluemountain.modules.good.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.bluemountain.modules.good.entity.GoodImageEntity;
import com.bluemountain.modules.good.entity.vo.GoodImageVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品图片表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
public interface GoodImageDao extends BaseMapper<GoodImageEntity> {
	
	List<GoodImageVO> selectListVO(@Param("ew") Wrapper<GoodImageEntity> wrapper);
	
	GoodImageVO selectVO(@Param("ew") Wrapper<GoodImageEntity> wrapper);
}
