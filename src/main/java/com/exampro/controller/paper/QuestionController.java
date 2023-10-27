package com.exampro.controller.paper;

import com.exampro.constants.ApiResponse;
import com.exampro.constants.ApiRest;
import com.exampro.mapper.paper.QuestionpoolMapper;
import com.exampro.model.paper.Questionpool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.exampro.utils.paper.DateFormat.dateToString;
import static com.exampro.utils.paper.DateFormat.stringToDate;
import static com.exampro.utils.paper.transformQuesData.transformData;

@RestController
@RequestMapping("/index")
@Api(tags = "题目相关接口")
public class QuestionController {
    @Autowired
    private QuestionpoolMapper questionpoolMapper;

    List<Object> emptyList = new ArrayList<>();

    /**
     * 获取全部题目
     */
    @ApiOperation("获取全部题目")
    @PostMapping(value="/searchAllQues",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<?>> searchAllQues(){
        ApiResponse<Boolean> response = new ApiResponse<>();
        List<Questionpool> rows=questionpoolMapper.selectAllQuestion();

        if(rows.isEmpty()){
            return ResponseEntity.ok(response.success("没有题目",emptyList));
        }else {
            return ResponseEntity.ok(response.success("查询成功",rows));
        }
    }

    /**
     * 根据id获取对应的题目池
     */

    @PostMapping(value="/searchQuesByUserId",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("根据id获取对应的题目池")
    public ResponseEntity<ApiRest<?>> searchQuesByUserId(@RequestParam("userid") String userId){
        ApiResponse<Boolean> response = new ApiResponse<>();
        // System.out.println("--- userId="+userId);
        List<Questionpool> rows=questionpoolMapper.selectByPrimaryKey(Integer.parseInt(userId));
        if(rows.isEmpty()){
            return ResponseEntity.ok(response.success("没有题目",emptyList));
        }else {
            List<HashMap<String,?>> res = transformData(rows);
            return ResponseEntity.ok(response.success("查询成功",res));
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
    @ApiOperation("添加题目")
    public ResponseEntity<ApiRest<?>> addQuestion(@RequestParam("questiontype") String questionType,
                                                        @RequestParam("questiondescription") String questionDescription,
                                                        @RequestParam("userid") String userId,
                                                        @RequestParam("questionanswer") String questionAnswer,
                                                        @RequestParam("questionscore") String questionScore
                                                        ){
        ApiResponse<Boolean> response = new ApiResponse<>();
        Questionpool questionpool = new Questionpool(questionType,questionDescription,Integer.parseInt(userId),questionAnswer,Integer.parseInt(questionScore));
        int row = questionpoolMapper.addQuestion(questionpool);
        if(row>0){
            Integer questionId = questionpool.getQuestionId(); // 获取自动生成的 questionId
            System.out.println(questionId);
            return ResponseEntity.ok(response.success("新增成功",questionId));
        }else {
            return ResponseEntity.ok(response.success("插入失败",false));
        }
    }

//    /**
//     * 查询通过审核的题目 selectQuesPass
//     */
//    @ApiOperation("查询通过审核的题目")
//    @GetMapping(value="/selectQuesPass",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ApiRest<?>> selectQuesPass(){
//        ApiResponse<Boolean> response = new ApiResponse<>();
//        List<Questionpool> rows=questionpoolMapper.selectQuesPass();
//        if(rows.isEmpty()){
//            return ResponseEntity.ok(response.success("没有题目",emptyList));
//        }else {
//            return ResponseEntity.ok(response.success("查询成功",rows));
//        }
//    }

    /**
     * 获取题目池的页数
     */
    @PostMapping("/getQuestionPoolPageCount")
    @ApiOperation("获取题目池的页数")
    public ResponseEntity<ApiRest<?>> getQuestionPoolPageCount(@RequestParam("pageSize") int pageSize) {
        ApiResponse<Integer> response = new ApiResponse<>();
        int totalRecords = questionpoolMapper.getTotalQuestionPoolRecords(); // 你需要实现这个方法
        int pageCount = (int) Math.ceil((double) totalRecords / pageSize);
        HashMap data = new HashMap();
        data.put("pageCount",pageCount);
        return ResponseEntity.ok(response.success("获取题目池页数成功", data));
    }

    /**
     * 分页获取通过的题目
     * @param page
     * @param pageSize
     * @return
     */
    @ApiOperation("分页获取通过的题目")
    @PostMapping(value = "/selectQuesPass", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiRest<?>> searchAllQues(
            @RequestParam("page") int page, // 页码
            @RequestParam("pageSize") int pageSize // 每页记录数
    ) {
        ApiResponse<Boolean> response = new ApiResponse<>();
        // 计算分页查询的起始索引
        int startIndex = (page - 1) * pageSize;
        List<Questionpool> rows = questionpoolMapper.selectQuestionWithPage(startIndex, pageSize);

        if (rows.isEmpty()) {
            return ResponseEntity.ok(response.success("没有题目", emptyList));
        } else {
            return ResponseEntity.ok(response.success("查询成功", rows));
        }
    }
}
