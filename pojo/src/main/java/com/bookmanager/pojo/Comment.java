package com.bookmanager.pojo;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {

    private static final long serialVersionUID = -3674205491304011273L;

    private Integer coid;

    private String luser;

    private Integer bid;

    private String ccont;

    private Date cdate;

    private Integer flag;

    public Comment() {
    }

    public Comment(Integer coid, String luser, Integer bid, String ccont, Date cdate, Integer flag) {
        this.coid = coid;
        this.luser = luser;
        this.bid = bid;
        this.ccont = ccont;
        this.cdate = cdate;
        this.flag = flag;
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public String getLuser() {
        return luser;
    }

    public void setLuser(String luser) {
        this.luser = luser;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getCcont() {
        return ccont;
    }

    public void setCcont(String ccont) {
        this.ccont = ccont;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}