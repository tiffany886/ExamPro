package com.exampro.controller.invigilate;

import com.exampro.constants.ApiResponse;
import com.exampro.constants.ApiRest;
import com.exampro.mapper.invigilate.exam_proctorMapper;
import com.exampro.model.exam.Exam;
import com.exampro.model.invigilate.proctoring_record;
import com.exampro.utils.jwt.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
     * 注入 JwtTokenUtil
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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
            return ResponseEntity.ok(response.failure("查询失败！"+ e.getMessage(), false));
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
            return ResponseEntity.ok(response.failure("监考人失败！", false));
        }
    }

    /**
     * 插入监考记录
     * @param examineeID
     * @param examID
     * @param proctorID
     * @param issueContent
     * @param senderID
     * @return
     */
    @PostMapping("/addProctoringRecord")
    @ApiOperation("插入监考记录")
    public ResponseEntity<ApiRest<?>> addProctoringRecord(
            @RequestParam("examineeID") Integer examineeID,
            @RequestParam("examID") Integer examID,
            @RequestParam("proctorID") Integer proctorID,
            @RequestParam("issueContent") String issueContent,
            @RequestParam("senderID") Integer senderID) {

        ApiResponse<?> response = new ApiResponse<>();

        int rowsInserted = exam_proctorMapper.addProctoringRecord(examineeID, examID, proctorID, issueContent, senderID);

        if (rowsInserted > 0) {
            return ResponseEntity.ok(response.success("监考记录插入成功！", true));
        } else {
            return ResponseEntity.ok(response.failure("监考记录插入失败！", false));
        }
    }

    /**
     * 根据考试ID查找监考人
     * @param examID 考试ID
     * @return ResponseEntity 包含查询结果的响应
     */
    @PostMapping("/findProctorsByExamID")
    @ApiOperation("根据考试ID查找监考人")
    public ResponseEntity<ApiRest<?>> findProctorsByExamID(@RequestParam("examID") Integer examID) {
        ApiResponse<?> response = new ApiResponse<>();
        try {
            Integer proctorId = exam_proctorMapper.findProctorsByExamID(examID);
            HashMap data = new HashMap();
            data.put("proctorId",proctorId);
            if (proctorId != -1) {
                return ResponseEntity.ok(response.success("查询监考人id成功！", data));
            } else {
                return ResponseEntity.ok(response.failure("未找到相关监考人信息！", null));
            }
        } catch (Exception e) {
            return ResponseEntity.ok(response.failure("查询监考人id失败！" + e.getMessage(), false));
        }
    }

    @PostMapping("/proctoringRecordsByExamID")
    @ApiOperation("根据考试ID查找监考记录")
    public ResponseEntity<ApiRest<?>> findProctoringRecordsByExamID(@RequestParam("examID") int examID) {
        ApiResponse<?> response = new ApiResponse<>();
        try {
            List<proctoring_record> records = exam_proctorMapper.findProctoringRecordsByExamID(examID);
            if (!records.isEmpty()) {
                return ResponseEntity.ok(response.success("查询监考记录成功！", records));
            } else {
                return ResponseEntity.ok(response.failure("未找到相关监考记录！", null));
            }
        } catch (Exception e) {
            return ResponseEntity.ok(response.failure("查询监考记录失败！" + e.getMessage(), false));
        }
    }

    /**
     * 根据监考人ID查找要监考的考试信息
     * @return
     */
    @PostMapping("/examsByProctorID")
    @ApiOperation("根据监考人ID查找要监考的考试信息")
    public ResponseEntity<ApiRest<List<Exam>>> findExamsByProctorID(@RequestHeader("Authorization") String token) {
        ApiResponse<List<Exam>> response = new ApiResponse<>();
        // 解析token获取用户id
        Claims claims = jwtTokenUtil.parseToken(token);
        Integer userID = Integer.parseInt(claims.getId());
        try {
            List<Exam> exams = exam_proctorMapper.findExamsByProctorID(userID);
            if (!exams.isEmpty()) {
                return ResponseEntity.ok(response.success("查询要监考的考试信息成功！", exams));
            } else {
                return ResponseEntity.ok(response.failure("未找到相关的考试信息！", null));
            }
        } catch (Exception e) {
            return ResponseEntity.ok(response.failure("查询要监考的考试信息失败！" + e.getMessage(), null));
        }
    }

}
