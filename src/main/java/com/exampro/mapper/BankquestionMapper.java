package com.exampro.mapper;

import com.exampro.model.Bankquestion;

public interface BankquestionMapper {
    int deleteByPrimaryKey(Integer linkid);

    int insert(Bankquestion record);

    int insertSelective(Bankquestion record);

    Bankquestion selectByPrimaryKey(Integer linkid);

    int updateByPrimaryKeySelective(Bankquestion record);

    int updateByPrimaryKey(Bankquestion record);
}