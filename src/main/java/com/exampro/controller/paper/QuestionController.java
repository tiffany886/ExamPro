package com.exampro.controller.paper;

import com.exampro.constants.ApiResponse;
import com.exampro.constants.ApiRest;
import com.exampro.mapper.QuestionpoolMapper;
import com.exampro.model.Questionpool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class QuestionController {
    @Autowired
    private QuestionpoolMapper questionpoolMapper;

    /**
     * 获取全部题目
     * @return
     */
    @PostMapping(value="/searchAllQues",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<?>> searchAllQues(){
        ApiResponse<Boolean> response = new ApiResponse<>();
        List<Questionpool> rows=questionpoolMapper.selectAllQuestion();
        if(rows.isEmpty()){
            return ResponseEntity.ok(response.success("没有题目",true));
        }else {
            return ResponseEntity.ok(response.success("查询成功",rows));
        }
    }
    /**
     * 根据id获取对应的题目池
     * @param userId
     * @return
     */
    @PostMapping(value="/searchQuesByUserId",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<?>> searchQuesByUserId(@RequestParam("userid") String userId){
        ApiResponse<Boolean> response = new ApiResponse<>();
        System.out.println("--- userId="+userId);
        List<Questionpool> rows=questionpoolMapper.selectByPrimaryKey(Integer.parseInt(userId));
        if(rows.isEmpty()){
            return ResponseEntity.ok(response.success("没有题目",true));
        }else {
            return ResponseEntity.ok(response.success("查询成功",rows));
        }
    }

    /**
     * 添加题目
     * @param questionType 题目类型
     * @param questionDescription 题目描述
     * @param userId 所属用户
     * @param questionAnswer 题目答案
     * @return 是否添加成功
     */
    @PostMapping(value = "/addQuestion",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<Boolean>> addQuestion(@RequestParam("questiontype") String questionType,
                                                        @RequestParam("questiondescription") String questionDescription,
                                                        @RequestParam("userid") String userId,
                                                        @RequestParam("questionanswer") String questionAnswer
                                                        ){
        ApiResponse<Boolean> response = new ApiResponse<>();
        Questionpool questionpool = new Questionpool(questionType,questionDescription,questionAnswer,Integer.parseInt(userId));
        int row = questionpoolMapper.addQuestion(questionpool);
        if(row>0){
            return ResponseEntity.ok(response.success("插入成功",true));
        }else {
            return ResponseEntity.ok(response.success("插入失败",false));
        }
    }
}
