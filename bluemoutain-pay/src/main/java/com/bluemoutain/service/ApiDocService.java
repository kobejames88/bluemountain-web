package com.bluemoutain.service;


import com.bluemoutain.po.SystemDoc;
import com.bluemoutain.utils.PageBean;

import java.util.List;

public interface ApiDocService {

    void saveDocs(SystemDoc doc);

    SystemDoc findDocById(Integer id);

    void updateDocById(SystemDoc doc);

    void deleteDocById(Integer id);

    PageBean<SystemDoc> findDocByPage(Integer page, Integer rows, Integer status);

    List<SystemDoc> findAllDisplayDoc(Integer status);
}
