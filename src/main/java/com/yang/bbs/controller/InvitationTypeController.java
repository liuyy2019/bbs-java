package com.yang.bbs.controller;


import com.yang.bbs.bean.Invitationtype;
import com.yang.bbs.bean.User;
import com.yang.bbs.bean.dto.InvitationTypeReq;
import com.yang.bbs.service.InvitationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/28 22:58
 */
@RestController
@RequestMapping("/v1")
public class InvitationTypeController {

    @Autowired
    private InvitationTypeService invitationTypeService;

    /**
     * 获取所有的帖子类别信息
     * @return
     */
    @GetMapping("/admin/typeAll")
    public List<Invitationtype> getAllInvitationType(){
        return invitationTypeService.selectAll();
    }

    /**
     * 动态的获取帖子类别分页
     * @return
     */
    @PostMapping("/admin/type/page")
    public List<Invitationtype> invitationTypeList(@RequestBody InvitationTypeReq typeReq){
        List<Invitationtype> adminList = invitationTypeService.selectList(typeReq.getInvitationtype(),typeReq.getPage(),typeReq.getSize());
        return adminList;
    }
    /**
     * 根据id删除帖子种类
     * @param id
     * @return
     */
    @DeleteMapping("/invitation/type/{id}")
    public Boolean deleteInvitationType(@PathVariable("id") Integer id){
        return invitationTypeService.deleteUserById(id);
    }

    /**
     *  添加帖子类别
     * @param invitationtype
     * @return
     */
    @PostMapping("/type/add")
    public Boolean addInvitationType(@RequestBody Invitationtype invitationtype) {
        return invitationTypeService.addType(invitationtype);
    }

    /**
     *  更新帖子类别
     * @param invitationtype
     * @return
     */
    @PutMapping("/type/update")
    public Boolean updateInvitationType(@RequestBody Invitationtype  invitationtype) {
        return invitationTypeService.updateType(invitationtype);
    }
}
