package com.yang.bbs.mapper;

import com.yang.bbs.bean.EchartsData;
import com.yang.bbs.bean.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Delete({
        "delete from user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
        "insert into user (user_id, name, ",
        "password, email, ",
        "birthday, sex, status, ",
        "phone, createTime, ",
        "updateTime, nickname,invitation_number,report_number)",
        "values (#{userId,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{birthday,jdbcType=DATE}, #{sex,jdbcType=CHAR}, #{status,jdbcType=INTEGER}, ",
        "#{phone,jdbcType=CHAR}, #{createtime,jdbcType=TIMESTAMP}, ",
        "#{updatetime,jdbcType=TIMESTAMP}, #{nickname,jdbcType=VARCHAR}, " ,
        "#{invitationNumber,jdbcType=INTEGER},#{reportNumber,jdbcType=INTEGER})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @Select({
        "select",
        "user_id, name, password, email, birthday, sex, status, phone, createTime, updateTime, ",
        "nickname,invitation_number,report_number",
        "from user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results(id = "userProvider",value = {
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="sex", property="sex", jdbcType=JdbcType.CHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="phone", property="phone", jdbcType=JdbcType.CHAR),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateTime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="invitation_number", property="invitationNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="report_number", property="reportNumber", jdbcType=JdbcType.INTEGER)
    })
    User selectByPrimaryKey(Integer userid);

    @Select({
            "select * from user"
    })
    @ResultMap("userProvider")
    List<User> selectAll();

    @SelectProvider(type=UserSqlProvider.class, method="selectiveProvider")
    @ResultMap("userProvider")
    List<User> selectList(User user);

    @Select({
            "select * from user",
            "where name = #{username,jdbcType=VARCHAR}",
            "and password = #{password,jdbcType=VARCHAR}"
    })
    @ResultMap("userProvider")
    User getUserByNameAndPass(@Param("username") String username,@Param("password") String password);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set name = #{name,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=DATE},",
          "sex = #{sex,jdbcType=CHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "phone = #{phone,jdbcType=CHAR},",
          "createTime = #{createtime,jdbcType=TIMESTAMP},",
          "updateTime = #{updatetime,jdbcType=TIMESTAMP},",
          "nickname = #{nickname,jdbcType=VARCHAR}",
          "invitation_number = #{invitationNumber,jdbcType=INTEGER},",
          "report_number = #{reportNumber,jdbcType=INTEGER},",
        "where userId = #{userid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);

    @Select({
            "SELECT age as name,count( * ) AS value" ,
            "FROM (" ,
                "SELECT" ,
                    "CASE",
                    "WHEN `tables`.age <= 20 THEN   '20及以下' " ,
                    "WHEN `tables`.age <= 30 AND `tables`.age >= 21 THEN    '21-30' " ,
                    "WHEN `tables`.age <= 40 AND `tables`.age >= 31 THEN    '31-40' " ,
                    "WHEN `tables`.age <= 50 AND `tables`.age >= 41 THEN    '41-50' " ,
                    "WHEN `tables`.age <= 60 AND `tables`.age >= 51 THEN    '51-60' " ,
                    "WHEN `tables`.age >= 61 THEN  '61及以上' " ,
                    "END AS age",
                "FROM ( SELECT name,`password`,birthday,TIMESTAMPDIFF(YEAR,user.birthday,CURDATE())AS 'age' FROM user ) As tables ) AS a \n" +
            "GROUP BY age"
    })
    @Results({
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="value", property="value", jdbcType=JdbcType.INTEGER)
    })
    List<EchartsData> getUserCharts();
}