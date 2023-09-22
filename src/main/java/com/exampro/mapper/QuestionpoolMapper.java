package com.exampro.mapper;

import com.exampro.model.Questionpool;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface QuestionpoolMapper {
    /**
     * 查询所有题目
     */
    @Select("select * from questionPool")
    List<Questionpool> selectAllQuestion();

    /**
     * 通过用户名获取对应的题目池
     */
    @Select("select * from questionPool where userId = #{userId}")
    List<Questionpool> selectByPrimaryKey(Integer userId);

    /**
     * 添加题目
     */
    @Insert("INSERT INTO questionPool (questionType, questionDescription, userId,questionAnswer) VALUES (#{questionType}, #{questionDescription}, #{userId}, #{questionAnswer})")
    int addQuestion(Questionpool record);

    int insertSelective(Questionpool record);

    int deleteByPrimaryKey(Integer questionid);

    int updateByPrimaryKeySelective(Questionpool record);

    int updateByPrimaryKeyWithBLOBs(Questionpool record);

    int updateByPrimaryKey(Questionpool record);
}