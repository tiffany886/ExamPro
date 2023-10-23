package com.exampro.controller.audit;

import com.exampro.constants.ApiResponse;
import com.exampro.constants.ApiRest;
import com.exampro.mapper.exam.ExamMapper;
import com.exampro.mapper.paper.PapermanagementMapper;
import com.exampro.mapper.paper.QuesAddBankMapper;
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
@Api(tags = "审核相关接口")
public class AduitController {
    @Autowired
    private QuestionpoolMapper questionpoolMapper;
    @Autowired
    private ExamMapper examMapper;
    @Autowired
    private PapermanagementMapper papermanagementMapper;
    @Autowired
    private QuesAddBankMapper quesAddBankMapper;
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



    /**
     * 通过题目题库终极审核
     */
    @ApiOperation("通过题目题库终极审核")
    @GetMapping(value="/quesUltimatePass", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<?>> quesUltimatePass(@RequestParam("bankId") Integer bankId,@RequestParam("questionId") Integer questionId){
        ApiResponse<Boolean> response = new ApiResponse<>();
        int row=quesAddBankMapper.changQuesBankPass(bankId,questionId);
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
     * 未通过题目题库终极审核
     */
    @ApiOperation("未通过题目题库终极审核")
    @GetMapping(value="/quesUltimateRefuse", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<?>> quesUltimateRefuse(@RequestParam("bankId") Integer bankId,@RequestParam("questionId") Integer questionId){
        ApiResponse<Boolean> response = new ApiResponse<>();
        int row=quesAddBankMapper.changQuesBankRefuse(bankId,questionId);
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
     * 通过考试终极审核
     */
    @ApiOperation("通过考试终极审核")
    @GetMapping(value="/examUltimatePass",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<?>> examUltimatePass(@RequestParam("examId") Integer examId){
        ApiResponse<Boolean> response = new ApiResponse<>();
        int row = examMapper.changExamPassLast(examId);
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
     * 未通过考试终极审核
     */
    @ApiOperation("未通过考试终极审核")
    @GetMapping(value="/examUltimateRefuse",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<?>> examUltimateRefuse(@RequestParam("examId") Integer examId){
        ApiResponse<Boolean> response = new ApiResponse<>();
        int row = examMapper.changExamRefuseLast(examId);
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
     * 通过试卷终极审核
     */
    @ApiOperation("通过试卷终极审核")
    @GetMapping(value="/paperUltimatePass",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<?>> paperUltimatePass(@RequestParam("paperId") Integer paperId){
        ApiResponse<Boolean> response = new ApiResponse<>();
        int row = papermanagementMapper.changPaperPassLast(paperId);
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
     * 通过试卷终极审核
     */
    @ApiOperation("通过试卷终极审核")
    @GetMapping(value="/paperUltimateRefuse",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<?>> paperUltimateRefuse(@RequestParam("paperId") Integer paperId){
        ApiResponse<Boolean> response = new ApiResponse<>();
        int row = papermanagementMapper.changPaperRefuseLast(paperId);
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
