package com.yang.bbs.mapper;

import com.yang.bbs.bean.ReportUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReportUserMapper {
    @Delete({
        "delete from report_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into report_user (id, user_id, ",
        "user_name, create_time, ",
        "report_id, report_name, ",
        "status, update_time)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{userName,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{reportId,jdbcType=INTEGER}, #{reportName,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=CHAR}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(ReportUser record);

    @InsertProvider(type=ReportUserSqlProvider.class, method="insertSelective")
    int insertSelective(ReportUser record);

    @Select({
        "select",
        "id, user_id, user_name, create_time,report_reason, report_id, report_name, status, update_time",
        "from report_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id = "reportUserMap",value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="report_id", property="reportId", jdbcType=JdbcType.INTEGER),
        @Result(column="report_name", property="reportName", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.CHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="report_reason", property="reportReason", jdbcType=JdbcType.VARCHAR)
    })
    ReportUser selectByPrimaryKey(Integer id);

    @Select({
            "select * from report_user"
    })
    @ResultMap("reportUserMap")
    List<ReportUser> selectAll();

    @SelectProvider(type=ReportUserSqlProvider.class, method="selectiveProvider")
    @ResultMap("reportUserMap")
    List<ReportUser> selectList(ReportUser reportUser);

    @UpdateProvider(type=ReportUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ReportUser record);

    @Update({
        "update report_user",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "report_id = #{reportId,jdbcType=INTEGER},",
          "report_name = #{reportName,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=CHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
          "report_reason = #{reportReason,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ReportUser record);

    @Select({
            "select * from report_user where user_id= #{userId,jdbcType=INTEGER} order by create_time asc"
    })
    @ResultMap("reportUserMap")
    List<ReportUser> selectListById(ReportUser reportUser);
}