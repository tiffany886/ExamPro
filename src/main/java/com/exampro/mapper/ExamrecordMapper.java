package com.exampro.mapper;

import com.exampro.model.Examrecord;

public interface ExamrecordMapper {
    int deleteByPrimaryKey(Integer recordid);

    int insert(Examrecord record);

    int insertSelective(Examrecord record);

    Examrecord selectByPrimaryKey(Integer recordid);

    int updateByPrimaryKeySelective(Examrecord record);

    int updateByPrimaryKey(Examrecord record);
}