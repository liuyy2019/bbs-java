package com.yang.bbs.mapper;

import com.yang.bbs.bean.Comment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    @Delete({
        "delete from comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into comment (id, content, ",
        "name, createtime, ",
        "invitation_id, invitation_title, ",
        "invitation_name, status, ",
        "amount, user_id, report,issuer_id)",
        "values (#{id,jdbcType=INTEGER}, #{content,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{invitationId,jdbcType=INTEGER}, #{invitationTitle,jdbcType=VARCHAR}, ",
        "#{invitationName,jdbcType=VARCHAR}, #{status,jdbcType=CHAR}, ",
        "#{amount,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER},#{report,jdbcType=INTEGER}," ,
        "#{issuerId,jdbcType=INTEGER})"
    })
    int insert(Comment record);

    @InsertProvider(type=CommentSqlProvider.class, method="insertSelective")
    int insertSelective(Comment record);

    @Select({
        "select",
        "id, content, name, createtime, invitation_id, invitation_title, invitation_name, ",
        "status, amount, user_id, reports,issuer_id",
        "from comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id = "commentMap",value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="issuer_id", property="issuerId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="invitation_id", property="invitationId", jdbcType=JdbcType.INTEGER),
        @Result(column="invitation_title", property="invitationTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="invitation_name", property="invitationName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="reports", property="reports", jdbcType=JdbcType.INTEGER)
    })
    Comment selectByPrimaryKey(Integer id);

    @Select({
            "select * from comment"
    })
    @ResultMap("commentMap")
    List<Comment> selectAll();

    @SelectProvider(type=CommentSqlProvider.class, method="selectiveProvider")
    @ResultMap("commentMap")
    List<Comment> selectList(Comment comment);

    @UpdateProvider(type=CommentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Comment record);

    @Update({
        "update comment",
        "set content = #{content,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "invitation_id = #{invitationId,jdbcType=INTEGER},",
          "invitation_title = #{invitationTitle,jdbcType=VARCHAR},",
          "invitation_name = #{invitationName,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=CHAR},",
          "amount = #{amount,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER}",
          "reports = #{reports,jdbcType=INTEGER}",
          "issuer_id = #{issuerId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Comment record);
}