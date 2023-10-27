package com.exampro.mapper.exam;

import com.exampro.model.exam.Examrecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ExamrecordMapper {
    /**
     * 插入考试记录数据
     * @param examRecord
     * @return
     */
    @Insert("INSERT INTO examrecord (paperId, questionId, studentAnswer, score, totalScore, examId,userId) " +
            "VALUES (#{paperId}, #{questionId}, #{studentAnswer}, #{score}, #{totalScore}, #{examId},#{userId})")
    int insertExamRecord(Examrecord examRecord);

    /**
     * isUserDoneExam 查询是否有考试
     */
    @Select("Select * from examrecord where userId = #{userId} and examId = #{examId}")
    List<Examrecord> findUserDoneExam(int userId,int examId);

    /**
     * 获取用户考试记录
     */
    @Select("SELECT *\n" +
            "FROM examrecord\n" +
            "WHERE examId = #{examId}\n" +
            "  AND userId = #{userId};\n")
    List<Examrecord> selectAllExamRecord(int examId,int userId);

    /**
     * 更新考试的分数
     */
    @Update("UPDATE examrecord\n" +
            "SET Score = #{score}\n" +
            "WHERE UserID = #{userId} AND ExamID = #{examId} AND QuestionID = #{questionId};\n")
    int updateUserExamScore(int userId,int examId,int questionId,int score);
    /**
     * 是否评卷完毕
     */
    // @Select("select * from examrecord where userId = #{userId} and examId = #{examId}")
}