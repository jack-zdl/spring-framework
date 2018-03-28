package com.spring.bean;

import java.lang.reflect.Method;

/**
 * 功能说明: 封装Action信息 <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/28 7:36<br>
 */

public class Handler {

    private Class<?> controllerClass;

    private Method actionMethod;

    public
    Handler(Class<?> controllerClass, Method actionMethod){
        this.controllerClass = controllerClass;
        this.actionMethod  =actionMethod;
    }

    public Class<?> getControllerClass(){
        return controllerClass;
    }

    public Method getActionMethod(){
        return actionMethod;
    }
}
