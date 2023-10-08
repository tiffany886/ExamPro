package com.exampro.mapper.paper;

import com.exampro.model.paper.Questionpool;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface QuesAddBankMapper {
    @Insert("INSERT INTO bankQuestion (bankId, questionId) VALUES (#{bankId}, #{questionId})")
    int addQuesInBank(Integer bankId,Integer questionId);

//    找某一个题库的题
    @Select("SELECT qp.*\n" +
            "FROM questionpool qp\n" +
            "         INNER JOIN bankquestion bq ON qp.QuestionID = bq.QuestionID\n" +
            "WHERE bq.BankID = #{bankId} order by createTime desc")
    List<Questionpool> selectBankQuesByBankId(Integer userId);

}
