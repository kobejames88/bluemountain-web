package com.bluemoutain.po.ext;



import com.bluemoutain.po.SysFunction;

import java.util.ArrayList;
import java.util.List;

public class SysFunctionExt extends SysFunction {

    private List<SysFunctionExt> sub_menu = new ArrayList<>();

    public List<SysFunctionExt> getSub_menu() {
        return sub_menu;
    }

    public void setSub_menu(List<SysFunctionExt> sub_menu) {
        this.sub_menu = sub_menu;
    }


}
