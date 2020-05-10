package com.bookmanager.book.provider;

import com.bookmanager.book.dao.BorrowMapper;
import com.bookmanager.pojo.Order;
import com.bookmanager.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: java类作用描述BorrowService
 * @Author: lxy
 * @time: 2020/4/16 0:21
 */
@Component
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowMapper borrowMapper;

    @Override
    public List<Order> findAllOrder(String luser) {
        return borrowMapper.findAllOrder(luser);
    }

    @Override
    public void addOrder(String luser, String oname, int ocount, int bid) {
        borrowMapper.addOrder(luser, oname, ocount, bid);
    }
}
