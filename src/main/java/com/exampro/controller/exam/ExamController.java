package com.exampro.controller.exam;

import com.exampro.constants.ApiResponse;
import com.exampro.mapper.exam.ExamMapper;
import com.exampro.mapper.exam.ExamregistrationMapper;
import com.exampro.model.exam.Exam;
import com.exampro.model.exam.ExamInfoDTO;
import com.exampro.utils.jwt.JwtTokenUtil;
import com.exampro.utils.paper.DateFormat;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
     * 注入ExamMapper
     */
    @Autowired
    private ExamregistrationMapper examregistrationMapper;

    /**
     * 注入 JwtTokenUtil
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 查询所有考试
     */
    @GetMapping("/allExams")
    @ApiOperation("查询所有考试")
    public ResponseEntity<?> findAllExams() {
        ApiResponse<List<ExamInfoDTO>> response = new ApiResponse<>();
        List<ExamInfoDTO> data = examMapper.findAllExams();
        return ResponseEntity.ok(response.success("查询成功！", data));
    }

    /**
     * 通过用户id查询所拥有的考试
     */
    @GetMapping("/userExams")
    @ApiOperation("查询个人所有的考试")
    public ResponseEntity<?> findUserExams(@RequestHeader("Authorization") String token) {
        ApiResponse<List<ExamInfoDTO>> response = new ApiResponse<>();
        // 解析token获取用户id
        Claims claims = jwtTokenUtil.parseToken(token);
        Integer userID = Integer.parseInt(claims.getId());
        List<Exam> data = examMapper.findUserExams(userID);
        return ResponseEntity.ok(response.success("查询成功！",data));
    }

    /**
     * 立即报名
     */
    @PostMapping("/regExam")
    @ApiOperation("立即报名考试")
    public ResponseEntity<?> regExam(@RequestHeader("Authorization") String token, @RequestParam("examID") Integer examID){
        ApiResponse<List<ExamInfoDTO>> response = new ApiResponse<>();
        // 解析token获取用户id
        Claims claims = jwtTokenUtil.parseToken(token);
        Integer userID = Integer.parseInt(claims.getId());
        try{
            Integer[] userIds = examregistrationMapper.getUserIdsByExamID(examID);
            // 如果已经报名成功就不需要重复插入
            for (int i = 0; i < userIds.length; i++) {
                if(userIds[i].equals(userID)){
                    return ResponseEntity.ok(response.success("你已成功报名！"));
                }
            }

            Integer affectedRows = examregistrationMapper.regExam(examID,userID);
            if(affectedRows != 1){
                return ResponseEntity.ok("考试报名失败！请重新尝试！");
            }
            return ResponseEntity.ok(response.success("考试报名成功！"));
        }catch (Exception e){
            return ResponseEntity.ok(response.success("考试报名失败！" + e.getMessage()));
        }
    }

    /**
     * 添加考试
     */
    @PostMapping("/addExam")
    @ApiOperation("创建考试")
    public ResponseEntity<?> addExam(@RequestHeader("Authorization") String token,@RequestParam("examName") String examName,
                                     @RequestParam("examDescription") String examDescription, @RequestParam("paperID") Integer paperID,
                                     @RequestParam("startTime") String startTime, @RequestParam("examDuration") Integer examDuration){
        ApiResponse<List<ExamInfoDTO>> response = new ApiResponse<>();
        // 解析token获取用户id
        Claims claims = jwtTokenUtil.parseToken(token);
        Integer userID = Integer.parseInt(claims.getId());
        try{
            // 转换成时间格式
            Date beginTime = DateFormat.stringToDate(startTime);
            Integer affectedRows = examMapper.addExam(examName,examDescription,paperID,beginTime,examDuration,userID);
            if(affectedRows != 1){
                return ResponseEntity.ok(response.failure("创建考试失败！请重新尝试！"));
            }
            return ResponseEntity.ok(response.success("创建考试成功！"));
        }catch (Exception e){
            return ResponseEntity.ok(response.failure("创建考试失败！" + e.getMessage()));
        }
    }

}
