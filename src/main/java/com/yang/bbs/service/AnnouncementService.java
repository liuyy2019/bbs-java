package com.yang.bbs.service;

import com.yang.bbs.bean.Announcement;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/28 20:11
 */
public interface AnnouncementService {

    /**
     * 获取所有的公告列表
     * @return
     */
    List<Announcement> getAllAnnouncement();

    /**
     * 分页动态的获取公告列表
     * @param announcement
     * @param page
     * @param size
     * @return
     */
    List<Announcement> selectList(Announcement announcement, Integer page, Integer size);

    Boolean deleteUserById(Integer id);

    Boolean addAnnouncement(Announcement announcement);

    Boolean updateAnnouncement(Announcement announcement);
}
