package com.exampro.controller.paper;

import com.exampro.constants.ApiResponse;
import com.exampro.constants.ApiRest;
import com.exampro.mapper.PapermanagementMapper;
import com.exampro.model.paper.Papermanagement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.exampro.util.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "试卷接口")
public class PaperController {
    @Autowired
    private PapermanagementMapper papermanagementMapper;

    List<Object> emptyList = new ArrayList<>();
    ApiResponse<Boolean> response = new ApiResponse<>();

    DateFormat dateFormat = new DateFormat();
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
    public ResponseEntity<ApiRest<Boolean>> addPaper(@RequestParam("paperName") String paperName,
                                                     @RequestParam("objectiveScore") String objectiveScore,
                                                     @RequestParam("subjectiveScore") String subjectiveScore,
                                                     @RequestParam("startTime") String startTime,
                                                     @RequestParam("numberOfExaminees") String numberOfExaminees,
                                                     @RequestParam("userId") String userId,
                                                     @RequestParam("duration") String duration) throws ParseException {
        Papermanagement papermanagement = new Papermanagement(paperName,Integer.parseInt(objectiveScore),Integer.parseInt(subjectiveScore), dateFormat.stringToDate(startTime),Integer.parseInt(numberOfExaminees),Integer.parseInt(userId),Integer.parseInt(duration));
        int row = papermanagementMapper.insert(papermanagement);
        if(row>0){
            return ResponseEntity.ok(response.success("插入成功",true));
        }else {
            return ResponseEntity.ok(response.success("插入失败",false));
        }
    }
}
