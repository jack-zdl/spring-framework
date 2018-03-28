package utils;

import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.PUBLIC_MEMBER;

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


    public static double castDouble(Object obj){
        return CastUtil.castDouble(obj,0);
    }

    public static double castDouble(Object obj, double defaultValue){
        double doubleValue = defaultValue;
        if(obj !=  null){
            String strValue = castString(obj);
            if(StringUtils.isNoneEmpty(strValue)){
                try {
                    doubleValue =Double.parseDouble(strValue);
                }catch (NumberFormatException e){
                    doubleValue = defaultValue;
                }
            }
        }
        return defaultValue;
    }

    public static long castLong(Object obj){
        return CastUtil.castLong(obj,0);
    }

    public static long castLong(Object obj,long defaultValue){
        long longValue = defaultValue;
        if(obj != null){
            String strValue = castString(obj);
            if(StringUtils.isNoneEmpty(strValue)){
                try {
                    longValue = Long.parseLong(strValue);
                }catch (NumberFormatException e){
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
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
