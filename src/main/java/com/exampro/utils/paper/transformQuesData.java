package com.exampro.utils.paper;

import com.exampro.model.paper.Questionpool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.exampro.utils.paper.DateFormat.dateToString;

public class transformQuesData {
    /**
     * 将请求参数二次封装
     * @param responseData 数据库中查询的参数
     * @return 进行二次封装
     */
    public static List<HashMap<String,?>> transformData(List<Questionpool> responseData){
        List<HashMap<String,?>> transformedData = new ArrayList<>();
        for (Questionpool item : responseData){
            System.out.println(item);
            HashMap<String,Object> data = new HashMap<>();
            data.put("type",item.getQuestiontype());
            data.put("description",item.getQuestiondescription());
            data.put("answer",item.getQuestionanswer());
            data.put("createTime",dateToString(item.getCreatetime()));
            data.put("questionId",item.getQuestionid());
            transformedData.add(data);
        }
        return transformedData;
    }
}
