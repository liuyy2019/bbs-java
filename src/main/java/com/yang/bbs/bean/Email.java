package com.yang.bbs.bean;

/**
 * @author : liuyangyang
 * @date : 2020/5/26 17:56
 * @description : 邮件类
 */
public class Email {
    /**
     * 发送目标的qq号
     * 例如："2027388406@qq.com"
     */
    private String qq;

    /**
     * 邮件信息的主题："审核通知测试"
     */
    private String subject;

    /**
     * 邮件的内容
     */
    private String content;

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
