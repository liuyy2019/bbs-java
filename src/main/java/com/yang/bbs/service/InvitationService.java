package com.yang.bbs.service;

import com.yang.bbs.bean.Invitation;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/6 22:08
 */
public interface InvitationService {
    /**
     * 获取所有的帖子或话题的列表
     * @return
     */
    List<Invitation> selectAll();

    /**
     * 根据id获取一个帖子对象
     * @param id
     * @return
     */
    Invitation selectById(Integer id);

    /**
     * 新增一个帖子
     * @param invitation
     * @return
     */
    Boolean addInvitation(Invitation invitation);

    /**
     * 动态的获取帖子列表，支持分页
     * @param invitation
     * @param page
     * @param size
     * @return
     */
    List<Invitation> selectList(Invitation invitation, Integer page, Integer size);

    Boolean updateInvitation(Invitation invitation);

    List<Invitation> getInvitationsByVisitors();

    Boolean deleteInvitation(Integer id);
}
