package com.bluemoutain.service.impl;

import com.bluemoutain.mapper.SysRoleMapper;
import com.bluemoutain.mapper.SystemConfigMapper;
import com.bluemoutain.mapper.SystemUserMapper;
import com.bluemoutain.mapper.SystemWebMapper;
import com.bluemoutain.po.*;
import com.bluemoutain.po.ext.SysUserExt;
import com.bluemoutain.service.UserService;
import com.bluemoutain.utils.Base64;
import com.bluemoutain.utils.BeanCheck;
import com.bluemoutain.utils.MD5Util;
import com.bluemoutain.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private SystemUserMapper userMapper;

    @Autowired
    private SystemConfigMapper configMapper;

    @Autowired
    private SystemWebMapper webMapper;

    @Autowired
    private SysRoleMapper roleMapper;


    @Override
    public SystemUser findUserByUserNameAndPassword(SystemUser user) {
        SystemUserExample example = new SystemUserExample();
        SystemUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserEqualTo(user.getUser());
        criteria.andIsLockedEqualTo(2);
        List<SystemUser> users = userMapper.selectByExample(example);
        if (users != null && users.size() > 0) {
            SystemUser systemUser = users.get(0);
            String pwd = systemUser.getPwd();
            systemUser.setPwd(MD5Util.MD5Encode(pwd, "utf-8"));
            return systemUser;
        }
        return null;
    }

    @Override
    public int saveUser(SystemUser user) throws Exception {
        SystemWeb web = webMapper.selectByPrimaryKey(1);
        String str = UUID.randomUUID().toString() + UUID.randomUUID().toString();
        String s = Base64.encode(str.getBytes("utf-8"));
        user.setAppkey(s.substring(10, 42));
        user.setBalnes(new BigDecimal("0.00"));
        if (user.getZspaytype() == null) {
            user.setZspaytype(2);
        }
        if (user.getZsname() == null) {
            user.setZsname("请填写!");
        }
        if (user.getZspayid() == null) {
            user.setZspayid("请填写!");
        }
        user.setIsAutoSett(1);
        user.setIsLocked(2);
        userMapper.insert(user);
        Integer id = user.getId();
        SystemConfigWithBLOBs config = new SystemConfigWithBLOBs();
        config.setUid(id);
        config.setCopy("206云支付");
        config.setDescription("24小时在线收款系统");
        config.setKeywords("24小时在线收款系统");
        config.setLiuyan("谢谢合作!");
        config.setPanel("24小时在线收款系统");
        config.setGg("欢迎使用24小时在线收款系统.");
        config.setKfqq("000000000");
        config.setMusic("118.mp3");
        config.setYm(web.getHttpUrl());
        config.setSitename("XXX24小时在线收款系统");
        configMapper.insert(config);
        return id;
    }

    @Override
    public PageBean<SysUserExt> findByPage(Integer page, Integer rows, String user, Integer pid, Integer role, String email) {
        PageBean<SysUserExt> bean;
        PageHelper.startPage(page, rows);
        SystemUserExample example = new SystemUserExample();
        example.setOrderByClause("creste_time desc");
        SystemUserExample.Criteria criteria = example.createCriteria();
        if (user != null && user.length() > 0) {
            criteria.andUserLike("%" + user + "%");
        }
        if (pid != null) {
            criteria.andIdEqualTo(pid);
        }
        if (role != null && role != -1) {
            criteria.andRoleEqualTo(role);
        }
        if (email != null && email.length() > 2) {
            criteria.andEmailLike("%" + email + "%");
        }
        List<SystemUser> list = userMapper.selectByExample(example);
        PageInfo<SystemUser> info = new PageInfo<>(list);
        bean = new PageBean<>(page, rows, (int) info.getTotal());
        ArrayList<SysUserExt> objects = new ArrayList<>();
        for (SystemUser systemUser : list) {
            SysUserExt ext = new SysUserExt();
            BeanCheck.copyPropertiesIgnoreNull(systemUser, ext);
            SysRole sysRole = roleMapper.selectByPrimaryKey(ext.getRole());
            ext.setRoleName(sysRole.getRoleName());
            objects.add(ext);
        }
        bean.setItems(objects);
        return bean;
    }

    @Override
    public SystemUser findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }


    @Override
    public void updateUser(SystemUser user) {
        SystemUser model = userMapper.selectByPrimaryKey(user.getId());
        if (model != null) {
            BeanCheck.copyPropertiesIgnoreNull(user, model);
            userMapper.updateByPrimaryKey(model);
        }
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }


    @Override
    public List<SystemUser> find_user_list() {
        SystemUserExample example = new SystemUserExample();
        return userMapper.selectByExample(example);
    }

    @Override
    public SystemUser findUserByEmail(String email) {
        SystemUserExample example = new SystemUserExample();
        SystemUserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<SystemUser> systemUsers = userMapper.selectByExample(example);
        if (systemUsers != null && systemUsers.size() > 0) {
            return systemUsers.get(0);
        }
        return null;
    }

    @Override
    public List<SystemUser> find_user_list2(Integer utype) {
        SystemUserExample example = new SystemUserExample();
        SystemUserExample.Criteria criteria = example.createCriteria();
        if (utype != null) {
            criteria.andUserParentEqualTo(utype);
        }
        return userMapper.selectByExample(example);
    }

    @Override
    public SystemUser find_user_by_email(String email) {
        SystemUserExample example = new SystemUserExample();
        SystemUserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<SystemUser> users = userMapper.selectByExample(example);
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

}
