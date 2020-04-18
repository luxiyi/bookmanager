package com.bookmanager.pojo;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private static final long serialVersionUID = 620421603359868704L;

    private Integer oid;

    private String luser;

    private String oname;

    private Integer ocount;

    private Integer bid;

    private Date bdate;

    private Integer flag;

    public Order() {
    }

    public Order(Integer oid, String luser, String oname, Integer ocount, Integer bid, Date bdate, Integer flag) {
        this.oid = oid;
        this.luser = luser;
        this.oname = oname;
        this.ocount = ocount;
        this.bid = bid;
        this.bdate = bdate;
        this.flag = flag;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getLuser() {
        return luser;
    }

    public void setLuser(String luser) {
        this.luser = luser;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public Integer getOcount() {
        return ocount;
    }

    public void setOcount(Integer ocount) {
        this.ocount = ocount;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}