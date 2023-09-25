package com.exampro.mapper.paper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface QuesAddBankMapper {
    @Insert("INSERT INTO bankQuestion (bankId, questionId) VALUES (#{bankId}, #{questionId})")
    int addQuesInBank(Integer bankId,Integer questionId);
}
