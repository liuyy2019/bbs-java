package com.yang.bbs.mapper;

import com.yang.bbs.bean.EnumType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnumTypeMapper {
    @Delete({
        "delete from enum_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into enum_type (id, code_name, ",
        "description, status, ",
        "create_time, create_by)",
        "values (#{id,jdbcType=INTEGER}, #{codeName,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{status,jdbcType=CHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{createBy,jdbcType=VARCHAR})"
    })
    int insert(EnumType record);

    @InsertProvider(type=EnumTypeSqlProvider.class, method="insertSelective")
    int insertSelective(EnumType record);

    @Select({
        "select",
        "id, code_name, description, status, create_time, create_by",
        "from enum_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id = "enumTypeMap",value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code_name", property="codeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR)
    })
    EnumType selectByPrimaryKey(Integer id);

    @UpdateProvider(type=EnumTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EnumType record);

    @Update({
        "update enum_type",
        "set code_name = #{codeName,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=CHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_by = #{createBy,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(EnumType record);

    @Select({
            "select * from enum_type"
    })
    @ResultMap("enumTypeMap")
    List<EnumType> selectAll();

    @SelectProvider(type=EnumTypeSqlProvider.class, method="selectiveProvider")
    @ResultMap("enumTypeMap")
    List<EnumType> selectList(EnumType enumType);
}