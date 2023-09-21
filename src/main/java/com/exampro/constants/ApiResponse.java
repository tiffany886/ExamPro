package com.exampro.constants;

import com.exampro.exception.ServiceException;

public class ApiResponse<T> {
    /**
     * 成功默认消息
     */
    private static final Integer CODE_SUCCESS = 0;
    private static final String MSG_SUCCESS = "操作成功！";

    /**
     * 失败默认消息
     */
    private static final Integer CODE_FAILURE = 1;
    private static final String MSG_FAILURE = "请求失败！";

    /**
     * 完成消息构造
     * @param code
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public  <T> ApiRest<T> message(Integer code, String message, T data){
        ApiRest<T> response = new ApiRest<>();
        response.setCode(code);
        response.setMsg(message);
        if(data!=null) {
            response.setData(data);
        }
        return response;
    }

    /**
     * 请求成功空数据
     * @param <T>
     * @return
     */
    public <T> ApiRest<T> success(){
        return message(0, "请求成功！", null);
    }



    /**
     * 请求成功，通用代码
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public <T> ApiRest<T> success(String message, T data){
        return message(CODE_SUCCESS, message, data);
    }


    /**
     * 请求成功，仅内容
     * @param data
     * @param <T>
     * @return
     */
    public <T> ApiRest<T> success(T data){
        return message(CODE_SUCCESS, MSG_SUCCESS, data);
    }


    /**
     * 请求失败，完整构造
     * @param code
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public <T> ApiRest<T> failure(Integer code, String message, T data){
        return message(code, message, data);
    }

    /**
     * 请求失败，消息和内容
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public <T> ApiRest<T> failure(String message, T data){
        return message(CODE_FAILURE, message, data);
    }

    /**
     * 请求失败，消息
     * @param message
     * @return
     */
    public <T> ApiRest<T> failure(String message){
        return message(CODE_FAILURE, message, null);
    }

    /**
     * 请求失败，仅内容
     * @param data
     * @param <T>
     * @return
     */
    public <T> ApiRest<T> failure(T data){
        return message(CODE_FAILURE, MSG_FAILURE, data);
    }


    /**
     * 请求失败，仅内容
     * @param <T>
     * @return
     */
    public <T> ApiRest<T> failure(){
        return message(CODE_FAILURE, MSG_FAILURE, null);
    }



    /**
     * 请求失败，仅内容
     * @param <T>
     * @return
     */
    public <T> ApiRest<T> failure(ApiError error, T data){
        return message(error.getCode(), error.msg, data);
    }



    /**
     * 请求失败，仅内容
     * @param ex
     * @param <T>
     * @return
     */
    public <T> ApiRest<T> failure(ServiceException ex){
        ApiRest<T> apiRest = message(ex.getCode(), ex.getMsg(), null);
        return apiRest;
    }
}
