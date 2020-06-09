package com.yang.bbs.mapper;

import com.yang.bbs.bean.Param;
import org.apache.ibatis.jdbc.SQL;

public class ParamSqlProvider {

    public String insertSelective(Param record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("param");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCodeId() != null) {
            sql.VALUES("code_id", "#{codeId,jdbcType=VARCHAR}");
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
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateBy() != null) {
            sql.VALUES("create_by", "#{createBy,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }


    public String selectiveProvider(Param record) {
        SQL sql = new SQL();
        sql.SELECT("id, code_id, code_name, description, status, create_time, update_time, create_by");
        sql.FROM("param");

        if (record.getId() != null) {
            sql.WHERE("id = #{id,jdbcType=INTEGER}");
        }

        if (record.getCodeId() != null) {
            sql.WHERE("code_id = #{codeId,jdbcType=VARCHAR}");
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

        if (record.getUpdateTime() != null) {
            sql.WHERE("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getCreateBy() != null) {
            sql.WHERE("create_by = #{createBy,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Param record) {
        SQL sql = new SQL();
        sql.UPDATE("param");
        
        if (record.getCodeId() != null) {
            sql.SET("code_id = #{codeId,jdbcType=VARCHAR}");
        }
        
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
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateBy() != null) {
            sql.SET("create_by = #{createBy,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}