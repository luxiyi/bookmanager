package com.bookmanager.pojo;

import java.io.Serializable;

public class BookCart implements Serializable {

    private static final long serialVersionUID = -9129582613691429522L;

    private Integer cid;

    private String luser;

    private Integer bid;

    private Integer ccount;

    private Integer flag;

    public BookCart() {
    }

    public BookCart(String luser, int bid, int ccount) {
        this.luser = luser;
        this.bid = bid;
        this.ccount = ccount;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public Integer getCcount() {
        return ccount;
    }

    public void setCcount(Integer ccount) {
        this.ccount = ccount;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}