package com.bluemoutain.service;



import com.bluemoutain.po.PutForward;
import com.bluemoutain.po.PutForwardConfig;
import com.bluemoutain.utils.PageBean;

import java.util.List;

public interface PutForwardService {

    int savePF(PutForward forward);

    PutForward find_by_id(Integer id);

    void updatePF(PutForward account);

    void deletePF(Integer id);

    PageBean<PutForward> findByPage(Integer page, Integer rows, Integer status, String name, String sid, Integer type);

    PutForwardConfig findConfig(Integer id);

    void updateConfig(PutForwardConfig config);

    List<PutForward> find_by_status(Integer status);


}
