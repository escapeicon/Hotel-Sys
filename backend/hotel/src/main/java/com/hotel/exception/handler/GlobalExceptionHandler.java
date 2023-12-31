package com.hotel.exception.handler;

import com.hotel.common.Result;
import com.hotel.common.StandardCode;
import com.hotel.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 *
 * @author 小李哞哞
 * @date 2023/5/23
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result handleServiceException(ServiceException se) {
        se.printStackTrace();
        return Result.error(se.getCode(), se.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error(StandardCode.CODE_500, e.getMessage());
    }
}
