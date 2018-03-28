package controller;

import annotation.Action;
import annotation.Controller;
import annotation.Inject;
import service.CustomerService;
import utils.Data;
import utils.Param;
import utils.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明: 处理客户请求，做一个controller<br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/22 10:32<br>
 */
@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @Action("get: /view")
    public View index(Param param){
        customerService.createCustomer(null);
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        return new View("index.jsp").addModel("customerList",list);
    }

    @Action("get: /data")
    public Data data(Param param){
        customerService.createCustomer(null);
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        return new Data(list);
    }




}
