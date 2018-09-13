package com.bluemoutain.service;


import com.bluemoutain.po.SystemPayConfigWithBLOBs;

public interface PayConfigService {

    SystemPayConfigWithBLOBs getPayConfig(Integer id);

    void updatePPayConfig(SystemPayConfigWithBLOBs payConfig);
}
