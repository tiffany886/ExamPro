package com.exampro.controller.audit;

import com.exampro.constants.ApiResponse;
import com.exampro.constants.ApiRest;
import com.exampro.mapper.exam.ExamMapper;
import com.exampro.mapper.paper.PapermanagementMapper;
import com.exampro.mapper.paper.QuestionpoolMapper;
import com.exampro.model.paper.Papermanagement;
import com.exampro.model.paper.Questionpool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *@Author zhh
 *@Date 2023/10/22
 */
@RestController
@RequestMapping("/audit")
@Api(tags = "初级审核相关接口")
public class AduitController {
    @Autowired
    private QuestionpoolMapper questionpoolMapper;
    @Autowired
    private ExamMapper examMapper;
    @Autowired
    private PapermanagementMapper papermanagementMapper;
    /**
     * 通过题目初级审核
     */
    @ApiOperation("通过题目初级审核")
    @GetMapping(value="/quesJuniorPass", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<?>> quesJuniorPass(@RequestParam("questionId") Integer questionId){
        ApiResponse<Boolean> response = new ApiResponse<>();
        int row=questionpoolMapper.changQuesPassById(questionId);
        try {
            if (row == 1){
                return ResponseEntity.ok(response.success("通过审核",true));
            }else {
                return ResponseEntity.ok(response.failure("通过失败，请重新尝试"));
            }
        }catch (Exception e){
            return ResponseEntity.ok(response.failure("通过失败，请重新尝试"+e.getMessage()));
        }
    }

    /**
     * 未通过题目初级审核
     */
    @ApiOperation("未通过题目初级审核")
    @GetMapping(value="/quesJuniorRefuse", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<?>> quesJuniorRefuse(@RequestParam("questionId") Integer questionId){
        ApiResponse<Boolean> response = new ApiResponse<>();
        int row=questionpoolMapper.changQuesRefuseById(questionId);
        try {
            if (row == 1){
                return ResponseEntity.ok(response.success("未通过审核",true));
            }else {
                return ResponseEntity.ok(response.failure("未通过失败，请重新尝试"));
            }
        }catch (Exception e){
            return ResponseEntity.ok(response.failure("未通过失败，请重新尝试"+e.getMessage()));
        }
    }

    /**
     * 通过考试初级审核
     */
    @ApiOperation("通过考试初级审核")
    @GetMapping(value="/examJuniorPass",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<?>> examJuniorPass(@RequestParam("examId") Integer examId){
        ApiResponse<Boolean> response = new ApiResponse<>();
        int row = examMapper.changExamPassById(examId);
        try {
            if (row == 1){
                return ResponseEntity.ok(response.success("通过审核",true));
            }else {
                return ResponseEntity.ok(response.failure("通过失败，请重新尝试"));
            }
        }catch (Exception e){
            return ResponseEntity.ok(response.failure("通过失败，请重新尝试"+e.getMessage()));
        }
    }
    /**
     * 未通过考试初级审核
     */
    @ApiOperation("未通过考试初级审核")
    @GetMapping(value="/examJuniorRefuse",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<?>> examJuniorRefuse(@RequestParam("examId") Integer examId){
        ApiResponse<Boolean> response = new ApiResponse<>();
        int row = examMapper.changExamRefuseById(examId);
        try {
            if (row == 1){
                return ResponseEntity.ok(response.success("未通过审核",true));
            }else {
                return ResponseEntity.ok(response.failure("未通过失败，请重新尝试"));
            }
        }catch (Exception e){
            return ResponseEntity.ok(response.failure("未通过失败，请重新尝试"+e.getMessage()));
        }
    }

    /**
     * 通过试卷初级审核
     */
    @ApiOperation("通过试卷初级审核")
    @GetMapping(value="/paperJuniorPass",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<?>> paperJuniorPass(@RequestParam("paperId") Integer paperId){
        ApiResponse<Boolean> response = new ApiResponse<>();
        int row = papermanagementMapper.changPaperPassById(paperId);
        try {
            if (row == 1){
                return ResponseEntity.ok(response.success("通过审核",true));
            }else {
                return ResponseEntity.ok(response.failure("通过失败，请重新尝试"));
            }
        }catch (Exception e){
            return ResponseEntity.ok(response.failure("通过失败，请重新尝试"+e.getMessage()));
        }
    }
    /**
     * 通过试卷初级审核
     */
    @ApiOperation("通过试卷初级审核")
    @GetMapping(value="/paperJuniorRefuse",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<?>> paperJuniorRefuse(@RequestParam("paperId") Integer paperId){
        ApiResponse<Boolean> response = new ApiResponse<>();
        int row = papermanagementMapper.changPaperRefuseById(paperId);
        try {
            if (row == 1){
                return ResponseEntity.ok(response.success("未通过审核",true));
            }else {
                return ResponseEntity.ok(response.failure("未通过失败，请重新尝试"));
            }
        }catch (Exception e){
            return ResponseEntity.ok(response.failure("未通过失败，请重新尝试"+e.getMessage()));
        }
    }
}
