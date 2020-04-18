package com.bookmanager.cart.provider;

import com.bookmanager.cart.dao.CartMapper;
import com.bookmanager.pojo.Book;
import com.bookmanager.pojo.Cart;
import com.bookmanager.pojo.LoginUser;
import com.bookmanager.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: java类作用描述CartServiceImpl
 * @Author: lxy
 * @time: 2020/4/16 0:35
 */
@Component
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Override
    public List<Cart> allCartByLuser(LoginUser user) {
        return cartMapper.allCartByLuser(user);
    }

    @Override
    public void addCart(String luser,int bid,int ccount) {
        cartMapper.addCart(luser,bid,ccount);
    }

    @Override
    public void updateCart(LoginUser user) {
        cartMapper.updateCart(user);
    }
    @Override
    public Cart findCarByBid(Book book) {
        return cartMapper.findCarByBid(book);
    }


    @Override
    public void upCartCount(String luser,int bid) {
        cartMapper.upCartCount(luser,bid);
    }

    @Override
    public Cart oneCartBybid(String luser,int bid) {
        return cartMapper.oneCartBybid(luser,bid);
    }

    @Override
    public void reBookCount(int count, int bid) {
        cartMapper.reBookCount(count, bid);
    }

    @Override
    public int bookcountByBid(int bid) {
        return cartMapper.bookcountByBid(bid);
    }

    @Override
    public void recartcountById(int bid) {
        cartMapper.recartcountById(bid);
    }

    @Override
    public void decartById(int bid) {
        cartMapper.decartById(bid);
    }

    @Override
    public void addbookcountById(int bid) {
        cartMapper.addbookcountById(bid);
    }

    @Override
    public int cartccountByBid(String luser, int bid) {
        return cartMapper.cartccountByBid(luser, bid);
    }
}
