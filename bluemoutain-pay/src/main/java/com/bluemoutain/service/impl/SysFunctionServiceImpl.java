package com.bluemoutain.service.impl;


import com.bluemoutain.mapper.SysFunctionMapper;
import com.bluemoutain.mapper.SysRoleFunctionMapper;
import com.bluemoutain.po.SysFunction;
import com.bluemoutain.po.SysFunctionExample;
import com.bluemoutain.po.SysRoleFunction;
import com.bluemoutain.po.SysRoleFunctionExample;
import com.bluemoutain.po.ext.SysFunctionExt;
import com.bluemoutain.service.SysFunctionService;
import com.bluemoutain.utils.BeanCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class SysFunctionServiceImpl implements SysFunctionService {

    @Autowired
    private SysFunctionMapper functionMapper;

    @Autowired
    private SysRoleFunctionMapper roleFunctionMapper;

    @Override
    public SysFunction find_by_id(Integer id) {
        return functionMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysFunction saveFunction(SysFunction function) {
        SysFunctionExample example = new SysFunctionExample();
        SysFunctionExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(function.getParent());
        List<SysFunction> list = functionMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            SysFunction function1 = list.get(0);
            function1.setStatus(1);
            functionMapper.updateByPrimaryKey(function1);
            if (function.getParent() == null) {
                function.setParent(0);
            }
        }
        function.setOptTime(new Date());
        function.setStatus(0);
        functionMapper.insert(function);
        return function;
    }

    @Override
    public SysFunction updateFunction(SysFunction function) {
        SysFunction model = functionMapper.selectByPrimaryKey(function.getId());
        if (model != null) {
            Integer old_parent = model.getParent();
            Integer p_new = function.getParent();
            //保存自己
            BeanCheck.copyPropertiesIgnoreNull(function, model);
            model.setOptTime(new Date());
            functionMapper.updateByPrimaryKey(model);
            //修改原来的父级
            if (old_parent != null && old_parent > 0) {
                SysFunction tmp = this.find_by_id(old_parent);
                if (tmp != null) {
                    List<SysFunction> list = this.findByParentId(old_parent);
                    if (list != null && list.size() > 0) {
                        tmp.setStatus(1);
                    } else {
                        tmp.setStatus(0);
                    }
                    functionMapper.updateByPrimaryKey(tmp);
                }
            }
            //修改新的父级
            if (p_new != null && p_new > 0) {
                SysFunction tmp = this.find_by_id(p_new);
                if (tmp != null) {
                    List<SysFunction> list = this.findByParentId(p_new);
                    if (list != null && list.size() > 0) {
                        tmp.setStatus(1);
                    } else {
                        tmp.setStatus(0);
                    }
                    functionMapper.updateByPrimaryKey(tmp);
                }
            }
        }
        return function;
    }

    @Override
    public int delete_by_id(Integer id) {
        //删除它下面的
        SysFunctionExample example = new SysFunctionExample();
        SysFunctionExample.Criteria criteria = example.createCriteria();
        criteria.andParentEqualTo(id);
        functionMapper.deleteByExample(example);
        //查询有没有同伴
        SysFunction function = this.find_by_id(id);//获取它自己
        //删除它
        functionMapper.deleteByPrimaryKey(id);
        if (function.getParent() != 0) {
            SysFunction list = this.find_by_id(function.getParent());//找到它上级
            if (list != null) {
                SysFunction f1 = list;//它上级
                List<SysFunction> list1 = this.findByParentId(f1.getId());//找找有没有下面的
                if (list1 != null && list1.size() > 0) {
                    f1.setStatus(1);
                } else {
                    f1.setStatus(0);
                }
                functionMapper.updateByPrimaryKey(f1);
            }
        }
        return functionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SysFunction> findByParentId(Integer id) {
        SysFunctionExample example = new SysFunctionExample();
        SysFunctionExample.Criteria criteria = example.createCriteria();
        criteria.andParentEqualTo(id);
        return functionMapper.selectByExample(example);
    }

    @Override
    public List<SysFunction> findAllFunctions() {
        SysFunctionExample example = new SysFunctionExample();
        return functionMapper.selectByExample(example);
    }

    @Override
    public List<SysFunctionExt> findMenuByRoleId(Integer role_id) {
        //查找角色所有fun_id并封装成列表
        SysRoleFunctionExample example = new SysRoleFunctionExample();
        SysRoleFunctionExample.Criteria criteria2 = example.createCriteria();
        criteria2.andRoleIdEqualTo(role_id);
        List<SysRoleFunction> fids = roleFunctionMapper.selectByExample(example);
        ArrayList<Integer> fids2 = new ArrayList<>();
        for (SysRoleFunction fid : fids) {
            fids2.add(fid.getFunId());
        }
        //主菜单
        SysFunctionExample example1 = new SysFunctionExample();
        SysFunctionExample.Criteria criteria = example1.createCriteria();
        criteria.andParentEqualTo(0);
        criteria.andIsMenuEqualTo(1);
        criteria.andIdIn(fids2);
        List<SysFunction> sysFunctions = functionMapper.selectByExample(example1);
        ArrayList<SysFunctionExt> menus = new ArrayList<>();
        for (SysFunction function : sysFunctions) {
            SysFunctionExt ext = new SysFunctionExt();
            BeanCheck.copyPropertiesIgnoreNull(function, ext);
            menus.add(ext);
        }
        //子菜单
        for (SysFunction function : sysFunctions) {
            example1.clear();
            SysFunctionExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andParentEqualTo(function.getId());
            criteria1.andIsMenuEqualTo(1);
            criteria1.andIdIn(fids2);
            List<SysFunction> functions = functionMapper.selectByExample(example1);
            ArrayList<SysFunctionExt> sub_menus = new ArrayList<>();
            for (SysFunction fun : functions) {
                SysFunctionExt ext = new SysFunctionExt();
                BeanCheck.copyPropertiesIgnoreNull(fun, ext);
                sub_menus.add(ext);
            }
            for (SysFunctionExt menu : menus) {
                if (menu.getId().equals(function.getId())) {
                    menu.setSub_menu(sub_menus);
                }
            }
        }
        return menus;
    }

}
