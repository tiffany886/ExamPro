package com.exampro.mapper;

import com.exampro.model.Questionbank;

public interface QuestionbankMapper {
    int deleteByPrimaryKey(Integer bankid);

    int insert(Questionbank record);

    int insertSelective(Questionbank record);

    Questionbank selectByPrimaryKey(Integer bankid);

    int updateByPrimaryKeySelective(Questionbank record);

    int updateByPrimaryKey(Questionbank record);
}