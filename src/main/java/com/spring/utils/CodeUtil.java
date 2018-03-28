package com.spring.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 功能说明: 编码和解码操作工具类<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/28 10:44<br>
 */

public final class CodeUtil {
    private static final Logger LOGGER  = LoggerFactory.getLogger(CodeUtil.class);

    /**
     * URL编码
     * @param source
     * @return
     */
    public static String encodeURL(String source){
        String target;
        try {
            target = URLEncoder.encode(source,"UTF-8");
        }catch (Exception e){
            LOGGER.error("encode url failure ",e);
            throw new RuntimeException(e);
        }
        return target;
    }
    /**
     * URL解码
     * @param source
     * @return
     */
    public static String decodeURL(String source){
        String target;
        try {
            target = URLDecoder.decode(source,"UTF-8");
        }catch (Exception e){
            LOGGER.error("decode url failure",e);
            throw new RuntimeException(e);
        }
        return target;
    }
}
