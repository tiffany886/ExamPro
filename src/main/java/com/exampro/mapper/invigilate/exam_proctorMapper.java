package com.exampro.mapper.invigilate;

import com.exampro.model.User;
import com.exampro.model.exam.Exam;
import com.exampro.model.invigilate.proctoring_record;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther pluto
 * @Date 2023/10/27
 */
@Mapper
@Component
public interface exam_proctorMapper {
    /**
     * 查找监考人信息
     */
    @Select("select * from user where RoleID = 6")
    List<User> findAllProctors();

    /**
     * 插入考试的监考人
     * @param proctorID
     * @param examID
     * @return
     */
    @Insert("INSERT INTO exam_proctor (ProctorID, examID) VALUES (#{proctorID}, #{examID})")
    int addExamProctors(@Param("proctorID") Integer proctorID, @Param("examID") Integer examID);

    /**
     * 插入监考信息
     */
    @Insert("INSERT INTO proctoring_record (ExamineeID, ExamID, ProctorID, IssueContent, SenderID) " +
            "VALUES (#{examineeID}, #{examID}, #{proctorID}, #{issueContent},#{senderID})")
    int addProctoringRecord(@Param("examineeID") Integer examineeID, @Param("examID") Integer examID,
                            @Param("proctorID") Integer proctorID, @Param("issueContent") String issueContent,
                            @Param("senderID") Integer senderID);

    /**
     * 根据考试id查找监考人
     * @param examID
     * @return
     */
    @Select("SELECT ProctorID FROM exam_proctor WHERE examID = #{examID}")
    Integer findProctorsByExamID(@Param("examID") int examID);

    /**
     * 根据考试id查找监考记录
     */
    @Select("SELECT * FROM proctoring_record WHERE ExamID = #{examID} ORDER BY Time ASC")
    List<proctoring_record> findProctoringRecordsByExamID(@Param("examID") int examID);

    /**
     * 根据监考人ID查找要监考的考试信息
     */
    @Select("SELECT e.* " +
            "FROM exam e " +
            "INNER JOIN exam_proctor ep ON e.ExamID = ep.examID " +
            "WHERE ep.ProctorID = #{proctorID}")
    List<Exam> findExamsByProctorID(@Param("proctorID") int proctorID);



}
