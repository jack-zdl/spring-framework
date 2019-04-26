package com.spring.bean;


import com.spring.utils.CastUtil;

import java.util.Map;

/**
 * 功能说明: 请求参数对象<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/28 9:59<br>
 */

public class Param {
    private Map<String,Object> paramMap;

    /**
     * 根据参数名获得long类型参数值
     * @param paramMap
     */
    public Param(Map<String,Object> paramMap){
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获得long类型参数值
     * @param name
     * @return
     */
    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }

//    public Map<String,Object> getMap(){
//        return paramMap;
//    }




}
