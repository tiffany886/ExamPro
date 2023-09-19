package com.exampro.mapper;

import com.exampro.model.Questionbankassociation;

public interface QuestionbankassociationMapper {
    int deleteByPrimaryKey(Integer associationid);

    int insert(Questionbankassociation record);

    int insertSelective(Questionbankassociation record);

    Questionbankassociation selectByPrimaryKey(Integer associationid);

    int updateByPrimaryKeySelective(Questionbankassociation record);

    int updateByPrimaryKey(Questionbankassociation record);
}