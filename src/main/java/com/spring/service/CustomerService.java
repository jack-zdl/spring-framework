package com.spring.service;

import com.spring.annotation.Service;
import com.spring.annotation.Transaction;
import com.spring.bean.Customer;
import com.spring.transaction.DatabaseHelper;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CORBA.portable.ValueOutputStream;

import java.util.List;
import java.util.Map;

/**
 * 功能说明: <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间: 2018/3/28 10:59<br>
 */
@Service
public class CustomerService {

   private int testId;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    @Transaction
    public void createCustomer(Map<String,Object> fieldMap){
         DatabaseHelper.insertEntity();
    }
}
