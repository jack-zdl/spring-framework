package com.spring.helper;

import com.spring.utils.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 功能说明: Bean的助理类<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/28 6:49<br>
 */

public final class BeanHelper {

    /**
     * 定义Bean的映射（用于存放Bean类与Bean实例的映射关系）
     */
    private static final Map<Class<?>,Object> BEAN_MAP = new HashMap<Class<?>,Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet){
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass,obj);
        }
    }

    /**
     * 获得Bean映射
     */
    public static Map<Class<?>, Object> getBeanMap(){
        return BEAN_MAP;
    }

    /**
     * 获得bean的实例
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> cls){
        if(!BEAN_MAP.containsKey(cls)){
            throw new RuntimeException("can not get bean by class: "+cls);
        }
        return (T)BEAN_MAP.get(cls);
    }
}
