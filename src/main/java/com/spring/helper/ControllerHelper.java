package com.spring.helper;


import com.spring.annotation.Action;
import com.spring.bean.Handler;
import com.spring.bean.Request;
import com.spring.utils.ArrayUtil;
import com.spring.utils.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 功能说明: 控制器助手类<br>
 *      错误之处，这个类不应该时final型
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/28 7:40<br>
 */

public  class ControllerHelper{

    /**
     * 用于存放请求和处理器的映射关系
     */
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request,Handler>();

    static {
        //获得所有的controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if(CollectionUtil.isNotEmpty(controllerClassSet)){
            //遍历这些Controller类
            for(Class<?> controllerClass : controllerClassSet){
                // 获得Controller所有的方法
                Method[] methods = controllerClass.getDeclaredMethods();
                if(ArrayUtil.isNotEmpty(methods)){
                    for (Method method : methods){
                        if(method.isAnnotationPresent(Action.class)){
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            if(mapping.matches("\\w+:/\\w*")){
                                String[] array = mapping.split(":");
                                if(ArrayUtil.isNotEmpty(array) && array.length ==2){
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod,requestPath);
                                    Handler handler = new Handler(controllerClass,method);
                                    ACTION_MAP.put(request,handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取handler
     * @param requestMethod
     * @param requestPath
     * @return
     */
    public static Handler getHandler(String requestMethod,String requestPath){
        Request request = new Request(requestMethod,requestPath);
        return ACTION_MAP.get(request);
    }
}
