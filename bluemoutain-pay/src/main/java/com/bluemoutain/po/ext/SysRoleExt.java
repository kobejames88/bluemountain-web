package com.bluemoutain.po.ext;



import com.bluemoutain.po.SysFunction;
import com.bluemoutain.po.SysRole;

import java.util.ArrayList;
import java.util.List;

public class SysRoleExt extends SysRole {

    private List<SysFunction> functions = new ArrayList<>();

    public List<SysFunction> getFunctions() {
        return functions;
    }

    public void setFunctions(List<SysFunction> functions) {
        this.functions = functions;
    }

}
