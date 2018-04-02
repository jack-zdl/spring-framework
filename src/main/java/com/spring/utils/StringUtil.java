package com.spring.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 功能说明: <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/22 15:43<br>
 */

public class StringUtil {
    public static boolean isEmpty(String str){
        if(str != null){
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String string){
        return !isEmpty(string);
    }

    public static String[] splitString(String s,String param){
        return s.split(param);
    }
}
