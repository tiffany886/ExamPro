package com.exampro.exception;

import com.exampro.constants.ApiRest;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理类
 * @author bool 
 * @date 2019-06-21 19:27
 */
@RestControllerAdvice
public class ServiceExceptionHandler {

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initWebBinder(WebDataBinder binder){

    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttribute(Model model) {
        
    }

    /**
     * 捕获ServiceException
     * @param e
     * @return
     */

    @ExceptionHandler({com.exampro.exception.ServiceException.class})
    @ResponseStatus(HttpStatus.OK)
    public ApiRest serviceExceptionHandler(ServiceException e) {
        return new ApiRest(e);
    }

}