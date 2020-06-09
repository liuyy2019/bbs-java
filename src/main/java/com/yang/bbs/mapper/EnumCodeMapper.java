package com.yang.bbs.mapper;

import com.yang.bbs.bean.EnumCode;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnumCodeMapper {
    @Delete({
        "delete from enum_code",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into enum_code (id, code_type, ",
        "code_name, description, ",
        "status, create_time, ",
        "create_by)",
        "values (#{id,jdbcType=INTEGER}, #{codeType,jdbcType=VARCHAR}, ",
        "#{codeName,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createBy,jdbcType=VARCHAR})"
    })
    int insert(EnumCode record);

    @InsertProvider(type=EnumCodeSqlProvider.class, method="insertSelective")
    int insertSelective(EnumCode record);

    @Select({
        "select",
        "id, code_type, code_name, description, status, create_time, create_by",
        "from enum_code",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id = "enumCodeMap",value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code_type", property="codeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="code_name", property="codeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR)
    })
    EnumCode selectByPrimaryKey(Integer id);



    @UpdateProvider(type=EnumCodeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EnumCode record);

    @Update({
        "update enum_code",
        "set code_type = #{codeType,jdbcType=VARCHAR},",
          "code_name = #{codeName,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=CHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_by = #{createBy,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(EnumCode record);

    @SelectProvider(type=EnumCodeSqlProvider.class, method="selectiveProvider")
    @ResultMap("enumCodeMap")
    List<EnumCode> selectList(EnumCode enumCode);

    @Select({
            "select * from enum_code"
    })
    @ResultMap("enumCodeMap")
    List<EnumCode> selectAll();
}