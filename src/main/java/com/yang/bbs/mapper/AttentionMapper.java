package com.yang.bbs.mapper;

import com.yang.bbs.bean.Attention;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AttentionMapper {
    /**
     * 根据id删除一条关注记录
     * @param id
     * @return
     */
    @Delete({
        "delete from attention",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入关注记录
     * @param record
     * @return
     */
    @Insert({
        "insert into attention (id, username, ",
        "usersex, userphone,user_id,noticer_id, ",
        "noticer, sex, phone, ",
        "createtime, status)",
        "values (#{id,jdbcType=INTEGER},#{userId,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{usersex,jdbcType=VARCHAR},#{noticerId,jdbcType=INTEGER}, #{userphone,jdbcType=VARCHAR}, ",
        "#{noticer,jdbcType=VARCHAR}, #{sex,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{createtime,jdbcType=TIMESTAMP}, #{status,jdbcType=CHAR})"
    })
    int insert(Attention record);

    /**
     * 动态的插入一条关注记录
     * @param record
     * @return
     */
    @InsertProvider(type=AttentionSqlProvider.class, method="insertSelective")
    int insertSelective(Attention record);

    /**
     * 根据id获取一条关注记录
     * @param id
     * @return
     */
    @Select({
        "select",
        "id, user_id,noticer_id,username, usersex, userphone, noticer, sex, phone, createtime, status",
        "from attention",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id = "attentionProvider",value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="noticer_id", property="noticerId", jdbcType=JdbcType.INTEGER),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="usersex", property="usersex", jdbcType=JdbcType.VARCHAR),
        @Result(column="userphone", property="userphone", jdbcType=JdbcType.VARCHAR),
        @Result(column="noticer", property="noticer", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="createtime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.CHAR)
    })
    Attention selectByPrimaryKey(Integer id);

    /**
     * 动态的更新关注列表
     * @param record
     * @return
     */
    @UpdateProvider(type=AttentionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Attention record);

    /**
     * 更新关注列表
     * @param record
     * @return
     */
    @Update({
        "update attention",
        "set username = #{username,jdbcType=VARCHAR},",
          "usersex = #{usersex,jdbcType=VARCHAR},",
          "userphone = #{userphone,jdbcType=VARCHAR},",
          "noticer = #{noticer,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "createtime = #{createtime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=CHAR}",
          "user_id = #{userId,jdbcType=INTEGER}",
          "noticer_id = #{noticerId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Attention record);

    /**
     * 获取所有的关注列表
     * @return
     */
    @Select({
            "select * from attention"
    })
    @ResultMap("attentionProvider")
    List<Attention> selectAll();

    /**
     * 动态的获取关注列表
     * @param attention
     * @return
     */
    @SelectProvider(type=AttentionSqlProvider.class, method="selectiveProvider")
    @ResultMap("attentionProvider")
    List<Attention> selectList(Attention attention);


    @Select({
            "select * from attention where username= #{username,jdbcType=VARCHAR} order by createtime asc"
    })
    @ResultMap("attentionProvider")
    List<Attention> selectListByName(Attention attention);
}