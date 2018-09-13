package modules.good.service;

import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import modules.good.entity.GoodSpecPriceEntity;


import java.util.Map;

/**
 * 规格价格表
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-24 14:04:18
 */
public interface GoodSpecPriceService extends IService<GoodSpecPriceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

