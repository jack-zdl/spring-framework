package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能说明:返回视图对象 <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/28 10:13<br>
 */

public class View {
    private String path;

    private Map<String,Object> model;

    public View(String path){
        this.path = path;
        model = new HashMap<String,Object>();
    }

    public View addModel(String key,Object values){
        model.put(key,values);
        return this;
    }

    public String getPath(){
        return path;
    }

    public Map<String,Object> getModel(){
        return model;
    }
}
