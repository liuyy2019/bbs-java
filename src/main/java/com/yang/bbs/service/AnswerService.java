package com.yang.bbs.service;

import com.yang.bbs.bean.Answer;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/19 21:40
 */
public interface AnswerService {
    /**
     * 获取所有的问答列表
     * @return
     */
    List<Answer> getAllAnswers();

    /**
     * 分页动态的获取问答列表
     * @param answer
     * @param page
     * @param size
     * @return
     */
    List<Answer> selectList(Answer answer, Integer page, Integer size);

    Boolean deleteUserById(Integer id);

    Boolean addAnswer(Answer answer);

    Boolean updateAnswer(Answer answer);
}
