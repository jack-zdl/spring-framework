package com.spring.aop;

/**
 * 功能说明:   代理接口 <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/15 21:17<br>
 * <br>
 */
public interface Proxy {

    /**
     * 执行链式代理
     * @param proxyChina
     * @return
     * @throws Throwable
     */
    Object doProxy (ProxyChain proxyChina) throws Throwable;
}
