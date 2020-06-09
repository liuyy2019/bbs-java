package com.yang.bbs.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

/**
 * @author liuyangyang
 * @Description 用户的基本类
 */
public class User {
    private Integer userId;

    private String name;

    private String password;

    private String email;

    private LocalDate birthday;

    private String sex;

    private Integer status;

    private String phone;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private LocalDate createtime;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private LocalDate updatetime;

    private String nickname;
    private Integer invitationNumber;
    private Integer reportNumber;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public LocalDate getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDate createtime) {
        this.createtime = createtime;
    }

    public LocalDate getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(LocalDate updatetime) {
        this.updatetime = updatetime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getInvitationNumber() {
        return invitationNumber;
    }

    public void setInvitationNumber(Integer invitationNumber) {
        this.invitationNumber = invitationNumber;
    }

    public Integer getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(Integer reportNumber) {
        this.reportNumber = reportNumber;
    }
}