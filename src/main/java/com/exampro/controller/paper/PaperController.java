package com.exampro.controller.paper;

import com.exampro.constants.ApiResponse;
import com.exampro.constants.ApiRest;
import com.exampro.mapper.paper.PapermanagementMapper;
import com.exampro.model.exam.ExamInfoDTO;
import com.exampro.model.paper.Papermanagement;
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
     */
    @PostMapping("/addPaper")
    @ApiOperation("添加试卷")
    public ResponseEntity<ApiRest<Boolean>> addPaper(@RequestHeader("Authorization") String token,
                                                     @RequestParam("paperName") String paperName,
                                                     @RequestParam("objectiveScore") String objectiveScore,
                                                     @RequestParam("subjectiveScore") String subjectiveScore,
                                                     @RequestParam("totalScore") String totalScore) throws ParseException {

        ApiResponse<List<ExamInfoDTO>> response = new ApiResponse<>();
        // 解析token获取用户id
        Claims claims = jwtTokenUtil.parseToken(token);
        Integer userID = Integer.parseInt(claims.getId());

        // 在这里进行类型转换
        Integer objScore = Integer.parseInt(objectiveScore);
        Integer totScore = Integer.parseInt(totalScore);
        Integer subScore = Integer.parseInt(subjectiveScore);

        int result = papermanagementMapper.insertPaper(paperName, objScore, totScore, subScore, userID);

        if (result > 0) {
            return ResponseEntity.ok(response.success("添加试卷成功", true));
        } else {
            return ResponseEntity.ok(response.failure("添加试卷失败",false));
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
}
