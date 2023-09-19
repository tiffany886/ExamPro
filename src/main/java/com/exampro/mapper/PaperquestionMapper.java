package com.exampro.mapper;

import com.exampro.model.Paperquestion;

public interface PaperquestionMapper {
    int deleteByPrimaryKey(Integer linkid);

    int insert(Paperquestion record);

    int insertSelective(Paperquestion record);

    Paperquestion selectByPrimaryKey(Integer linkid);

    int updateByPrimaryKeySelective(Paperquestion record);

    int updateByPrimaryKey(Paperquestion record);
}