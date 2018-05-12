package com.spring;

import com.spring.bean.Data;
import com.spring.bean.Handler;
import com.spring.bean.Param;
import com.spring.bean.View;
import com.spring.helper.BeanHelper;
import com.spring.helper.ConfigHelper;
import com.spring.helper.ControllerHelper;
import com.spring.utils.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 功能说明: 模拟spring的DispathcherServlet<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/28 10:23<br>
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispathcharServlet extends HttpServlet{

    @Override
    public void init(ServletConfig servletConfig) throws ServletException{
        //初始化框架
        HelperLoader.init();

        ServletContext servletContext = servletConfig.getServletContext();
        //注册JSP的Servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + ".*");
        //注册处理静态资源的Servlet
        ServletRegistration defaultServlet  = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath()+"*");

    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        //获取请求方法
        String requestMethod = request.getMethod().toLowerCase(Locale.ENGLISH);

        String requestPath = request.getPathInfo();
        //调用HandlerMapping获得
        //该Handler配置的所有相关的对象（包括Handler对象以及Handler对象对应的拦截器），最后以HandlerExecutionChain
        //对象的形式返回；
        //获取处理处理这个请求的handler
        Handler handler = ControllerHelper.getHandler(requestMethod,requestPath);

        if(handler != null){
            //
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass.getName());

            // 创建请求参数对象,并获得参数
            Map<String,Object> paramMap = new HashMap<String,Object>();
            Enumeration<String> paramNames = request.getParameterNames();
            while (paramNames.hasMoreElements()){
                String paramName = paramNames.nextElement();
                String paramValue = request.getParameter(paramName);
                paramMap.put(paramName,paramValue);
            }

            String body = CodeUtil.decodeURL(StreamUtil.getString(request.getInputStream()));
            if(StringUtil.isNotEmpty(body)){
                String[] params = StringUtil.splitString(body,"&");
                if(ArrayUtil.isNotEmpty(params)){
                    for(String param : params){
                        String[] array = StringUtil.splitString(param,"=");
                        if(ArrayUtil.isNotEmpty(array) && array.length == 2){
                            String paramName = array[0];
                            String paramValue = array[1];
                            paramMap.put(paramName,paramValue);
                        }
                    }
                }
            }
            Param param = new Param(paramMap);
            /**--------------------传递参数-----------------------------------**/
            Method actionMethod = handler.getActionMethod();
            Object result = ReflectionUtil.invokeMethod(controllerBean,actionMethod,param);
            if(result instanceof View){
                View view = (View) result;
                String path = view.getPath();
                if(StringUtil.isNotEmpty(path)){
                    if(path.startsWith("/")){
                        response.sendRedirect(request.getContextPath() + path);
                    }else {
                        Map<String,Object> model = view.getModel();
                        for(Map.Entry<String,Object>entry:model.entrySet()){
                            request.setAttribute(entry.getKey(),entry.getValue());
                        }
                        request.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(request,response);
                    }
                }
            }else if(result instanceof Data){
                Data data = (Data) result;
                Object model = data.getModel();
                if(model != null){
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter writer = response.getWriter();
                    String json = JsonUtil.toJson(model);
                    writer.write(json);
                    writer.flush();
                    writer.close();
                }
            }
        }
    }
}
