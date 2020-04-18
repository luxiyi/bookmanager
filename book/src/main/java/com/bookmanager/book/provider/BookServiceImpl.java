package com.bookmanager.book.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.bookmanager.book.dao.BookMapper;
import com.bookmanager.pojo.Book;
import com.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: java类作用描述BookServiceImpl
 * @Author: lxy
 * @time: 2020/4/12 22:20
 */
@Component
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Book> findAllByIndex(int index, int count) {
        return bookMapper.findALLByIndex(index, count);

    }

    @Override
    public int findTotalPage() {
        int total = bookMapper.findTotalPage();
        int totalPage = total % 12 == 0 ? (total / 12) : (total / 12 + 1);
        return totalPage;
    }

    @Override
    public void insertBook(Book book) {
        bookMapper.insertBook(book);
    }

    @Override
    public Book findAllById(Book book) {
        return bookMapper.findAllById(book);
    }

    @Override
    public Book findBookById(int bid) {
        return bookMapper.findBookById(bid);
    }

    @Override
    public void deleteById(Book book) {
        bookMapper.deletById(book);
    }

    @Override
    public List<Book> findAllBook() {
        return bookMapper.findAllBook();
    }

    @Override
    public void updateById(Book book) {
        bookMapper.updateById(book);
    }

    @Override
    public List<Book> findlikeBook(String bname) {
        return bookMapper.findlikeBook(bname);
    }

    @Override
    public void updateComcount(int bid) {
        bookMapper.updateComcount(bid);
    }


}
