package com.spring.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 功能说明:封装请求信息 <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/28 7:32<br>
 */

public class Request {

    private String requestMethod;

    private String requestPath;

    public
    Request(String requestMethod, String requestPath){
            this.requestMethod = requestMethod;
            this.requestPath = requestPath;
    }

    public String getRequestMethod(){
        return requestMethod;
    }

    public String getRequestPath(){
        return requestPath;
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public  boolean equals(Object obj){
        return EqualsBuilder.reflectionEquals(this,obj);
    }
}
