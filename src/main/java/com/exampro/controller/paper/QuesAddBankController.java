package com.exampro.controller.paper;

import com.exampro.constants.ApiResponse;
import com.exampro.constants.ApiRest;
import com.exampro.mapper.paper.QuesAddBankMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于在题库中加题目
 */
@RestController
@RequestMapping("/user")
@Api(tags = "在题库中加题目")
public class QuesAddBankController {
    @Autowired
    private QuesAddBankMapper quesAddBankMapper;

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
        int row = quesAddBankMapper.addQuesInBank(Integer.parseInt(bankId),Integer.parseInt(questionId));
            if(row>0){
                return ResponseEntity.ok(response.success("插入成功",true));
            }else {
                return ResponseEntity.ok(response.success("插入失败",false));
            }
    }
}
