package com.spring.utils;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 功能说明: 数组工具类<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/28 7:28<br>
 */

public final class ArrayUtil {

    /**
     * 判断数组是否为空
     * @return
     */
    public static boolean isNotEmpty(Object[] array){
        return !ArrayUtils.isEmpty(array);
    }
    /**
     * 判断数组是否为空
     * @return
     */
    public static boolean isEmpty(Object[] array){
        return ArrayUtils.isEmpty(array);
    }
}
