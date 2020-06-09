package com.yang.bbs.controller;

import com.yang.bbs.bean.Attention;
import com.yang.bbs.bean.User;
import com.yang.bbs.bean.dto.AttentionReq;
import com.yang.bbs.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/21 1:03
 */
@RestController
@RequestMapping("/v1")
public class AttentionController {

    @Autowired
    private AttentionService attentionService;

    /**
     * 获取所有的关注列表
     * @return
     */
    @GetMapping("/attention/allAttentions")
    public List<Attention> getAllAttention(){
        return attentionService.getAllAttention();
    }

    /**
     * 动态的获取关注列表
     * @return
     */
    @PostMapping("/attention/attention/page")
    public List<Attention> attentionList(@RequestBody AttentionReq attentionReq){
        List<Attention> attentionList = attentionService.selectList(attentionReq.getAttention(),attentionReq.getPage(),attentionReq.getSize());
        return attentionList;
    }

    /**
     * 获取某个用户的关注信息列表，并按时间升序排列
     * @return
     */
    @PostMapping("/attention/sort")
    public List<Attention> attentionListByName(@RequestBody Attention attention){
        List<Attention> attentionList = attentionService.selectListByName(attention);
        return attentionList;
    }

    /**
     * 根据id删除关注
     * @param id
     * @return
     */
    @DeleteMapping("/attention/{id}")
    public Boolean deleteUser(@PathVariable("id") Integer id){
        return attentionService.deleteUserById(id);
    }

    /**
     *  添加关注
     * @param attention
     * @return
     */
    @PostMapping("/attention/add")
    public Boolean addAttention(@RequestBody Attention attention) {
        return attentionService.addAttention(attention);
    }

    /**
     *  更新关注
     * @param attention
     * @return
     */
    @PutMapping("/attention/update")
    public Boolean updateAttention(@RequestBody Attention attention) {
        return attentionService.updateAttention(attention);
    }
}
