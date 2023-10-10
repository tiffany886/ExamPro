package com.exampro.mapper.exam;

import com.exampro.model.exam.Exam;
import com.exampro.model.exam.ExamInfoDTO;
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
            "    e.PaperID AS PaperId,\n" +
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
            "    `user` u ON e.UserID = u.UserID;")
    @Results({
            @Result(column = "PaperId", property = "PaperId"),
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
     * 通过用户id查询所拥有的考试
     * @param userID
     * @return
     */
    @Select("SELECT * FROM exam WHERE UserID = #{userID};")
    List<Exam> findUserExams(@Param("userID") Integer userID);

    /**
     * 添加考试
     * @param examName
     * @param examDescription
     * @param paperID
     * @param startTime
     * @param examDuration
     * @return
     */
    @Insert(" INSERT INTO exam (ExamName, ExamDescription, PaperID, StartTime, ExamDuration,UserID )\n" +
            "VALUES (#{examName}, #{examDescription}, #{paperID}, #{startTime}, #{examDuration}, #{userID})")
    Integer addExam(@Param("examName") String examName, @Param("examDescription") String examDescription,
                    @Param("paperID") Integer paperID, @Param("startTime") Date startTime,
                    @Param("examDuration") Integer examDuration,@Param("userID") Integer userID);
}