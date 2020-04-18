package com.bookmanager.pojo;

import java.io.Serializable;

public class Book implements Serializable {

    private static final long serialVersionUID = -1229668087587325869L;

    private Integer bid;

    private String bname;

    private String author;

    private Double price;

    private Integer bcount;

    private String pubdate;

    private String press;

    private String img;

    private String intro;

    private Integer comcount;

    private Integer flag;

    public Book() {
    }

    public Book(int bid, String bname, String author, double price, int bcount, String pubdate, String press, String intro, int comcount, int flag) {
        this.bid = bid;
        this.bname = bname;
        this.author = author;
        this.price = price;
        this.bcount = bcount;
        this.pubdate = pubdate;
        this.press = press;
        this.intro = intro;
        this.comcount = comcount;
        this.flag = flag;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getBcount() {
        return bcount;
    }

    public void setBcount(Integer bcount) {
        this.bcount = bcount;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getComcount() {
        return comcount;
    }

    public void setComcount(Integer comcount) {
        this.comcount = comcount;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}