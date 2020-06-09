package com.yang.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.bbs.bean.Announcement;
import com.yang.bbs.mapper.AnnouncementMapper;
import com.yang.bbs.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/28 20:11
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    public List<Announcement> getAllAnnouncement() {
        return announcementMapper.selectAll();
    }

    @Override
    public List<Announcement> selectList(Announcement announcement, Integer page, Integer size) {
        //设置分页的格式
        PageHelper.startPage(page,size);
        List<Announcement> announcements = announcementMapper.selectList(announcement);
        //对查询的所有结果进行分页处理
        PageInfo pageInfo = new PageInfo<>(announcements);
        return pageInfo.getList();
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return announcementMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean addAnnouncement(Announcement announcement) {
        announcement.setCreateTime(LocalDateTime.now());
        return announcementMapper.insertSelective(announcement)>0;
    }

    @Override
    public Boolean updateAnnouncement(Announcement announcement) {
        return announcementMapper.updateByPrimaryKeySelective(announcement)>0;
    }
}
