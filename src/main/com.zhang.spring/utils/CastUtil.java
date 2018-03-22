package utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 功能说明: 转型操作工具类<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/22 15:12<br>
 */

public final class CastUtil {

    /**
     * 转成String
     * @return
     */
    public static String castString(Object obj){
        return CastUtil.castString(obj,"");
    }

    public static String castString(Object obj,String defaultValue){
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    /**
     *
     * @param object
     * @return
     */
    public static int castInt(Object object){
        return CastUtil.castInt(object,0);
    }

    public static int castInt(Object obj,int defaultValue){
        int intValue = defaultValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtils.isNotEmpty(strValue)){
                try {
                    intValue = Integer.parseInt(strValue);
                }catch (NumberFormatException e){
                    intValue = defaultValue;
                }
            }
        }
        return intValue;
    }

    /**
     *
     * @return
     */
    public static boolean castBoolean(Object obj){
        return CastUtil.castBoolean(obj,false);
    }

    public static boolean castBoolean(Object obj,boolean defaultValue){
        boolean  booleanvalue = defaultValue;
        if(obj != null){
            booleanvalue =Boolean.parseBoolean(castString(obj));
        }
        return booleanvalue;
    }

}
