package modules.address.service;

import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import modules.address.entity.AddressEntity;


import java.util.Map;

/**
 * 
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-19 17:57:52
 */
public interface AddressService extends IService<AddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

