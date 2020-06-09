package com.yang.bbs.mapper;

import com.yang.bbs.bean.Admin;
import org.apache.ibatis.jdbc.SQL;

public class AdminSqlProvider {

    public String insertSelective(Admin record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("admin");
        
        if (record.getAdminId() != null) {
            sql.VALUES("admin_id", "#{adminId,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=CHAR}");
        }
        
        if (record.getLevel() != null) {
            sql.VALUES("level", "#{level,jdbcType=CHAR}");
        }
        
        return sql.toString();
    }

    public String selectiveProvider(Admin record) {
        SQL sql = new SQL();
        sql.SELECT("admin_id, name, password, status, level");
        sql.FROM("admin");

        if (record.getAdminId() != null) {
            sql.WHERE("admin_id = #{adminId,jdbcType=INTEGER}");
        }

        if (record.getName() != null) {
            sql.WHERE("name = #{name,jdbcType=VARCHAR}");
        }

        if (record.getPassword() != null) {
            sql.WHERE("password = #{password,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            sql.WHERE("status = #{status,jdbcType=CHAR}");
        }

        if (record.getLevel() != null) {
            sql.WHERE("level = #{level,jdbcType=CHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Admin record) {
        SQL sql = new SQL();
        sql.UPDATE("admin");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=CHAR}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("level = #{level,jdbcType=CHAR}");
        }
        
        sql.WHERE("admin_id = #{adminId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}