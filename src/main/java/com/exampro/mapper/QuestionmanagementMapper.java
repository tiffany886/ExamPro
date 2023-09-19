package com.exampro.mapper;

import com.exampro.model.Questionmanagement;

public interface QuestionmanagementMapper {
    int deleteByPrimaryKey(Integer questionid);

    int insert(Questionmanagement record);

    int insertSelective(Questionmanagement record);

    Questionmanagement selectByPrimaryKey(Integer questionid);

    int updateByPrimaryKeySelective(Questionmanagement record);

    int updateByPrimaryKeyWithBLOBs(Questionmanagement record);

    int updateByPrimaryKey(Questionmanagement record);
}