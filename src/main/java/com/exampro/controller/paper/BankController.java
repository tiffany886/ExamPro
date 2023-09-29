package com.exampro.controller.paper;

import com.exampro.constants.ApiResponse;
import com.exampro.constants.ApiRest;
import com.exampro.mapper.paper.QuestionbankMapper;
import com.exampro.model.paper.Questionbank;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/index")
@Api(tags = "题库接口") // 这里定义了API的标签，可以用来分组接口
public class BankController {
    @Autowired
    private QuestionbankMapper questionbankMapper;
    ApiResponse<Boolean> response = new ApiResponse<>();
    List<Object> emptyList = new ArrayList<>();

    /**
     * 查询所有题库
     * @return
     */
    @GetMapping(value="/searchAllBank")
    @ApiOperation("查询所有题库") // 在这里定义接口的名字
    public ResponseEntity<ApiRest<?>> searchAllQues(){
        List<Questionbank> rows=questionbankMapper.selectAllBank();
        System.out.println(rows);
        if(rows.isEmpty()){
            return ResponseEntity.ok(response.success("没有题库",emptyList));
        }else {
            return ResponseEntity.ok(response.success("查询成功",rows));
        }
    }

    /**
     * 根据用户id查询题库
     * @param userId
     * @return
     */
    @GetMapping(value = "/searchBankById")
    @ApiOperation("根据用户id查询题库")
    public ResponseEntity<ApiRest<?>> searchBankById(String userId){
        List<Questionbank> rows=questionbankMapper.selectBankById(Integer.parseInt(userId));
        System.out.println(rows);
        if(rows.isEmpty()){
            return ResponseEntity.ok(response.success("没有题库",emptyList));
        }else {
            return ResponseEntity.ok(response.success("查询成功",rows));
        }
    }

    @PostMapping(value = "/addBank",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("添加题库")
    public ResponseEntity<ApiRest<Boolean>> addBank(@RequestParam("bankname") String bankName,
                                                        @RequestParam("userid") String userId){
        Questionbank questionbank = new Questionbank(bankName,Integer.parseInt(userId));
        int row = questionbankMapper.addBank(questionbank);
        if(row>0){
            return ResponseEntity.ok(response.success("插入成功",true));
        }else {
            return ResponseEntity.ok(response.success("插入失败",false));
        }
    }
}
