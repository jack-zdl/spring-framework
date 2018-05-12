package com.spring;

import com.spring.helper.BeanHelper;
import com.spring.helper.ControllerHelper;
import com.spring.utils.ClassUtil;
import com.spring.helper.ClassHelper;
import com.spring.helper.IocHelper;

/**
 * 功能说明: 加载相应的Helper<br>
 *           初始化框架<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/28 9:54<br>
 */

public final class HelperLoader {
    /**
     * 这里修改了原先的代码
     *  ClassUtil.loadClass(cls.getName(),true);
     *   ClassUtil.loadClass(cls.getName());
     */
    public static void  init(){
        Class<?>[] classesList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };

        for (Class cls : classesList){
            ClassUtil.loadClass(cls.getName());
        }
    }
}
