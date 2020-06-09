package com.yang.bbs.mapper;

import com.yang.bbs.bean.Admin;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuyangyang
 * @description Admin的数据访问层
 */
@Mapper
@Repository
public interface AdminMapper {
    @Delete({
        "delete from admin",
        "where admin_id = #{adminId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer adminId);

    @Insert({
        "insert into admin (admin_id, name, ",
        "password, status, level)",
        "values (#{adminId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{status,jdbcType=CHAR}, #{level,jdbcType=CHAR})"
    })
    int insert(Admin record);

    @InsertProvider(type=AdminSqlProvider.class, method="insertSelective")
    int insertSelective(Admin record);

    @Select({
        "select",
        "admin_id, name, password, status, level",
        "from admin",
        "where admin_id = #{adminId,jdbcType=INTEGER}"
    })
    @Results(id = "adminMap",value = {
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.CHAR)
    })
    Admin selectByPrimaryKey(Integer adminId);

    @Select({
            "select * from admin"
    })
    @ResultMap("adminMap")
    List<Admin> selectAll();

    @SelectProvider(type=AdminSqlProvider.class, method="selectiveProvider")
    @ResultMap("adminMap")
    List<Admin> selectList(Admin admin);

    @UpdateProvider(type=AdminSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Admin record);

    @Update({
        "update admin",
        "set name = #{name,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=CHAR},",
          "level = #{level,jdbcType=CHAR}",
        "where admin_id = #{adminId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Admin record);

    @Select({
            "select * from admin ",
            "where name = #{username ,jdbcType = VARCHAR} ",
            "AND password = #{password ,jdbcType=VARCHAR}"
    })
    @ResultMap("adminMap")
    Admin getAdminByNameAndPass(@Param("username") String username,
                                @Param("password") String password);
}