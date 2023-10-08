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
    @Select("SELECT * FROM exam e JOIN papermanagement p ON e.PaperID = p.PaperID JOIN user u ON p.UserID = u.UserID;")
    List findAllExams();

    int deleteByPrimaryKey(Integer examid);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(Integer examid);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);
}