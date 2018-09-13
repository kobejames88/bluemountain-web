package com.bluemoutain.service;

import com.bluemoutain.po.SystemDomain;
import com.bluemoutain.po.ext.DomainCheckExtQuery;
import com.bluemoutain.utils.PageBean;

import java.util.List;

public interface SystemDomainService {

    SystemDomain findByDomain(String domain);

    int saveDomain(SystemDomain domain);

    void deleteById(Integer id);

    SystemDomain find_by_id(Integer id);

    void updateDomain(SystemDomain domain);

    PageBean<SystemDomain> findDomainByPage(Integer page, Integer rows, String domain);

    PageBean<SystemDomain> findDomainByPage2(Integer page, Integer rows, String domain, Integer status, Integer nature, String serach);

    List<SystemDomain> find_all();

    PageBean<DomainCheckExtQuery> findDomainByPage(Integer page, Integer rows, Integer pay_status, Integer pay_show_info, Integer pid, String serach);

}
