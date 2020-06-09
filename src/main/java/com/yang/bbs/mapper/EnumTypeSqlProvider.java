package com.yang.bbs.mapper;

import com.yang.bbs.bean.EnumType;
import org.apache.ibatis.jdbc.SQL;

public class EnumTypeSqlProvider {

    public String insertSelective(EnumType record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("enum_type");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCodeName() != null) {
            sql.VALUES("code_name", "#{codeName,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=CHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateBy() != null) {
            sql.VALUES("create_by", "#{createBy,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectiveProvider(EnumType record) {
        SQL sql = new SQL();
        sql.SELECT("id, code_name, description, status, create_time, create_by");
        sql.FROM("enum_type");

        if (record.getId() != null) {
            sql.WHERE("id = #{id,jdbcType=INTEGER}");
        }

        if (record.getCodeName() != null) {
            sql.WHERE("code_name = #{codeName,jdbcType=VARCHAR}");
        }

        if (record.getDescription() != null) {
            sql.WHERE("description = #{description,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            sql.WHERE("status = #{status,jdbcType=CHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.WHERE("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getCreateBy() != null) {
            sql.WHERE("create_by = #{createBy,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(EnumType record) {
        SQL sql = new SQL();
        sql.UPDATE("enum_type");
        
        if (record.getCodeName() != null) {
            sql.SET("code_name = #{codeName,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=CHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{createBy,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}