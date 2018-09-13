package com.bluemoutain.service;


import com.bluemoutain.po.TransferAccount;
import com.bluemoutain.utils.PageBean;

public interface TransferAccountService {

    int saveTF(TransferAccount account);

    TransferAccount find_by_id(Integer id);

    void updateTF(TransferAccount account);

    void deleteTF(Integer id);

    PageBean<TransferAccount> findByPage(Integer page, Integer rows, Integer status, String name, String sid, Integer type);


}
