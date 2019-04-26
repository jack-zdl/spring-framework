package com.spring.helper;

import com.spring.bean.Customer;
import com.spring.controller.CustomerController;
import com.spring.utils.ReflectionUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 功能说明: Bean的助理类<br>
 *          相当于Bean的容器
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
        //获取所有的类
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet){
            //根据类名来获得实例
            Object obj = ReflectionUtil.newInstance(beanClass);
            //将类名和实例放入map中，随时可以获取
            BEAN_MAP.put(beanClass,obj);
        }
        System.out.println("----------"+BEAN_MAP);
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

    /**
     * aop 专用
     * 设置bean的实例
     */
    public static void  setBean(Class<?> cls,Object object){
        // 错误
        String  a = "";
        BEAN_MAP.put(cls,object);
    }
}
