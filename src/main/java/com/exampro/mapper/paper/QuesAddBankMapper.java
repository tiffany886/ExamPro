package com.exampro.mapper.paper;

import com.exampro.model.paper.Questionpool;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface QuesAddBankMapper {
    @Insert("INSERT INTO bankQuestion (bankId, questionId) VALUES (#{bankId}, #{questionId})")
    int addQuesInBank(Integer bankId, Integer questionId);

    /**
     * 找某一个题库的题
     */
    @Select("SELECT qp.*, bq.ultimateState\n" +
            "FROM questionpool qp\n" +
            "INNER JOIN bankquestion bq ON qp.QuestionID = bq.QuestionID\n" +
            "WHERE bq.BankID = #{bankId} ORDER BY createTime DESC")
    List<Questionpool> selectBankQuesByBankId(Integer userId);
    /**
    *  审核通过题目题库表的题
    */
    @Update("UPDATE bankquestion\n" +
            "SET ultimateState = 1 \n" +
            "WHERE bankId = #{bankId}\n" +
            "AND questionId = #{questionId};\n")
    int changQuesBankPass(int bankId,int questionId);

    /**
     *  审核不通过题目题库表的题
     */
    @Update("UPDATE bankquestion\n" +
            "SET ultimateState = 2 \n" +
            "WHERE bankId = #{bankId}\n" +
            "AND questionId = #{questionId};\n")
    int changQuesBankRefuse(int bankId,int questionId);
}
