package com.bluemoutain.service;


import com.bluemoutain.po.SystemConfigWithBLOBs;

public interface UserConfigService {

    SystemConfigWithBLOBs findConfigByUid(Integer uid);

    void updateVonfig(SystemConfigWithBLOBs config);

    SystemConfigWithBLOBs findConfigByid(Integer id);

    void deleteById(Integer id);

    void deleteByUid(Integer uid);

}
