package com.exampro.mapper;

import com.exampro.model.Questionbank;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
@Component
public interface QuestionbankMapper {

    /**
     * 查询所有题库
     * @return
     */
    @Select("select * from questionBank")
    List<Questionbank> selectAllBank();

    /**
     * 根据用户id查询题库
     * @return
     */
    @Select("select * from questionBank where userId = #{userId}")
    List<Questionbank> selectBankById(Integer userId);

    /**
     * 添加题库
     * @param record
     * @return
     */
    @Insert("INSERT INTO questionBank (bankName, userId) VALUES (#{bankName}, #{userId})")
    int addBank(Questionbank record);

    int insert(Questionbank record);

    int insertSelective(Questionbank record);

    Questionbank selectByPrimaryKey(Integer bankid);

    int updateByPrimaryKeySelective(Questionbank record);

    int updateByPrimaryKey(Questionbank record);

    int deleteByPrimaryKey(Integer bankid);
}