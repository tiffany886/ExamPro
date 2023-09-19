package com.exampro.mapper;

import com.exampro.model.Gradingmanagement;

public interface GradingmanagementMapper {
    int deleteByPrimaryKey(Integer gradingid);

    int insert(Gradingmanagement record);

    int insertSelective(Gradingmanagement record);

    Gradingmanagement selectByPrimaryKey(Integer gradingid);

    int updateByPrimaryKeySelective(Gradingmanagement record);

    int updateByPrimaryKey(Gradingmanagement record);
}