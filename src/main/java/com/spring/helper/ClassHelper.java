package com.spring.helper;


import com.spring.annotation.Controller;
import com.spring.annotation.Service;
import com.spring.utils.ClassUtil;
import java.util.HashSet;
import java.util.Set;

/**
 * 功能说明: 在这个类中增加获取应用包的所有Bean类的方法<br>
 *          来获取应用包下的所有类，所有service类，应用宝下的ClassHelper助手类 <br>
 *              我们使用ClassHelper类来封装ClassUtil,并提供一些助手方法直接获取我们想要的类集合。
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/22 21:01<br>
 */

public final class ClassHelper {

    /**
     * 定义类集合（用于存放所加载的类）
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包下的所有类
     * @return
     */
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }

    /**
     * 获取应用包下的所有service类
     * @return
     */
    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET){
            if(cls.isAnnotationPresent(Service.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }
    /**
     * 获取应用包下的所有Controller类
     * @return
     */
    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET){
            if(cls.isAnnotationPresent(Controller.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 返回应用包下的所有bean类
     * @return
     */
    public static Set<Class<?>> getBeanClassSet(){
       Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
       beanClassSet.addAll(getControllerClassSet());
       beanClassSet.addAll(getServiceClassSet());
        return beanClassSet;
    }
}
