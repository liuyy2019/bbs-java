package com.yang.bbs.controller;

import com.yang.bbs.bean.Comment;
import com.yang.bbs.bean.User;
import com.yang.bbs.bean.dto.CommentReq;
import com.yang.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/6 21:29
 */
@RestController
@RequestMapping("/v1")
public class CommentController {

    @Autowired
    public CommentService commentService;

    /**
     * 查询评论列表
     * @return
     */
    @GetMapping("/comment/commentList")
    public List<Comment> userAll(){
        return commentService.selectAll();
    }

    /**
     * 动态的获取用户列表
     * @return
     */
    @PostMapping("/comment/comment/page")
    public List<Comment> userList(@RequestBody CommentReq commentReq){
        List<Comment> commentList = commentService.selectList(commentReq.getComment(),commentReq.getPage(),commentReq.getSize());
        return commentList;
    }

    /**
     * 根据id删除评论
     * @param id
     * @return
     */
    @DeleteMapping("/comment/id/{id}")
    public Boolean deleteUser(@PathVariable("id") Integer id){
        return commentService.deleteCommentById(id);
    }
    /**
     *  添加评论信息
     * @param comment
     * @return
     */
    @PostMapping("/comment/add")
    public Boolean addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    /**
     *  更新评论信息
     * @param comment
     * @return
     */
    @PutMapping("/comment/update")
    public Boolean updateComment(@RequestBody Comment comment) {
        return commentService.updateComment(comment);
    }
}
