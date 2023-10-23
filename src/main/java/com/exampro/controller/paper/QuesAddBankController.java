package com.exampro.controller.paper;

import com.exampro.constants.ApiResponse;
import com.exampro.constants.ApiRest;
import com.exampro.mapper.paper.QuesAddBankMapper;
import com.exampro.mapper.paper.QuestionbankMapper;
import com.exampro.model.paper.Bankquestion;
import com.exampro.model.paper.Questionbank;
import com.exampro.model.paper.Questionpool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.exampro.utils.paper.transformQuesData.transformData;

/**
 * 用于在题库中加题目
 */
@RestController
@RequestMapping("/index")
@Api(tags = "在题库中加题目")
public class QuesAddBankController {
    @Autowired
    private QuesAddBankMapper quesAddBankMapper;
    @Autowired
    private QuestionbankMapper questionbankMapper;
    List<Object> emptyList = new ArrayList<>();

    ApiResponse<Boolean> response = new ApiResponse<>();

    /**
     * 在题库中加题目
     * @param bankId
     * @param questionId
     * @return
     */
    @PostMapping(value = "/addQuesInBank",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("题库中加题目")
    public ResponseEntity<ApiRest<Boolean>> addQuestion(@RequestParam("bankid") String bankId,
                                                        @RequestParam("questionid") String questionId){
        List<Questionpool> bankIds = quesAddBankMapper.selectBankQuesByBankId(Integer.parseInt(bankId));
        for(Questionpool questionbank : bankIds ){
            if((questionbank.getQuestionId()).equals((Integer.parseInt(questionId)))){
                return ResponseEntity.ok(response.failure("你已经将"+questionId+"号题加入"+bankId+"号题库",false));
            }
        }
        int row = quesAddBankMapper.addQuesInBank(Integer.parseInt(bankId),Integer.parseInt(questionId));
            if(row>0){
                return ResponseEntity.ok(response.success("成功将"+questionId+"号题加入"+bankId+"号题库",true));
            }else {
                return ResponseEntity.ok(response.failure("插入失败",false));
            }
    }


    @PostMapping(value = "/selectBankQuesByBankId",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("查找题库中加题目")
    public ResponseEntity<ApiRest<?>> addQuestion(@RequestParam("bankid") String bankId){
        List<Questionpool> rows = quesAddBankMapper.selectBankQuesByBankId(Integer.parseInt(bankId));
        if(rows.isEmpty()){
            return ResponseEntity.ok(response.success("没有题目",emptyList));
        }else {
            List<HashMap<String,?>> res = transformData(rows);
            return ResponseEntity.ok(response.success("查询成功",res));
        }
    }

    @PostMapping(value = "/selectBankQuesPass",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("查找题库中通过的题目")
    public ResponseEntity<ApiRest<?>> selectBankQuesPass(@RequestParam("bankid") String bankId){
        List<Questionpool> rows = quesAddBankMapper.selectBankQuesPass(Integer.parseInt(bankId));
        if(rows.isEmpty()){
            return ResponseEntity.ok(response.success("没有题目",emptyList));
        }else {
            List<HashMap<String,?>> res = transformData(rows);
            return ResponseEntity.ok(response.success("查询成功",res));
        }
    }
}
