package com.exampro.mapper.paper;

import com.exampro.model.paper.Papermanagement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface PapermanagementMapper {
    /**
     * 查找全部的试卷
     * @return
     */
    @Select("select * from papermanagement")
    List<Papermanagement> selectAllPaper();

    /**
     * 添加试卷
     * @param record
     * @return #{paperName}, #{objectiveScore}, #{totalScore}, #{subjectiveScore}, #{startTime}, #{numberOfExaminees}, #{userId} ,#{duration}
     */
    @Insert("INSERT INTO PaperManagement (paperName, objectiveScore, totalScore, subjectiveScore, startTime, numberOfExaminees, userId, duration) VALUES (#{paperName}, #{objectiveScore}, #{totalScore}, #{subjectiveScore}, #{startTime}, #{numberOfExaminees}, #{userId} ,#{duration})")
    int insert(Papermanagement record);

    /**
     * 根据试卷id查找对应的试卷
     * @param
     * @return
     */
    @Select("select * from papermanagement where paperId = #{paperId}")
    List<Papermanagement> selectPaperById(Integer paperId);

    int deleteByPrimaryKey(Integer paperid);



    int insertSelective(Papermanagement record);

    List<Papermanagement> selectByPrimaryKey(Integer paperid);

    int updateByPrimaryKeySelective(Papermanagement record);

    int updateByPrimaryKey(Papermanagement record);
}