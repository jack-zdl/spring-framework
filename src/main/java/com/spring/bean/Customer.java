package com.spring.bean;

/**
 * 功能说明:    <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/21 20:18<br>
 * <br>
 */
public class Customer {

    private int id;

    private String name;

    private String contact;

    private String telephone;

    private String email;

    private String remark;

    public int getId() {
        return id;
    }

    public Customer setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public Customer setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public Customer setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public Customer setRemark(String remark) {
        this.remark = remark;
        return this;
    }
}
