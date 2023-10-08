package com.exampro.mapper.exam;

import com.exampro.model.exam.Exam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ExamMapper {
    /**
     * 查询所有试卷
     * @return
     */
    @Select("SELECT\n" +
            "pm.PaperID AS PaperId,\n" +
            "e.ExamName,\n" +
            "e.StartTime,\n" +
            "e.EndTime,\n" +
            "pm.NumberOfExaminees,\n" +
            "pm.ObjectiveScore,\n" +
            "pm.SubjectiveScore,\n" +
            "u.Username AS CreateBy\n" +
            "FROM exam AS e JOIN papermanagement AS pm ON e.PaperID = pm.PaperID JOIN user AS u ON pm.UserID = u.UserID;")
    List findAllExams();

    int deleteByPrimaryKey(Integer examid);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(Integer examid);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);
}