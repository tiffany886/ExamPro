package com.exampro.controller.invigilate;

import com.exampro.constants.ApiResponse;
import com.exampro.constants.ApiRest;
import com.exampro.mapper.invigilate.exam_proctorMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther pluto
 * @Date 2023/10/27
 */

@RestController
@RequestMapping("/invigilate")
@Api(tags = "考试相关接口")
public class exam_proctorController {
    /**
     * 注入exam_proctorMapper
     */
    @Autowired
    private exam_proctorMapper exam_proctorMapper;

    /**
     * 查询所有监考人
     */
    @GetMapping("/allProctors")
    @ApiOperation("查询所有监考人")
    public ResponseEntity<ApiRest<?>> findAllProctors(){
        ApiResponse<?> response = new ApiResponse<>();
        try{
            return ResponseEntity.ok(response.success("查询成功！", exam_proctorMapper.findAllProctors()));
        }catch (Exception e){
            return ResponseEntity.ok(response.success("查询失败！"+ e.getMessage(), false));
        }
    }

    /**
     * 插入考试的监考人
     */
    @PostMapping("/addExamProctors")
    @ApiOperation("插入考试的监考人")
    public ResponseEntity<ApiRest<?>> addExamProctors(
            @RequestParam("proctorID") Integer proctorID,
            @RequestParam("examID") Integer examID) {

        ApiResponse<?> response = new ApiResponse<>();

        int rowsInserted = exam_proctorMapper.addExamProctors(proctorID, examID);

        if (rowsInserted > 0) {
            return ResponseEntity.ok(response.success("监考人插入成功！", true));
        } else {
            return ResponseEntity.ok(response.success("监考人失败！", false));
        }
    }

}
