package com.exampro.mapper.invigilate;

import com.exampro.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther pluto
 * @Date 2023/10/27
 */
@Mapper
@Component
public interface exam_proctorMapper {
    /**
     * 查找监考人信息
     */
    @Select("select * from user where RoleID = 6")
    List<User> findAllProctors();

    /**
     * 插入考试的监考人
     * @param proctorID
     * @param examID
     * @return
     */
    @Insert("INSERT INTO exam_proctor (ProctorID, examID) VALUES (#{proctorID}, #{examID})")
    int addExamProctors(@Param("proctorID") Integer proctorID, @Param("examID") Integer examID);

    /**
     * 插入监考信息
     */

}
