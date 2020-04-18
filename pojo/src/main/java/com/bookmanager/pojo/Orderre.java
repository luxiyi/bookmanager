package com.bookmanager.pojo;

import java.io.Serializable;
import java.util.Date;

public class Orderre implements Serializable {

    private static final long serialVersionUID = 1867309320518125607L;

    private Integer oid;

    private String luser;

    private String oname;

    private Integer ocount;

    private Integer bid;

    private Date rdate;

    private Integer flag;

    public Orderre() {
    }

    public Orderre(Integer oid, String luser, String oname, Integer ocount, Integer bid, Date rdate, Integer flag) {
        this.oid = oid;
        this.luser = luser;
        this.oname = oname;
        this.ocount = ocount;
        this.bid = bid;
        this.rdate = rdate;
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

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}