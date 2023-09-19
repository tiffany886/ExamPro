package com.exampro.mapper;

import com.exampro.model.Questionpool;

public interface QuestionpoolMapper {
    int deleteByPrimaryKey(Integer questionid);

    int insert(Questionpool record);

    int insertSelective(Questionpool record);

    Questionpool selectByPrimaryKey(Integer questionid);

    int updateByPrimaryKeySelective(Questionpool record);

    int updateByPrimaryKeyWithBLOBs(Questionpool record);

    int updateByPrimaryKey(Questionpool record);
}