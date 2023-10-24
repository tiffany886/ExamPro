package com.exampro.controller.paper;

import com.exampro.constants.ApiResponse;
import com.exampro.constants.ApiRest;
import com.exampro.mapper.paper.PapermanagementMapper;
import com.exampro.mapper.paper.PaperquestionMapper;
import com.exampro.model.paper.Paperquestion;
import com.exampro.model.paper.Papermanagement;
import com.exampro.model.paper.paperQuesItem;
import com.exampro.utils.jwt.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exampro.utils.paper.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/paper")
@Api(tags = "试卷接口")
public class PaperController {
    @Autowired
    private PapermanagementMapper papermanagementMapper;

    List<Object> emptyList = new ArrayList<>();

    ApiResponse<Boolean> response = new ApiResponse<>();

    DateFormat dateFormat = new DateFormat();

    /**
     * 注入 JwtTokenUtil
     */
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    /**
     * 注入试卷题目mapper
     */
    @Autowired
    private PaperquestionMapper paperquestionMapper;


    /**
     * 查询试卷
     * @return
     */
    @GetMapping("/searchPaper")
    @ApiOperation("查询试卷")
    public ResponseEntity<ApiRest<?>> searchPaper(){
        List<Papermanagement> rows = papermanagementMapper.selectAllPaper();
        if(rows.isEmpty()){
            return ResponseEntity.ok(response.success("没有试卷",emptyList));
        }else {
            return ResponseEntity.ok(response.success("查询成功",rows));
        }
    }

    /**
     * 添加试卷
     * (#{PaperName}, #{ObjectiveScore}, #{TotalScore}, #{SubjectiveScore}, #{StartTime}, #{EndTime},#{NumberOfExaminees}, #{UserID}
     * @return
     */
    @PostMapping("/addPaper")
    @ApiOperation("添加试卷")
    public ResponseEntity<ApiRest<HashMap>> addPaper(@RequestHeader("Authorization") String token,
                                                     @RequestParam("paperName") String paperName,
                                                     @RequestParam("objectiveScore") String objectiveScore,
                                                     @RequestParam("subjectiveScore") String subjectiveScore,
                                                     @RequestParam("totalScore") String totalScore) throws ParseException {

        ApiResponse<HashMap> response = new ApiResponse<>();
        // 解析token获取用户id
        Claims claims = jwtTokenUtil.parseToken(token);
        Integer userId = Integer.parseInt(claims.getId());

        // 在这里进行类型转换
        Integer objScore = Integer.parseInt(objectiveScore);
        Integer totScore = Integer.parseInt(totalScore);
        Integer subScore = Integer.parseInt(subjectiveScore);

        Papermanagement papermanagement = new Papermanagement(paperName,objScore,totScore,subScore,userId);
        int result = papermanagementMapper.insertPaper(papermanagement);

        if (result > 0) {
            HashMap data = new HashMap();
            data.put("paperId",papermanagement.getPaperId());
            return ResponseEntity.ok(response.success("添加试卷成功",data));
        } else {
            return ResponseEntity.ok(response.failure("添加试卷失败",null));
        }
    }

    /**
     * 根据试卷id查询试卷
     */
    @PostMapping("/searchPaperById")
    @ApiOperation("根据试卷id查找试卷")
    public ResponseEntity<ApiRest<?>> searchPaperById(@RequestParam("paperId") String paperId){
        List<Papermanagement> rows = papermanagementMapper.selectPaperById(Integer.parseInt(paperId));
        if(rows.isEmpty()){
            return ResponseEntity.ok(response.success("没有试卷",emptyList));
        }else {
            return ResponseEntity.ok(response.success("查询成功",rows));
        }
    }

    /**
     * 查询通过初审的卷子
     */
    @GetMapping("/searchPaperPassJunior")
    @ApiOperation("查询通过初审的卷子")
    public ResponseEntity<ApiRest<?>> searchPaperPassJunior(){
        List<Papermanagement> rows = papermanagementMapper.selectPaperPassJunior();
        if(rows.isEmpty()){
            return ResponseEntity.ok(response.success("没有试卷",emptyList));
        }else {
            return ResponseEntity.ok(response.success("查询成功",rows));
        }
    }
    /**
     * 向试卷添加题目
     */
    @PostMapping("/addQuesById")
    @ApiOperation("向试卷添加题目")
    public ResponseEntity<ApiRest<?>> addQuesById(@RequestBody List<Paperquestion> paperquestions) {
        try {
            for (Paperquestion question : paperquestions) {
                System.out.println(question);
                int result = paperquestionMapper.insertPaperQuestion(
                        question.getPaperid(),
                        question.getQuestionid(),
                        question.getQuestiontype(),
                        question.getScore()
                );

                if (result <= 0) {
                    return ResponseEntity.ok(response.failure("该条数据插入失败！题号为: " + question.getQuestionid()));
                }
            }

            return ResponseEntity.ok(response.success("所有题目插入成功", true));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(response.failure("插入题目失败！" + e.getMessage()));
        }
    }

    /**
     * 根据试卷id获取所拥有的题目
     */
    @PostMapping("/findQuesByPaperId")
    @ApiOperation("根据试卷id获取所拥有的题目")
    public ResponseEntity<ApiRest<?>> findQuesByPaperId(@RequestParam("paperId") String paperId) {

        try {
            List<paperQuesItem> paperQuesList = paperquestionMapper.findQuesByPaperId(Integer.parseInt(paperId));

            if (paperQuesList.size() <= 0) {
                return ResponseEntity.ok(response.failure("出现错误，试卷题目查询失败",false));
            }else{
                return ResponseEntity.ok(response.success("该试卷题目查询成功", paperQuesList));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(response.failure("试卷题目查询失败！" + e.getMessage()));
        }
    }
}
