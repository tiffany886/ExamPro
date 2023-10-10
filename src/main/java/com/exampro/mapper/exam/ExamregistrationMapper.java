package com.exampro.mapper.exam;


import com.exampro.model.exam.Exam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ExamregistrationMapper {

    /**
     * 通过examID查找本场考试的考生
     * @param examID
     * @return
     */
    @Select("SELECT UserID FROM examregistration WHERE ExamID = #{examID}")
    Integer[] getUserIdsByExamID(@Param("examID") Integer examID);

    /**
     * 插入考试报名信息
     * @param ExamID
     * @param UserID
     * @return
     */
    @Insert("INSERT INTO examregistration (ExamID, UserID) VALUES (#{examID}, #{userID})")
    int regExam(@Param("examID") Integer examID, @Param("userID") Integer userID);
}