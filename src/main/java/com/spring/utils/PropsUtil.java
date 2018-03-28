package com.spring.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 功能说明: 属性文件工具类<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/22 14:43<br>
 */

public final class PropsUtil {
    private static final Logger LOGGER =  LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     * @param fileName
     * @return
     */
    public static Properties loadProps(String fileName){
        Properties pros = null;
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(is == null){
                throw new FileNotFoundException(fileName+" file is not found");
            }
            pros = new Properties();
            pros.load(is);
        }catch (IOException e){
            LOGGER.error("load properties file failure",e);
        }finally {
            if(is != null){
                try {
                    is.close();
                }catch (IOException e){
                    LOGGER.error("close input stream failure",e);
                }
            }
        }
        return pros;
    }

    /**
     * 获取字符串属性（默认值为空字符串）
     * @param pros
     * @param keys
     * @return
     */
    public static String getString(Properties pros,String keys){
        return getString(pros,keys,"");
    }

    /**
     * 获取字符串属性（可指定默认值）
     * @return
     */
    public static String getString(Properties props,String key,String defaultValue){
        String value = defaultValue;
        if(props.containsKey(key)){
            value = props.getProperty(key);
        }
        return value;
    }

    /**
     * 获取数值型属性（默认值为0）
     * @param props
     * @param key
     * @return
     */
    public static int getInt(Properties props,String key){
        return getInt(props,key,0);
    }

    /**
     * 获取数值型属性（可指定默认值）
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getInt(Properties props,String key,int defaultValue){
        int value  = defaultValue;
        if(props.containsKey(key)){
            value = CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }

    /**
     * 获取布尔型属性（默认值为false）
     * @param props
     * @param key
     * @return
     */
    public static boolean getBoolean(Properties props,String key){
        return getBoolean(props,key,false);
    }

    /**
     *
     * @return
     */
    public static boolean getBoolean(Properties props,String key,Boolean defaultValue){
        boolean value  = defaultValue;
        if(props.containsKey(key)){
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }
}
