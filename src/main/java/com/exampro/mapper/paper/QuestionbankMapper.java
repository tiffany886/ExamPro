package com.exampro.mapper.paper;

import com.exampro.model.paper.Questionbank;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface QuestionbankMapper {

    /**
     * 查询所有题库
     * @return
     */
    @Select("select * from questionBank order by createTime desc")
    List<Questionbank> selectAllBank();

    /**
     * 根据用户id查询题库
     * @return
     */
    @Select("select * from questionBank where userId = #{userId} order by createTime desc")
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