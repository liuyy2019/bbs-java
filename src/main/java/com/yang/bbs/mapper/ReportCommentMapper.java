package com.yang.bbs.mapper;

import com.yang.bbs.bean.ReportComment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReportCommentMapper {
    @Delete({
        "delete from report_comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into report_comment (id, comment_id, ",
        "comment_name, report_id, ",
        "report_name, status, ",
        "create_time, update_time, ",
        "report_reason)",
        "values (#{id,jdbcType=INTEGER}, #{commentId,jdbcType=INTEGER}, ",
        "#{commentName,jdbcType=VARCHAR}, #{reportId,jdbcType=INTEGER}, ",
        "#{reportName,jdbcType=VARCHAR}, #{status,jdbcType=CHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{reportReason,jdbcType=VARCHAR})"
    })
    int insert(ReportComment record);

    @InsertProvider(type=ReportCommentSqlProvider.class, method="insertSelective")
    int insertSelective(ReportComment record);

    @Select({
        "select",
        "id, comment_id, comment_name, report_id, report_name, status, create_time, update_time, ",
        "report_reason",
        "from report_comment",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id = "reportCommentMap",value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.INTEGER),
        @Result(column="comment_name", property="commentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="report_id", property="reportId", jdbcType=JdbcType.INTEGER),
        @Result(column="report_name", property="reportName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="report_reason", property="reportReason", jdbcType=JdbcType.VARCHAR)
    })
    ReportComment selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ReportCommentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ReportComment record);

    @Update({
        "update report_comment",
        "set comment_id = #{commentId,jdbcType=INTEGER},",
          "comment_name = #{commentName,jdbcType=VARCHAR},",
          "report_id = #{reportId,jdbcType=INTEGER},",
          "report_name = #{reportName,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=CHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "report_reason = #{reportReason,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReportComment record);

    @Select({
            "select * from report_comment"
    })
    @ResultMap("reportCommentMap")
    List<ReportComment> selectAll();


    @SelectProvider(type=ReportCommentSqlProvider.class, method="selectiveProvider")
    @ResultMap("reportCommentMap")
    List<ReportComment> selectList(ReportComment reportComment);


    @Select({
            "select * from report_comment where comment_id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("reportCommentMap")
    List<ReportComment> selectReportCommentById(Integer id);

    @Select({
            "select * from report_comment where comment_id= #{commentId,jdbcType=INTEGER} order by create_time asc"
    })
    @ResultMap("reportCommentMap")
    List<ReportComment> selectListById(ReportComment reportComment);
}