package com.bookmanager.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private Integer uid;

    private String luser;

    private String uname;

    private String phone;

    private String age;

    private String sex;

    private String addr;

    private String usericon;

    private Integer flag;

    public User() {
    }

    public User(Integer uid, String luser, String uname, String phone, String age, String sex, String addr, String usericon, Integer flag) {
        this.uid = uid;
        this.luser = luser;
        this.uname = uname;
        this.phone = phone;
        this.age = age;
        this.sex = sex;
        this.addr = addr;
        this.usericon = usericon;
        this.flag = flag;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getLuser() {
        return luser;
    }

    public void setLuser(String luser) {
        this.luser = luser;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getUsericon() {
        return usericon;
    }

    public void setUsericon(String usericon) {
        this.usericon = usericon;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}