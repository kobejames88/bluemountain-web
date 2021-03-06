package com.bluemountain.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.modules.good.entity.GoodImageEntity;
import com.bluemountain.modules.good.entity.vo.GoodImageVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 商品图片表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
public interface GoodImageService extends IService<GoodImageEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoodImageVO> selectListVO(Wrapper<GoodImageEntity> wrapper);
   	
   	GoodImageVO selectVO(@Param("ew") Wrapper<GoodImageEntity> wrapper);
}

