package com.exampro.controller.exam;

import com.exampro.constants.ApiResponse;
import com.exampro.mapper.exam.ExamMapper;
import com.exampro.mapper.exam.ExamrecordMapper;
import com.exampro.mapper.exam.ExamregistrationMapper;
import com.exampro.model.User;
import com.exampro.model.exam.Exam;
import com.exampro.model.exam.ExamInfoDTO;
import com.exampro.model.exam.Examrecord;
import com.exampro.model.exam.UserExam;
import com.exampro.utils.jwt.JwtTokenUtil;
import com.exampro.utils.paper.DateFormat;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
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
     * 注入examregistrationMapper
     */
    @Autowired
    private ExamregistrationMapper examregistrationMapper;

    /**
     * 注入ExamrecordMapper
     */
    @Autowired
    private ExamrecordMapper examrecordMapper;

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
     * 查询通过终审的全部考试
     */
    @GetMapping("/userExamsPassAll")
    @ApiOperation("查询所有通过终审的考试")
    public ResponseEntity<?> userExamsPassAll() {
        ApiResponse<List<ExamInfoDTO>> response = new ApiResponse<>();
        // 解析token获取用户id
        List<ExamInfoDTO> data = examMapper.findExamsPassAll();
        return ResponseEntity.ok(response.success("查询成功！",data));
    }
    /**
     * 查询用户报名的考试
     */
    @GetMapping("/findExamineeExams")
    @ApiOperation("查询考生报名的考试")
    public ResponseEntity<?> findExamineeExams(@RequestHeader("Authorization") String token) {
        ApiResponse<List<UserExam>> response = new ApiResponse<>();
        // 解析token获取用户id
        Claims claims = jwtTokenUtil.parseToken(token);
        Integer userID = Integer.parseInt(claims.getId());
        List<UserExam> data = examMapper.findExamineeExams(userID);
        return ResponseEntity.ok(response.success("查询成功！",data));
    }

    /**
     * 查询试卷的全部学生
     */
    @GetMapping("/examRegistUsers")
    @ApiOperation("查询报名考试的考生")
    public ResponseEntity<?> examRegistUsers(Integer examId) {
        ApiResponse<List<ExamInfoDTO>> response = new ApiResponse<>();
        // 解析token获取用户id
        List<User> data = examMapper.findExamRegistUsers(examId);
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
            System.out.println(startTime);
            System.out.println(beginTime);
            Exam exam = new Exam(examName,examDescription,paperID,beginTime,examDuration,userID);
            int result  = examMapper.addExam(exam);
            if (result > 0) {
                HashMap data = new HashMap();
                data.put("examID",exam.getExamID());
                return ResponseEntity.ok(response.success("创建考试成功！",data));
            }else{
                return ResponseEntity.ok(response.success("创建考试失败！请重新尝试！",false));
            }

        }catch (Exception e){
            return ResponseEntity.ok(response.failure("创建考试失败！" + e.getMessage(),false));
        }
    }
    /**
     * 查询通过初审的考试
     */
    @GetMapping("/examsPassJunior")
    @ApiOperation("查询通过初审的考试")
    public ResponseEntity<?> examsPassJunior() {
        ApiResponse<List<ExamInfoDTO>> response = new ApiResponse<>();
        List<ExamInfoDTO> data = examMapper.findExamsPassJunior();
        return ResponseEntity.ok(response.success("查询成功！", data));
    }

    @GetMapping("/addExamRecord")
    @ApiOperation("新增考生的考试记录")
    public ResponseEntity<?> addExamRecord(
            @RequestParam("paperId") Integer paperId,
            @RequestParam("questionId") Integer questionId,
            @RequestParam("studentAnswer") String studentAnswer,
            @RequestParam("score") Integer score,
            @RequestParam("totalScore") Integer totalScore,
            @RequestParam("examId") Integer examId,
            @RequestHeader("Authorization") String token
    ) {
        ApiResponse<List<ExamInfoDTO>> response = new ApiResponse<>();
        Claims claims = jwtTokenUtil.parseToken(token);
        Integer userID = Integer.parseInt(claims.getId());
        Examrecord examRecord = new Examrecord();
        examRecord.setPaperId(paperId);
        examRecord.setQuestionId(questionId);
        examRecord.setStudentAnswer(studentAnswer);
        examRecord.setScore(score);
        examRecord.setTotalScore(totalScore);
        examRecord.setExamId(examId);
        examRecord.setUserId(userID);

        int result = examrecordMapper.insertExamRecord(examRecord);

        if (result > 0) {
            // 插入成功
            return ResponseEntity.ok(response.success("考试记录插入成功！"));
        } else {
            // 插入失败
            return ResponseEntity.badRequest().body("考试记录插入失败");
        }
    }

    /**
     * 判断是否有考试记录，则不可做题 isUserDoneExam
     */
    @GetMapping("/isUserDoneExam")
    @ApiOperation("判断是否有考试记录")
    public ResponseEntity<?> isUserDoneExam(@RequestHeader("Authorization") String token,@RequestParam("examId") Integer examId) {
        ApiResponse<List<ExamInfoDTO>> response = new ApiResponse<>();
        Claims claims = jwtTokenUtil.parseToken(token);
        Integer userID = Integer.parseInt(claims.getId());
        List<Examrecord> data = examrecordMapper.findUserDoneExam(userID,examId);
        if(!data.isEmpty()){
            return ResponseEntity.ok(response.success("已交卷", true));
        }else {
            return ResponseEntity.ok(response.success("未交卷", false));
        }
    }

    /**
     * 根据用户id获取考试记录 selectAllExamRecord
     */
    @PostMapping("/getAllExamRecord")
    @ApiOperation("根据用户id获取考试记录")
    public ResponseEntity<?> getAllExamRecord(@RequestHeader("Authorization") String token,@RequestParam("examId") Integer examId) {
        ApiResponse<List<ExamInfoDTO>> response = new ApiResponse<>();
        Claims claims = jwtTokenUtil.parseToken(token);
        Integer userID = Integer.parseInt(claims.getId());
        List<Examrecord> data = examrecordMapper.selectAllExamRecord(examId,userID);
        if(!data.isEmpty()){
            return ResponseEntity.ok(response.success("查询成功", data));
        }else {
            return ResponseEntity.ok(response.success("查询失败", false));
        }
    }

    /**
     * 更新学生成绩 updateUserExamScore
     */
    @GetMapping("/updateUserExamScore")
    @ApiOperation("更新学生成绩")
    public ResponseEntity<?> updateUserExamScore(@RequestHeader("Authorization") String token,@RequestParam("examId") Integer examId,@RequestParam("questionId") Integer questionId,@RequestParam("score") Integer score){
        Claims claims = jwtTokenUtil.parseToken(token);
        Integer userID = Integer.parseInt(claims.getId());
        ApiResponse<List<ExamInfoDTO>> response = new ApiResponse<>();
        int data = examrecordMapper.updateUserExamScore(userID,examId,questionId,score);
        if(data == 1){
            return ResponseEntity.ok(response.success("插入成功！", true));
        }else {
            return ResponseEntity.ok(response.failure("插入失败！", false));

        }

    }

    /**
     * 获取学生考试记录 getUserExamRecord
     */
}
