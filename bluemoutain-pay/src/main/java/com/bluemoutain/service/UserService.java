package com.bluemoutain.service;



import com.bluemoutain.po.SystemUser;
import com.bluemoutain.po.ext.SysUserExt;
import com.bluemoutain.utils.PageBean;

import java.util.List;

public interface UserService {

    SystemUser findUserByUserNameAndPassword(SystemUser user);

    int saveUser(SystemUser user) throws Exception;

    PageBean<SysUserExt> findByPage(Integer page, Integer rows, String user, Integer pid, Integer role, String email);

    SystemUser findUserById(Integer id);

    void updateUser(SystemUser user);

    void deleteUserById(Integer id);

    List<SystemUser> find_user_list();

    SystemUser findUserByEmail(String email);

    List<SystemUser> find_user_list2(Integer utype);

    SystemUser find_user_by_email(String email);
}
