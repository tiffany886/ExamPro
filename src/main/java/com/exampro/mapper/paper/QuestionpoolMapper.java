package com.exampro.mapper.paper;

import com.exampro.model.paper.Questionpool;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface QuestionpoolMapper {
    /**
     * 查询所有题目
     */
    @Select("select * from questionPool order by createTime desc")
    List<Questionpool> selectAllQuestion();

    /**
     * 通过用户名获取对应的题目池
     */
    @Select("select * from questionPool where userId = #{userId} order by createTime desc")
    List<Questionpool> selectByPrimaryKey(Integer userId);

    /**
     * 添加题目
     */
    @Options(useGeneratedKeys = true,keyProperty = "questionId",keyColumn = "QuestionID")
    @Insert("INSERT INTO questionPool (questionType, questionDescription,userId,questionAnswer,questionScore) VALUES (#{questionType}, #{questionDescription},#{userId},#{questionAnswer},#{questionScore})")
    int addQuestion(Questionpool record);

    /**
     * 修改状态为通过 根据题目id
     */
    @Update("UPDATE questionpool\n" +
            "SET juniorState = 1\n" +
            "WHERE QuestionID = #{questionId};\n")
    int changQuesPassById(int questionId);

    /**
     * 修改状态为不通过
     */
    @Update("UPDATE questionpool\n" +
            "SET juniorState = 2\n" +
            "WHERE QuestionID = #{questionId};\n")
    int changQuesRefuseById(int questionId);

    /**
     * 获得初级审批通过的试题
     */
    @Select("SELECT * \n" +
            "FROM questionpool \n" +
            "WHERE juniorState = 1 order by createTime desc;\n")
    List<Questionpool> selectQuesPass();
}