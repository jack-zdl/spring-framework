package com.spring.transaction;

import com.spring.annotation.Transaction;
import com.spring.aop.Proxy;
import com.spring.aop.ProxyChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 功能说明:  事务代理  <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/21 20:30<br>
 * <br>
 */
public class TransactionProxy implements Proxy {

    private static final Logger  LOGGER = LoggerFactory.getLogger(TransactionProxy.class);

    private static final ThreadLocal<Boolean> FLAG_HOLDER = new ThreadLocal<Boolean>(){
        @Override
        protected Boolean initialValue(){
            return false;
        }
    };

    @Override
    public Object doProxy(ProxyChain proxyChina) throws Throwable {
        Object result = null;
        boolean flag = FLAG_HOLDER.get();
        Method method = proxyChina.getTargetMethod();
        if (!flag && method.isAnnotationPresent(Transaction.class)){
            FLAG_HOLDER.set(true);
            try {
                DatabaseHelper.beginTransaction();
                LOGGER.debug("degin transaction");
                result = proxyChina.doProxyChain();
                DatabaseHelper.commitTransaction();
                LOGGER.debug("commit transaction");
            }catch (Exception e){
                DatabaseHelper.rollbackTransaction();
                LOGGER.error("rollabck");
            }finally {
                FLAG_HOLDER.remove();
            }
        }else {
            result = proxyChina.doProxyChain();
        }
        return result;
    }
}
