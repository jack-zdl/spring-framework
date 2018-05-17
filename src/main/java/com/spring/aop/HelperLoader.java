package com.spring.aop;

import com.spring.helper.BeanHelper;
import com.spring.helper.ClassHelper;
import com.spring.helper.ControllerHelper;
import com.spring.helper.IocHelper;
import com.spring.utils.ClassUtil;

/**
 * 功能说明:  加载相应的Helper 类 <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/17 19:45<br>
 * <br>
 */
public class HelperLoader {

    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls:classList){
            ClassUtil.loadClass(cls.getName(),true);
        }
    }
}
