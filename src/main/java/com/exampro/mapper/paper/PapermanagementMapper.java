package com.exampro.mapper.paper;

import com.exampro.model.paper.Papermanagement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    @Select("select * from papermanagement order by PaperID desc")
    List<Papermanagement> selectAllPaper();

    /**
     * 添加试卷
     * @param record
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

    int deleteByPrimaryKey(Integer paperid);



    int insertSelective(Papermanagement record);

    List<Papermanagement> selectByPrimaryKey(Integer paperid);

    int updateByPrimaryKeySelective(Papermanagement record);

    int updateByPrimaryKey(Papermanagement record);
}