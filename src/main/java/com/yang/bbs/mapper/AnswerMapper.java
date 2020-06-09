package com.yang.bbs.mapper;

import com.yang.bbs.bean.Answer;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnswerMapper {
    /**
     *  根据主键删除问答
     * @param id
     * @return
     */
    @Delete({
        "delete from answer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增一条问答
     * @param record
     * @return
     */
    @Insert({
        "insert into answer (id, name, ",
        "content, createdate, ",
        "updatetime, status, ",
        "reply)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=VARCHAR}, #{createdate,jdbcType=TIMESTAMP}, ",
        "#{updatetime,jdbcType=TIMESTAMP}, #{status,jdbcType=INTEGER}, ",
        "#{reply,jdbcType=INTEGER})"
    })
    int insert(Answer record);

    /**
     * 动态的新增一条问答
     * @param record
     * @return
     */
    @InsertProvider(type=AnswerSqlProvider.class, method="insertSelective")
    int insertSelective(Answer record);

    /**
     * 根据id获取一条问答
     * @param id
     * @return
     */
    @Select({
        "select",
        "id, name, content, createdate, updatetime, status, reply",
        "from answer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id = "answerMap",value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="createdate", property="createdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updatetime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="reply", property="reply", jdbcType=JdbcType.INTEGER)
    })
    Answer selectByPrimaryKey(Integer id);

    /**
     * 获取所有的问答列表
     * @return
     */
    @Select({
            "select * from answer"
    })
    @ResultMap("answerMap")
    List<Answer> selectAll();

    /**
     * 动态的获取问答列表
     * @return
     */
    @SelectProvider(type=AnswerSqlProvider.class, method="selectiveProvider")
    @ResultMap("answerMap")
    List<Answer> selectList(Answer answer);

    /**
     * 动态的更新一条问答
     * @param record
     * @return
     */
    @UpdateProvider(type=AnswerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Answer record);

    /**
     * 跟新一条问答
     * @param record
     * @return
     */
    @Update({
        "update answer",
        "set name = #{name,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "createdate = #{createdate,jdbcType=TIMESTAMP},",
          "updatetime = #{updatetime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=INTEGER},",
          "reply = #{reply,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Answer record);
}