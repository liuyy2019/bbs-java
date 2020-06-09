package com.yang.bbs.mapper;

import com.yang.bbs.bean.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        if (record.getInvitationNumber() != null) {
            sql.VALUES("invitation_number", "#{invitationNumber,jdbcType=INTEGER}");
        }
        if (record.getReportNumber() != null) {
            sql.VALUES("report_number", "#{reportNumber,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            sql.VALUES("birthday", "#{birthday,jdbcType=DATE}");
        }
        
        if (record.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=CHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=CHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("createTime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatetime() != null) {
            sql.VALUES("updateTime", "#{updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getNickname() != null) {
            sql.VALUES("nickname", "#{nickname,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectiveProvider(User record) {
        SQL sql = new SQL();
        sql.SELECT("user_id, name, report_number,invitation_number,password, email, birthday, sex, status, phone, createTime, updateTime,nickname");
        sql.FROM("user");
        if (record.getUserId() != null) {
            sql.WHERE("user_id = #{userId,jdbcType=INTEGER}");
        }
        if (record.getReportNumber() != null) {
            sql.WHERE("report_number >= #{reportNumber,jdbcType=INTEGER}");
        }
        if (record.getInvitationNumber() != null) {
            sql.WHERE("invitation_number >= #{invitationNumber,jdbcType=INTEGER}");
        }

        if (record.getName() != null && !("".equals(record.getName()))) {
            sql.WHERE("name LIKE #{name,jdbcType=VARCHAR}");
        }

        if (record.getPassword() != null) {
            sql.WHERE("password = #{password,jdbcType=VARCHAR}");
        }

        if (record.getEmail() != null) {
            sql.WHERE("email = #{email,jdbcType=VARCHAR}");
        }

        if (record.getBirthday() != null) {
            sql.WHERE("birthday = #{birthday,jdbcType=DATE}");
        }

        if (record.getSex() != null) {
            sql.WHERE("sex = #{sex,jdbcType=CHAR}");
        }

        if (record.getStatus() != null) {
            sql.WHERE("status = #{status,jdbcType=INTEGER}");
        }

        if (record.getPhone() != null) {
            sql.WHERE("phone = #{phone,jdbcType=CHAR}");
        }


        if (record.getNickname() != null) {
            sql.WHERE("nickname = #{nickname,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            sql.SET("birthday = #{birthday,jdbcType=DATE}");
        }
        
        if (record.getSex() != null ) {
            sql.SET("sex = #{sex,jdbcType=CHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=CHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("createTime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatetime() != null) {
            sql.SET("updateTime = #{updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getNickname() != null) {
            sql.SET("nickname = #{nickname,jdbcType=VARCHAR}");
        }

        if (record.getInvitationNumber() != null) {
            sql.SET("invitation_number = #{invitationNumber,jdbcType=INTEGER}");
        }
        if (record.getNickname() != null) {
            sql.SET("report_number = #{reportNumber,jdbcType=INTEGER}");
        }
        
        sql.WHERE("user_id = #{userId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}