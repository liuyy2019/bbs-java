package com.yang.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.bbs.bean.Answer;
import com.yang.bbs.mapper.AnswerMapper;
import com.yang.bbs.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/19 21:41
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public List<Answer> getAllAnswers() {
        return answerMapper.selectAll();
    }

    @Override
    public List<Answer> selectList(Answer answer, Integer page, Integer size) {
        //设置分页的格式
        PageHelper.startPage(page,size);
        List<Answer> answers = answerMapper.selectList(answer);
        //对查询的所有结果进行分页处理
        PageInfo pageInfo = new PageInfo<>(answers);
        return pageInfo.getList();
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return answerMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean addAnswer(Answer answer) {
        return answerMapper.insertSelective(answer)>0;
    }

    @Override
    public Boolean updateAnswer(Answer answer) {
        return answerMapper.updateByPrimaryKeySelective(answer)>0;
    }
}
