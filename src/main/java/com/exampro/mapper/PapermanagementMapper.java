package com.exampro.mapper;

import com.exampro.model.Papermanagement;

public interface PapermanagementMapper {
    int deleteByPrimaryKey(Integer paperid);

    int insert(Papermanagement record);

    int insertSelective(Papermanagement record);

    Papermanagement selectByPrimaryKey(Integer paperid);

    int updateByPrimaryKeySelective(Papermanagement record);

    int updateByPrimaryKey(Papermanagement record);
}