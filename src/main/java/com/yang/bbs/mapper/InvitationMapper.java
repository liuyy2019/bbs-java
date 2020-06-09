package com.yang.bbs.mapper;

import com.yang.bbs.bean.Invitation;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface InvitationMapper {

    @Delete({
        "delete from invitation",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into invitation (id, name, ",
        "date, title, type, ",
        "visitors, content,clicks,reports,status,issuer_id)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{date,jdbcType=TIMESTAMP}, #{title,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, ",
        "#{visitors,jdbcType=INTEGER}, #{content,jdbcType=LONGVARCHAR}," ,
        "#{clicks,jdbcType=INTEGER},3{reports,jdbcType=INTEGER}," ,
        "#{status,jdbcType=VARCHAR},#{issuerId,jdbcType=VARCHAR})"
    })
    int insert(Invitation record);

    @InsertProvider(type=InvitationSqlProvider.class, method="insertSelective")
    int insertSelective(Invitation record);

    @Select({
        "select",
        "id, name, date, title, type, visitors, content,clicks,reports,issuer_id,status",
        "from invitation",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id = "invitationProvider",value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="date", property="date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="visitors", property="visitors", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="clicks", property="clicks", jdbcType=JdbcType.INTEGER),
        @Result(column="reports", property="reports", jdbcType=JdbcType.INTEGER),
        @Result(column="issuer_id", property="issuerId", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    Invitation selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, name, date, title, type, visitors, content,clicks,reports,issuer_id,status",
            "from invitation",
    })
    @ResultMap("invitationProvider")
    List<Invitation> selectAll();

    @UpdateProvider(type=InvitationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Invitation record);


    @Update({
        "update invitation",
        "set name = #{name,jdbcType=VARCHAR},",
          "date = #{date,jdbcType=TIMESTAMP},",
          "title = #{title,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "visitors = #{visitors,jdbcType=INTEGER}",
          "clicks = #{clicks,jdbcType=INTEGER},",
          "reports = #{reports,jdbcType=INTEGER},",
          "status = #{status,jdbcType=VARCHAR},",
          "issuer_id = #{issuerId,jdbcType=VARCHAR},",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Invitation record);

    /**
     * 动态的获取帖子列表
     * @param invitation
     * @return
     */
    @SelectProvider(type=InvitationSqlProvider.class, method="selectiveProvider")
    @ResultMap("invitationProvider")
    List<Invitation> selectList(Invitation invitation);

    /**
     * 获取访问前五的帖子列表
     * @return
     */
    @Select({
            "select * from invitation order by visitors desc limit 0,6"
    })
    @ResultMap("invitationProvider")
    List<Invitation> getInvitationsByVisitors();
}