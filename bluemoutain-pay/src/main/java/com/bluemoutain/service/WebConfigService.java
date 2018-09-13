package com.bluemoutain.service;


import com.bluemoutain.po.SystemWebWithBLOBs;

public interface WebConfigService {

    SystemWebWithBLOBs find_by_id(Integer id);

    void update_web_config(SystemWebWithBLOBs webconfig);

}
