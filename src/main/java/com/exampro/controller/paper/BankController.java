package com.exampro.controller.paper;

import com.exampro.constants.ApiResponse;
import com.exampro.constants.ApiRest;
import com.exampro.mapper.QuestionbankMapper;
import com.exampro.model.Questionbank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
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
