package com.yang.bbs.service;

import com.yang.bbs.bean.Invitationtype;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/28 22:55
 */
public interface InvitationTypeService {
    List<Invitationtype> selectAll();
    List<Invitationtype> selectList(Invitationtype invitationtype,Integer page,Integer size);

    Boolean deleteUserById(Integer id);

    Boolean updateType(Invitationtype invitationtype);

    Boolean addType(Invitationtype invitationtype);
}
