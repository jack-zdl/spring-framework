package utils;

import org.slf4j.LoggerFactory;

import java.util.Set;


/**
 * 功能说明: 自制的类加载器，加载一些某注解的类，或实现某接口的类<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/22 15:52<br>
 */

public class ClassUtil {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

    /**
     * 获取类加载器
     * 只需要获取当前线程的ClassLoader即可，
     * @return
     */
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 加载类
     * 加载类需要提供类名与是否初始化标识，这里初始化值是否执行类的静态代码块
     * @param calssName
     * @param isInitialized
     * @return
     */
    public static Class<?> loadClass(String calssName,boolean isInitialized){

    }

    /**
     * 获取指定包的所有类
     * @return
     */
    public static Set<Class<?>> getClassSet(){

    }

}
