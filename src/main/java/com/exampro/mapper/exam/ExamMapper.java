package com.exampro.mapper.exam;

import com.exampro.model.exam.Exam;
import com.exampro.model.exam.ExamInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
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
                "    `user` u ON p.UserID = u.UserID;")
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


    int deleteByPrimaryKey(Integer examid);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(Integer examid);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);
}