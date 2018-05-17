package com.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 功能说明:  切面代理类  <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/16 19:16<br>
 * <br>
 */
public abstract class AspectProxy implements Proxy{

    private static final Logger logger =  LoggerFactory.getLogger(AspectProxy.class);


    @Override
    public Object doProxy(ProxyChain proxyChina) throws Throwable {
        Object result = null;

        Class<?> cls = proxyChina.getTargetClass();
        Method method = proxyChina.getTargetMethod();
        Object[] params = proxyChina.getMethodParams();

        begin();

        try {
            if(intercept(cls,method,params)){
                before(cls,method,params);
                result = proxyChina.doProxyChain();
                after(cls,method,params,result);
            }else {
                result = proxyChina.doProxyChain();
            }
        }catch (Exception e){
            logger.error("proxy failure",e);
            error(cls,method,params,e);
            throw e;
        }finally {
            end();
        }
        return result;
    }

    public void begin(){

    }

    public boolean intercept(Class<?> cls,Method method,Object[] params) throws Throwable{
        return true;
    }

    public void before(Class<?> cls,Method method,Object[] params)throws Throwable{

    }

    public void after(Class<?> cls,Method method,Object[] params,Object result)throws Throwable{

    }

    public void error(Class<?> cls,Method method,Object[] params,Throwable e){

    }

    public void end(){

    }
}
