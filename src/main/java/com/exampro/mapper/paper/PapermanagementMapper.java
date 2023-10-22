package com.exampro.mapper.paper;

import com.exampro.model.paper.Papermanagement;
import org.apache.ibatis.annotations.*;
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
     * @param
     * @return #{paperName}, #{objectiveScore}, #{totalScore}, #{subjectiveScore}, #{startTime}, #{numberOfExaminees}, #{userId} ,#{duration}
     */
    @Insert("INSERT INTO papermanagement (PaperName, ObjectiveScore, TotalScore, SubjectiveScore, UserID) " +
            "VALUES (#{paperName}, #{objectiveScore}, #{totalScore}, #{subjectiveScore}, #{userID})")
    int insertPaper(@Param("paperName") String paperName, @Param("objectiveScore") Integer objectiveScore,
                    @Param("totalScore") Integer totalScore, @Param("subjectiveScore") Integer subjectiveScore,
                    @Param("userID") Integer userID);


    /**
     * 根据试卷id查找对应的试卷
     * @param
     * @return
     */
    @Select("select * from papermanagement where paperId = #{paperId}")
    List<Papermanagement> selectPaperById(Integer paperId);

    /**
     * 修改状态为通过
     */
    @Update("UPDATE papermanagement\n" +
            "SET juniorState = 1\n" +
            "WHERE paperId = #{paperId};\n")
    int changPaperPassById(int paperId);

    /**
     * 修改状态为不通过
     */
    @Update("UPDATE papermanagement\n" +
            "SET juniorState = 2\n" +
            "WHERE paperId = #{paperId};\n")
    int changPaperRefuseById(int paperId);
}