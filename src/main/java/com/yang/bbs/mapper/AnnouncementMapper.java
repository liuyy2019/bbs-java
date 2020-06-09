package com.yang.bbs.mapper;

import com.yang.bbs.bean.Announcement;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnnouncementMapper {
    @Delete({
        "delete from announcement",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into announcement (id, content, ",
        "create_time, status, ",
        "issuer, title)",
        "values (#{id,jdbcType=INTEGER}, #{content,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{status,jdbcType=CHAR}, ",
        "#{issuer,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR})"
    })
    int insert(Announcement record);

    @InsertProvider(type=AnnouncementSqlProvider.class, method="insertSelective")
    int insertSelective(Announcement record);

    @Select({
        "select",
        "id, content, create_time, status, issuer, title",
        "from announcement",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id = "announcementMap",value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
        @Result(column="issuer", property="issuer", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR)
    })
    Announcement selectByPrimaryKey(Integer id);

    @Select({
            "select * from announcement"
    })
    @ResultMap("announcementMap")
    List<Announcement> selectAll();

    @SelectProvider(type=AnnouncementSqlProvider.class, method="selectiveProvider")
    @ResultMap("announcementMap")
    List<Announcement> selectList(Announcement announcement);



    @UpdateProvider(type=AnnouncementSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Announcement record);

    @Update({
        "update announcement",
        "set content = #{content,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=CHAR},",
          "issuer = #{issuer,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Announcement record);
}