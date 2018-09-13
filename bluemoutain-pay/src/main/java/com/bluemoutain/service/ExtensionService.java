package com.bluemoutain.service;



import com.bluemoutain.po.SysExtension;
import com.bluemoutain.utils.PageBean;

import java.math.BigDecimal;

public interface ExtensionService {

    /**
     * 统计用户推广所得
     */
    BigDecimal cout_exten_by_uid(Integer status, Integer uid);

    /**
     * 统计用户推广人数
     */
    Integer count_exten_by_uid(Integer status, Integer uid);

    /**
     * 保存新的返利信息
     */
    void save_exten(SysExtension extension);

    PageBean<SysExtension> find_by_page(Integer page, Integer rows, Integer e_uid, Integer r_id, Integer id, Integer status);

    void delete(Integer id);

    SysExtension find_by_id(Integer id);

    void update(SysExtension extension);

}
