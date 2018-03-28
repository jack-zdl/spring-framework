package com.spring.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能说明: json工具类 <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/28 10:50<br>
 */
public final class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> String toJson(T obj){
        String json;
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        }catch (Exception e){
            LOGGER.error("convert pojo to json failure",e);
            throw  new RuntimeException(e);
        }
        return json;
    }

    public static <T> T fromJson(String json,Class<T> type){
        T pojo;
        try {
            pojo = OBJECT_MAPPER.readValue(json,type);
        }catch (Exception e){
            LOGGER.error("convert json to pojo fauilure",e);
            throw new RuntimeException(e);
        }
        return pojo;
    }
}
