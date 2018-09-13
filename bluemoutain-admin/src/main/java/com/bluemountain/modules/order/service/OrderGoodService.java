package com.bluemountain.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.modules.order.entity.OrderGoodEntity;

import java.util.Map;

/**
 * 
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-28 17:20:46
 */
public interface OrderGoodService extends IService<OrderGoodEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

