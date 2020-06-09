package com.yang.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.bbs.bean.Comment;
import com.yang.bbs.mapper.CommentMapper;
import com.yang.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/27 18:01
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> selectAll() {
        return commentMapper.selectAll();
    }

    @Override
    public List<Comment> selectList(Comment comment, Integer page, Integer size) {
        //设置分页的格式
        PageHelper.startPage(page,size);
        List<Comment> comments = commentMapper.selectList(comment);
        //对查询的所有结果进行分页处理
        PageInfo pageInfo = new PageInfo<>(comments);
        return pageInfo.getList();
    }

    @Override
    public Boolean deleteCommentById(Integer id) {
        return commentMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Comment getCommentById(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean addComment(Comment comment) {
        comment.setCreatetime(LocalDateTime.now());
        return commentMapper.insertSelective(comment)>0;
    }

    @Override
    public Boolean updateComment(Comment comment) {
        return commentMapper.updateByPrimaryKeySelective(comment)>0;
    }
}
