package com.spring.bean;

/**
 * 功能说明: 返回数据对象<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/28 10:21<br>
 */

public class Data {
    private Object model;

    public
    Data(Object model){
        this.model = model;
    }

    public Object getModel(){
        return model;
    }
}
