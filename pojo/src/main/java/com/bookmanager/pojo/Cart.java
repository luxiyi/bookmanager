package com.bookmanager.pojo;

import java.io.Serializable;

/**
 * @Description: java类作用描述Cart
 * @Author: lxy
 * @time: 2020/4/6 21:39
 */
public class Cart implements Serializable {

    private static final long serialVersionUID = -33534807910933588L;

    private int bid;
    private String bname;
    private double price;
    private int count;
    private String img;

    public Cart() {
    }

    public Cart(int bid, String bname, double price, int count, String img) {
        this.bid = bid;
        this.bname = bname;
        this.price = price;
        this.count = count;
        this.img = img;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", img='" + img + '\'' +
                '}';
    }
}
