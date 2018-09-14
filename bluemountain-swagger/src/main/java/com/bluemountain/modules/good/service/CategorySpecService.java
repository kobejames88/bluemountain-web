package com.bluemountain.modules.good.service;

import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.modules.good.entity.CategorySpecEntity;

import java.util.Map;

/**
 * 
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-23 10:29:33
 */
public interface CategorySpecService extends IService<CategorySpecEntity> {
    PageUtils queryPage(Map<String, Object> params);
}

