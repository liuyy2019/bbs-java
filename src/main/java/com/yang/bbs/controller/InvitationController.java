package com.yang.bbs.controller;

import com.yang.bbs.bean.Invitation;
import com.yang.bbs.bean.User;
import com.yang.bbs.bean.dto.InvitationReq;
import com.yang.bbs.service.InvitationService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/6 22:16
 */
@RestController
@RequestMapping("/v1")
public class InvitationController {

    @Autowired
    public InvitationService invitationService;

    /**
     * 获取所有帖子列表
     * @return
     */
    @GetMapping("/invitation/invitationList")
    public List<Invitation> userList(){
        return invitationService.selectAll();
    }

    /**
     * 获取访问量较高帖子列表
     * @return
     */
    @GetMapping("/invitations/byVisitors")
    public List<Invitation> getInvitationsByVisitors(){
        return invitationService.getInvitationsByVisitors();
    }

    /**
     * 动态的获取帖子列表，支持分页
     * @return
     */
    @PostMapping("/invitation/invitation/page")
    public List<Invitation> invitationList(@RequestBody InvitationReq invitationReq){
        List<Invitation> invitationList = invitationService.selectList(invitationReq.getInvitation(),invitationReq.getPage(),invitationReq.getSize());
        return invitationList;
    }
    /**
     * restful风格的url
     * @param id
     * @return
     */
    @GetMapping("invitation/invitation/{id}")
    public Invitation getInvitationById(@PathVariable("id") Integer id){
        return invitationService.selectById(id);
    }

    /**
     * 根据id获取一条记录，使用？拼接方式传参
     * @param id
     * @return
     */
    @GetMapping("/invitation/invitation")
    public Invitation getInvitation(@RequestParam Integer id){
        return invitationService.selectById(id);
    }

    /**
     * 添加一条帖子记录
     * @param invitation
     * @return
     */
    @PostMapping("/invitation/add")
    public Boolean addInvitation(@RequestBody Invitation invitation) {
        return invitationService.addInvitation(invitation);
    }

    /**
     *  更新帖子信息
     * @param invitation
     * @return
     */
    @PutMapping("/invitation/update")
    public Boolean updateInvitation(@RequestBody Invitation invitation) {
        return invitationService.updateInvitation(invitation);
    }

    /**
     * 根据id删除帖子信息
     * @param id
     * @return
     */
    @DeleteMapping("invitation/{id}")
    public Boolean deleteInvitationById(@PathVariable("id") Integer id){
        return invitationService.deleteInvitation(id);
    }

}
