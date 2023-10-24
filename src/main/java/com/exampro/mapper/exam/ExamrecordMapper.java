package com.exampro.mapper.exam;

import com.exampro.model.exam.Examrecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ExamrecordMapper {
    /**
     * 插入考试记录数据
     * @param examRecord
     * @return
     */
    @Insert("INSERT INTO examrecord (PaperID, QuestionID, StudentAnswer, Score, TotalScore, ExamID) " +
            "VALUES (#{paperID}, #{questionID}, #{studentAnswer}, #{score}, #{totalScore}, #{examID})")
    int insertExamRecord(Examrecord examRecord);
}