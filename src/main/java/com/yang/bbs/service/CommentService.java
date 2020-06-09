package com.yang.bbs.service;

import com.yang.bbs.bean.Comment;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/27 18:01
 */
public interface CommentService {
    /**
     * 获取所有的评论
     * @return
     */
    List<Comment> selectAll();

    /**
     * 动态获取评论信息，支持分页
     * @param comment
     * @param page
     * @param size
     * @return
     */
    List<Comment> selectList(Comment comment,Integer page,Integer size);

    /**
     * 根据id删除评论信息
     * @param id
     * @return
     */
    Boolean deleteCommentById(Integer id);

    /**
     *
     * @param id
     * @return
     */
    Comment getCommentById(Integer id);

    Boolean addComment(Comment comment);

    Boolean updateComment(Comment comment);
}
