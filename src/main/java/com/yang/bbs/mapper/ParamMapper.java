package com.yang.bbs.mapper;

import com.yang.bbs.bean.Param;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ParamMapper {
    /**
     * 通过id删除参数信息
     * @param id
     * @return
     */
    @Delete({
        "delete from param",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增一条参数信息
     * @param record
     * @return
     */
    @Insert({
        "insert into param (id, code_id, ",
        "code_name, description, ",
        "status, create_time, ",
        "update_time, create_by)",
        "values (#{id,jdbcType=INTEGER}, #{codeId,jdbcType=VARCHAR}, ",
        "#{codeName,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=CHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{createBy,jdbcType=VARCHAR})"
    })
    int insert(Param record);

    /**
     * 动态的添加参数信息
     * @param record
     * @return
     */
    @InsertProvider(type=ParamSqlProvider.class, method="insertSelective")
    int insertSelective(Param record);

    /**
     * 通过主键id,获取参数信息
     * @param id
     * @return
     */
    @Select({
        "select",
        "id, code_id, code_name, description, status, create_time, update_time, create_by",
        "from param",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id = "paramMap",value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code_id", property="codeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="code_name", property="codeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR)
    })
    Param selectByPrimaryKey(Integer id);



    @UpdateProvider(type=ParamSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Param record);

    @Update({
        "update param",
        "set code_id = #{codeId,jdbcType=VARCHAR},",
          "code_name = #{codeName,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=CHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_by = #{createBy,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Param record);

    /**
     * 获取所有的参数信息
     * @return
     */
    @Select({
            "select * from param"
    })
    @ResultMap("paramMap")
    List<Param> selectAll();

    /**
     * 根据参数对象动态获取参数信息类表
     * @param param
     * @return
     */
    @SelectProvider(type=ParamSqlProvider.class, method="selectiveProvider")
    @ResultMap("paramMap")
    List<Param> selectList(Param param);

    /**
     * 根据参数码获取参数信息
     * @param codeId
     * @return
     */
    @Select({
            "select * from param where code_id = #{codeId,jdbcType=VARCHAR}"
    })
    @ResultMap("paramMap")
    Param selectByCodeId(String codeId);
}