package com.bluemoutain.service;


import com.bluemoutain.po.SystemVip;

public interface VipService {

    SystemVip find_vip_by_id(Integer id);

    SystemVip find_vip_by_uid(Integer uid);

    Integer save_vip_info(SystemVip vip);

    Integer update_vip_info(SystemVip vip);

}
