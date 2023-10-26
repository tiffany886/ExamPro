package com.exampro.mapper.exam;

import com.exampro.model.User;
import com.exampro.model.exam.Exam;
import com.exampro.model.exam.ExamInfoDTO;
import com.exampro.model.exam.Examrecord;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface ExamMapper {
    /**
     * 查询所有试卷
     * @return
     */
    @Select("SELECT\n" +
            "    e.ExamID AS ExamID,\n" +
            "    e.ExamName,\n" +
            "    e.StartTime,\n" +
            "    e.EndTime,\n" +
            "    e.NumberOfExaminees,\n" +
            "    p.ObjectiveScore,\n" +
            "    p.SubjectiveScore,\n" +
            "    u.Username AS CreatedBy\n" +
            "FROM\n" +
            "    exam e\n" +
            "        JOIN\n" +
            "    papermanagement p ON e.PaperID = p.PaperID\n" +
            "        JOIN\n" +
            "    `user` u ON e.UserID = u.UserID order by e.examID desc;")
    @Results({
            @Result(column = "ExamID", property = "ExamID"),
            @Result(column = "ExamName", property = "ExamName"),
            @Result(column = "StartTime", property = "StartTime"),
            @Result(column = "EndTime", property = "EndTime"),
            @Result(column = "NumberOfExaminees", property = "NumberOfExaminees"),
            @Result(column = "ObjectiveScore", property = "ObjectiveScore"),
            @Result(column = "SubjectiveScore", property = "SubjectiveScore"),
            @Result(column = "CreatedBy", property = "CreatedBy")
    })
    List<ExamInfoDTO> findAllExams();

    /**
     * 查询通过初审的试卷
     */
    @Select("SELECT\n" +
            "    e.ExamID AS ExamID,\n" +
            "    e.ExamName,\n" +
            "    e.StartTime,\n" +
            "    e.EndTime,\n" +
            "    e.NumberOfExaminees,\n" +
            "    u.Username AS CreatedBy,\n" +
            "    e.examDuration ,e.ultimateState , e.juniorState \n" +
            "FROM\n" +
            "    exam e\n" +
            "        JOIN\n" +
            "    papermanagement p ON e.PaperID = p.PaperID\n" +
            "        JOIN\n" +
            "    `user` u ON e.UserID = u.UserID where e.juniorState = 1 order by e.examID desc;")
    @Results({
            @Result(column = "ExamID", property = "ExamID"),
            @Result(column = "ExamName", property = "ExamName"),
            @Result(column = "StartTime", property = "StartTime"),
            @Result(column = "EndTime", property = "EndTime"),
            @Result(column = "NumberOfExaminees", property = "NumberOfExaminees"),
            @Result(column = "examDuration", property = "examDuration"),
            @Result(column = "ultimateState", property = "ultimateState"),
            @Result(column = "juniorState", property = "juniorState"),
            @Result(column = "CreatedBy", property = "CreatedBy")
    })
    List<ExamInfoDTO> findExamsPassJunior();
    /**
     * 通过用户id查询所拥有的考试
     * @param userID
     * @return
     */
    @Select("SELECT * FROM exam WHERE UserID = #{userID} order by examID desc")
    List<Exam> findUserExams(@Param("userID") Integer userID);

    /**
     * 查询参加考试的考生
     */
    @Select("SELECT u.UserID, u.Username\n" +
            "FROM user u\n" +
            "INNER JOIN examregistration er ON u.UserID = er.UserID\n" +
            "WHERE er.ExamID = #{examId};\n")
    List<User> findExamRegistUsers(@Param("examId") Integer examId);
    /**
     * 添加考试
     * @param examName
     * @param examDescription
     * @param paperID
     * @param startTime
     * @param examDuration
     * @return
     */
    @Options(useGeneratedKeys = true,keyProperty = "examID",keyColumn = "examID")
    @Insert(" INSERT INTO exam (ExamName, ExamDescription, PaperID, StartTime, ExamDuration,UserID )\n" +
            "VALUES (#{examName}, #{examDescription}, #{paperID}, #{startTime}, #{examDuration}, #{userID});")
    Integer addExam(Exam exam);

    /**
     * 修改状态为通过
     */
    @Update("UPDATE exam\n" +
            "SET juniorState = 1\n" +
            "WHERE examID = #{examID};\n")
    int changExamPassById(int examId);

    /**
     * 修改状态为不通过
     */
    @Update("UPDATE exam\n" +
            "SET juniorState = 2\n" +
            "WHERE examID = #{examID};\n")
    int changExamRefuseById(int examId);

    /**
     * 修改状态为通过
     */
    @Update("UPDATE exam\n" +
            "SET ultimateState = 1\n" +
            "WHERE examID = #{examID};\n")
    int changExamPassLast(int examId);

    /**
     * 修改状态为不通过
     */
    @Update("UPDATE exam\n" +
            "SET ultimateState = 2\n" +
            "WHERE examID = #{examID};\n")
    int changExamRefuseLast(int examId);


}
