package com.spring.helper;

import com.spring.ConfigConstant;
import com.spring.utils.PropsUtil;

import java.util.Properties;

/**
 * 功能说明: 来读取配置文件的参数<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/22 14:19<br>
 */

public final class ConfigHelper {
    private  static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 读取jdbc驱动
     * @return
     */
    public static String getJdbcDriver(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
    }

    public static String getJdbcUrl(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
    }

    public static String getJdbcUsername(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
    }

    public static String getJdbcPassword(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
    }

    public static String getAppBasePackage(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
    }

    public static String getAppJspPath(){
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH,"/WEB-INF/jsp/");
    }

    public static String getAppAssetPath(){
        return  PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH,"/asset/");
    }

}
