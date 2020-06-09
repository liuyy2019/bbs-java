package com.yang.bbs.mapper;

import com.yang.bbs.bean.ReportInvitation;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReportInvitationMapper {
    @Delete({
        "delete from report_invitation",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into report_invitation (id, invitation_id, ",
        "title, issuer, report_id, issuer_id, ",
        "report_name, create_time, ",
        "update_time, status)",
        "values (#{id,jdbcType=INTEGER}, #{invitationId,jdbcType=INTEGER}, ",
        "#{title,jdbcType=VARCHAR}, #{issuer,jdbcType=VARCHAR}, #{reportId,jdbcType=INTEGER}, ",
        "#{issuerId,jdbcType=INTEGER},#{reportName,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{status,jdbcType=CHAR})"
    })
    int insert(ReportInvitation record);

    @InsertProvider(type=ReportInvitationSqlProvider.class, method="insertSelective")
    int insertSelective(ReportInvitation record);

    @Select({
        "select",
        "id, invitation_id, title, issuer,issuer_id, report_id, report_name, create_time, update_time, ",
        "status, report_reason",
        "from report_invitation",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id = "reportInvitationMap",value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="invitation_id", property="invitationId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="issuer", property="issuer", jdbcType=JdbcType.VARCHAR),
        @Result(column="issuer_id", property="issuerId", jdbcType=JdbcType.INTEGER),
        @Result(column="report_id", property="reportId", jdbcType=JdbcType.INTEGER),
        @Result(column="report_name", property="reportName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
        @Result(column="report_reason", property="reportReason", jdbcType=JdbcType.CHAR)
    })
    ReportInvitation selectByPrimaryKey(Integer id);

    @Select({
            "select * from report_invitation"
    })
    @ResultMap("reportInvitationMap")
    List<ReportInvitation> selectAll();

    @SelectProvider(type=ReportInvitationSqlProvider.class, method="selectiveProvider")
    @ResultMap("reportInvitationMap")
    List<ReportInvitation> selectList(ReportInvitation reportInvitation);

    @UpdateProvider(type=ReportInvitationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ReportInvitation record);

    @Update({
        "update report_invitation",
        "set invitation_id = #{invitationId,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "issuer = #{issuer,jdbcType=VARCHAR},",
          "report_id = #{reportId,jdbcType=INTEGER},",
          "report_name = #{reportName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=CHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReportInvitation record);

    @Select({
            "select * from report_invitation where invitation_id= #{invitationId,jdbcType=INTEGER} order by create_time asc"
    })
    @ResultMap("reportInvitationMap")
    List<ReportInvitation> selectListById(ReportInvitation reportInvitation);
}