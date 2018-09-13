package com.bluemoutain.plugins.ueditor.define;

/**
 * 处理状态接口
 *
 * @author hancong03@ueditor.com
 */
public interface State {

    boolean isSuccess();

    void putInfo(String name, String val);

    void putInfo(String name, long val);

    String toJSONString();

}
