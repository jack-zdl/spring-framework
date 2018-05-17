package com.spring.aop;

import com.spring.annotation.Aspect;
import com.spring.annotation.Controller;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 * 功能说明:   拦截Controller方法 <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/16 20:17<br>
 * <br>
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    private long begin;


    @Override
    public void before(Class<?> cls, Method method, Object[] params)throws Throwable{
        logger.debug("---------------------------");
        logger.debug(String.format("class: %s",cls.getName()));
        logger.debug(String.format("methd : %s",method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        logger.debug(String.format("time:%dms",System.currentTimeMillis()-begin));
        logger.debug("-----------------------------end");
    }
}
