package com.bookmanager.book.provider;

import com.bookmanager.book.dao.CommentMapper;
import com.bookmanager.pojo.Comment;
import com.bookmanager.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: java类作用描述CommentServiceImpl
 * @Author: lxy
 * @time: 2020/4/16 1:21
 */
@Component
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> allCommentsById(int bid) {
        return commentMapper.allCommentsById(bid);
    }

    @Override
    public void insertCommentByid(String luser, int bid, String ccont) {
        commentMapper.insertCommentByid(luser, bid, ccont);
    }
}
