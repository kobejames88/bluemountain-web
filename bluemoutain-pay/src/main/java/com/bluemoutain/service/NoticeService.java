package com.bluemoutain.service;



import com.bluemoutain.po.SystemNotice;
import com.bluemoutain.utils.PageBean;

import java.util.List;

public interface NoticeService {

    int saveNotice(SystemNotice notice);

    SystemNotice findById(Integer id);

    int updateNotice(SystemNotice notice);

    void deleteNotice(Integer id);

    PageBean<SystemNotice> findNoticeByPage(Integer page, Integer rows, Integer status);

    List<SystemNotice> findDisplayNotices();


}
