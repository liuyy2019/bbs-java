package com.yang.bbs.controller;

import com.yang.bbs.bean.Answer;
import com.yang.bbs.bean.User;
import com.yang.bbs.bean.dto.AnswerReq;
import com.yang.bbs.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/19 21:45
 */
@RestController
@RequestMapping("/v1")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping("/answer/answerList")
    public List<Answer> getAllAnswer(){
        return answerService.getAllAnswers();
    }

    /**
     * 动态的获取用户列表,支持分页
     * @return
     */
    @PostMapping("/answer/answer/page")
    public List<Answer> answerList(@RequestBody AnswerReq answerReq){
        List<Answer> answerList = answerService.selectList(answerReq.getAnswer(),answerReq.getPage(),answerReq.getSize());
        return answerList;
    }
    /**
     * 根据id删除问答
     * @param id
     * @return
     */
    @DeleteMapping("/answer/{id}")
    public Boolean deleteUser(@PathVariable("id") Integer id){
        return answerService.deleteUserById(id);
    }

    /**
     *  添加用户
     * @param answer
     * @return
     */
    @PostMapping("/answer/add")
    public Boolean addAnswer(@RequestBody Answer answer) {
        return answerService.addAnswer(answer);
    }

    /**
     *  更新问答
     * @param answer
     * @return
     */
    @PutMapping("/answer/update")
    public Boolean updateUser(@RequestBody Answer answer) {
        return answerService.updateAnswer(answer);
    }
}
