package com.bluemoutain.service.impl;

import com.bluemoutain.mapper.SysFunctionMapper;
import com.bluemoutain.mapper.SysRoleFunctionMapper;
import com.bluemoutain.mapper.SysRoleMapper;
import com.bluemoutain.po.*;
import com.bluemoutain.po.ext.SysRoleExt;
import com.bluemoutain.service.SysRoleService;
import com.bluemoutain.utils.BeanCheck;
import com.bluemoutain.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysRoleFunctionMapper roleFunctionMapper;

    @Autowired
    private SysFunctionMapper functionMapper;

    @Override
    public SysRole findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysRole save(SysRole role, String menuIds) {
        role.setOptTime(new Date());
        roleMapper.insert(role);
        if (menuIds != null && menuIds.length() > 0) {
            String[] split = menuIds.split(",");
            for (String s : split) {
                SysFunction key = functionMapper.selectByPrimaryKey(Integer.parseInt(s));
                Integer parent = key.getParent();
                if (parent > 0) {
                    if (!ArrayUtils.contains(menuIds.split(","), String.valueOf(parent))) {
                        String s1 = String.valueOf(key.getParent());
                        menuIds += ",";
                        menuIds += s1;
                    }
                }
            }
            //  menuIds = menuIds.substring(0, menuIds.length() - 1);
            String[] split2 = menuIds.split(",");
            for (String s : split2) {
                SysRoleFunction function = new SysRoleFunction();
                function.setFunId(Integer.parseInt(s));
                function.setRoleId(role.getId());
                function.setOptTime(new Date());
                roleFunctionMapper.insert(function);
            }
        }
        return role;
    }


    @Override
    public SysRole update(SysRole role, String menuIds) {
        SysRole model = roleMapper.selectByPrimaryKey(role.getId());
        if (model != null) {
            SysRoleFunctionExample example = new SysRoleFunctionExample();
            SysRoleFunctionExample.Criteria criteria = example.createCriteria();
            criteria.andRoleIdEqualTo(model.getId());
            roleFunctionMapper.deleteByExample(example);
            if (menuIds != null && menuIds.length() > 0) {
                String[] split = menuIds.split(",");
                for (String s : split) {
                    SysFunction key = functionMapper.selectByPrimaryKey(Integer.parseInt(s));
                    Integer parent = key.getParent();
                    if (parent > 0) {
                        if (!ArrayUtils.contains(menuIds.split(","), String.valueOf(parent))) {
                            String s1 = String.valueOf(parent);
                            menuIds += ",";
                            menuIds += s1;
                        }
                    }
                }
                //    menuIds = menuIds.substring(0, menuIds.length() - 1);
                String[] split2 = menuIds.split(",");
                for (String s : split2) {
                    SysRoleFunction function = new SysRoleFunction();
                    function.setFunId(Integer.parseInt(s));
                    function.setRoleId(role.getId());
                    function.setOptTime(new Date());
                    roleFunctionMapper.insert(function);
                }
            }
            BeanCheck.copyPropertiesIgnoreNull(role, model);
            roleMapper.updateByPrimaryKey(model);
            return model;
        }
        return null;
    }

    @Override
    public int delete(Integer id) {
        SysRole model = roleMapper.selectByPrimaryKey(id);
        if (model != null) {
            SysRoleFunctionExample example = new SysRoleFunctionExample();
            SysRoleFunctionExample.Criteria criteria = example.createCriteria();
            criteria.andRoleIdEqualTo(model.getId());
            roleFunctionMapper.deleteByExample(example);
        }
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageBean<SysRole> findByPage(Integer pageNum, Integer rows) {
        PageBean<SysRole> bean;
        PageHelper.startPage(pageNum, rows);
        SysRoleExample example = new SysRoleExample();
        List<SysRole> roles = roleMapper.selectByExample(example);
        PageInfo<SysRole> info = new PageInfo<>(roles);
        bean = new PageBean<>(pageNum, rows, (int) info.getTotal());
        bean.setItems(roles);
        return bean;
    }

    @Override
    public Boolean roleIsHavingFunction(Integer id, Integer id1) {
        SysRoleFunctionExample example = new SysRoleFunctionExample();
        SysRoleFunctionExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(id);
        List<SysRoleFunction> list = roleFunctionMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            for (SysRoleFunction sysRoleFunctionKey : list) {
                if (sysRoleFunctionKey.getFunId().equals(id1)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<SysRole> findAllRoles() {
        SysRoleExample example = new SysRoleExample();
        return roleMapper.selectByExample(example);
    }

    @Override
    public SysRoleExt findAllFunctionByRole(Integer role_id) {
        SysRoleExt ext = new SysRoleExt();
        SysRole key = roleMapper.selectByPrimaryKey(role_id);
        BeanCheck.copyPropertiesIgnoreNull(key, ext);
        SysRoleFunctionExample example = new SysRoleFunctionExample();
        SysRoleFunctionExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(role_id);
        List<SysRoleFunction> sysRoleFunctionList = roleFunctionMapper.selectByExample(example);
        ArrayList<SysFunction> functions = new ArrayList<>();
        for (SysRoleFunction sysRoleFunction : sysRoleFunctionList) {
            SysFunction function = functionMapper.selectByPrimaryKey(sysRoleFunction.getFunId());
            functions.add(function);
        }
        ext.setFunctions(functions);
        return ext;
    }


}
