package com.exampro.mapper.paper;

import com.exampro.model.paper.Paperquestion;
import com.exampro.model.paper.paperQuesItem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PaperquestionMapper {
    /**
     * 向试卷中添加题目
     * @param paperID
     * @param questionID
     * @param questionType
     * @param score
     * @return
     */
    @Insert("INSERT INTO paperquestion (PaperID, QuestionID, QuestionType, Score) " +
            "VALUES (#{paperID}, #{questionID}, #{questionType}, #{score})")
    int insertPaperQuestion(@Param("paperID") int paperID, @Param("questionID") int questionID,
                            @Param("questionType") String questionType, @Param("score") int score);

    @Select("SELECT\n" +
            "    qp.QuestionID,\n" +
            "    qp.QuestionType,\n" +
            "    qp.QuestionDescription,\n" +
            "    qp.QuestionAnswer,\n" +
            "    qp.questionScore AS QuestionScore\n" +
            "FROM\n" +
            "    paperquestion AS pq\n" +
            "INNER JOIN\n" +
            "    questionpool AS qp\n" +
            "ON\n" +
            "    pq.QuestionID = qp.QuestionID\n" +
            "WHERE\n" +
            "    pq.PaperID = #{paperID};\n")
    List<paperQuesItem> findQuesByPaperId(@Param("paperID") int paperID);
}