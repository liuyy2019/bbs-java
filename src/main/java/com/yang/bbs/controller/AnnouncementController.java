package com.yang.bbs.controller;

import com.yang.bbs.bean.Announcement;
import com.yang.bbs.bean.User;
import com.yang.bbs.bean.dto.AnnouncementReq;
import com.yang.bbs.service.AnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/28 20:15
 */
@Api(tags = "公告接口")
@RestController
@RequestMapping("/v1")
public class AnnouncementController {
    @Autowired
    private AnnouncementService announcementService;

    @ApiOperation("获取所有公告列表")
    @GetMapping("/announcement/announcementList")
    public List<Announcement> getAllAnswer(){
        return announcementService.getAllAnnouncement();
    }

    /**
     * 动态的获取公告分页
     * @return
     */
    @ApiOperation("分页动态获取公告列表")
    @PostMapping("/announcement/announcement/page")
    public List<Announcement> answerList(@RequestBody AnnouncementReq announcementReq){
        List<Announcement> announcementList = announcementService.selectList(announcementReq.getAnnouncement(),announcementReq.getPage(),announcementReq.getSize());
        return announcementList;
    }

    /**
     * 根据id删除公告
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除公告",notes = "路径参数ID")
    @DeleteMapping("/announcement/{id}")
    public Boolean deleteUser(@PathVariable("id") Integer id){
        return announcementService.deleteUserById(id);
    }

    /**
     *  添加公告
     * @param announcement
     * @return
     */
    @ApiOperation("新增一条公告")
    @PostMapping("/announcement/add")
    public Boolean addAnnouncement(@RequestBody Announcement announcement) {
        return announcementService.addAnnouncement(announcement);
    }

    /**
     *  更新公告
     * @param announcement
     * @return
     */
    @ApiOperation("更新一条公告")
    @PutMapping("/announcement/update")
    public Boolean updateAnnouncement(@RequestBody Announcement announcement) {
        return announcementService.updateAnnouncement(announcement);
    }
}
