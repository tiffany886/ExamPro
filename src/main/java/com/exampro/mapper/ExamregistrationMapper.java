package com.exampro.mapper;

import com.exampro.model.Examregistration;

public interface ExamregistrationMapper {
    int deleteByPrimaryKey(Integer registrationid);

    int insert(Examregistration record);

    int insertSelective(Examregistration record);

    Examregistration selectByPrimaryKey(Integer registrationid);

    int updateByPrimaryKeySelective(Examregistration record);

    int updateByPrimaryKey(Examregistration record);
}