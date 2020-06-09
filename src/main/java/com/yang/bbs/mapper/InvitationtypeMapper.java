package com.yang.bbs.mapper;

import com.yang.bbs.bean.Invitationtype;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InvitationtypeMapper {
    @Delete({
        "delete from invitationType",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into invitationType (id, type, ",
        "description, create_time, ",
        "status, create_by, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{type,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=CHAR}, #{createBy,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(Invitationtype record);

    @InsertProvider(type=InvitationtypeSqlProvider.class, method="insertSelective")
    int insertSelective(Invitationtype record);

    @Select({
        "select",
        "id, type, description, create_time, status, create_by, update_time",
        "from invitationType",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id = "typeMap",value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Invitationtype selectByPrimaryKey(Integer id);

    @Select({
            "select * from invitationType"
    })
    @ResultMap("typeMap")
    List<Invitationtype> selectAll();

    @SelectProvider(type=InvitationtypeSqlProvider.class, method="selectiveProvider")
    @ResultMap("typeMap")
    List<Invitationtype> selectList(Invitationtype invitationtype);



    @UpdateProvider(type=InvitationtypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Invitationtype record);

    @Update({
        "update invitationType",
        "set type = #{type,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=CHAR},",
          "create_by = #{createBy,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Invitationtype record);
}