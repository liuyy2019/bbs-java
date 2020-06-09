package com.yang.bbs.controller;

import com.yang.bbs.bean.Email;
import com.yang.bbs.bean.User;
import com.yang.bbs.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/5/20 22:18
 */
@RestController
@RequestMapping("/v1")
public class EmailController {

    @Autowired
    private MailUtil mailUtil;

    /**
     * 发送邮箱信息
     * @return
     */
    @GetMapping("/email/submit")
    public void emailSubmit(){
        String qq ="2027388406@qq.com";
        String subject = "审核通知测试";
        String content = "内容";
        mailUtil.sendSimpleMail(qq,subject,content);
    }


    /**
     * 发送邮件的接口方法
     * @param email
     */
    @PostMapping("/email/send")
    public void sendEmail(@RequestBody Email email){
        String qq =email.getQq();
        String subject = email.getSubject();
        String content = email.getContent();
        mailUtil.sendSimpleMail(qq,subject,content);
    }
}
