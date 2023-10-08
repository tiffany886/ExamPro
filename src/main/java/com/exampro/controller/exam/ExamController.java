package com.exampro.controller.exam;

import com.exampro.constants.ApiResponse;
import com.exampro.mapper.exam.ExamMapper;
import com.exampro.model.exam.Exam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 考试
 */
@RestController
@RequestMapping("/exam")
@Api(tags = "考试相关接口")
public class ExamController {
    /**
     * 注入ExamMapper
     */
    @Autowired
    private ExamMapper examMapper;

    /**
     * 查询所有考试
     */
    @GetMapping("/allExams")
    @ApiOperation("查询所有考试")
    public ResponseEntity<?> findAllUsers(){
        ApiResponse<Boolean> response = new ApiResponse<>();
        List<Exam> data = examMapper.findAllExams();
        return ResponseEntity.ok(response.success("查询成功！", data));
    }
}
