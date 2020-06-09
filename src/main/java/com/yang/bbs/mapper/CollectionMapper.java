package com.yang.bbs.mapper;

import com.yang.bbs.bean.Collection;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CollectionMapper {
    @Delete({
        "delete from collection",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into collection (id, collector, ",
        "title, issuer, createtime, ",
        "type, status,user_id,invitation_id,issuer_id)",
        "values (#{id,jdbcType=INTEGER}, #{collector,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{issuer,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{type,jdbcType=VARCHAR}, #{status,jdbcType=CHAR}," ,
        "#{userId,jdbcType=INTEGER},#{invitationId,jdbcType=INTEGER},#{issuerId,jdbcType=INTEGER})"
    })
    int insert(Collection record);

    @InsertProvider(type=CollectionSqlProvider.class, method="insertSelective")
    int insertSelective(Collection record);

    @Select({
        "select",
        "id, collector, title, issuer, createtime, type, status, user_id,invitation_id,issuer_id",
        "from collection",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id = "collectionMapping",value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="collector", property="collector", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="issuer", property="issuer", jdbcType=JdbcType.VARCHAR),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="invitation_id", property="invitationId", jdbcType=JdbcType.INTEGER),
        @Result(column="issuer_id", property="issuerId", jdbcType=JdbcType.INTEGER),
    })
    Collection selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CollectionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Collection record);

    @Update({
        "update collection",
        "set collector = #{collector,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "issuer = #{issuer,jdbcType=VARCHAR},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "type = #{type,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=CHAR}",
          "user_id = #{userId,jdbcType=INTEGER}",
          "invitation_id = #{invitationId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Collection record);

    @Select({
            "select * from collection"
    })
    @ResultMap("collectionMapping")
    List<Collection> selectAll();

    @SelectProvider(type=CollectionSqlProvider.class, method="selectiveProvider")
    @ResultMap("collectionMapping")
    List<Collection> selectList(Collection collection);
}