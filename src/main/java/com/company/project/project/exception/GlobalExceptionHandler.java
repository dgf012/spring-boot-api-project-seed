package com.company.project.project.exception;

import com.alibaba.fastjson.JSONException;
import com.company.project.project.core.Result;
import com.company.project.project.core.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.StringJoiner;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public Result handleException(ServiceException e) {
        log.error("ServiceException：", e);
        return Result.fail(ResultCode.FAIL.code(), e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handleException(NoHandlerFoundException e, HttpServletRequest request) {
        return Result.fail(ResultCode.NOT_FOUND.code(), "[" + request.getRequestURI() + "]" + ResultCode.NOT_FOUND.message());
    }

    @ExceptionHandler(BindException.class)
    public Result handleException(BindException e) {
        log.error("表单绑定或校验失败：", e);
        List<ObjectError> list = e.getAllErrors();
        StringJoiner errorMsg = new StringJoiner(",");
        for (ObjectError objectError : list) {
            errorMsg.add(objectError.getDefaultMessage());
        }
        return Result.fail(ResultCode.ARGUMENTS_VALID_ERROR.code(), errorMsg.toString());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleException(MethodArgumentNotValidException e) {
        log.error("参数绑定或校验失败：", e);
        List<ObjectError> list = e.getBindingResult().getAllErrors();
        StringJoiner errorMsg = new StringJoiner(",");
        for (ObjectError objectError : list) {
            errorMsg.add(objectError.getDefaultMessage());
        }
        return Result.fail(ResultCode.ARGUMENTS_VALID_ERROR.code(), errorMsg.toString());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleException(HttpMessageNotReadableException e) {
        log.error("参数格式错误：", e);
        return Result.fail(ResultCode.ARGUMENTS_VALID_ERROR.code(), "参数格式错误");
    }

    @ExceptionHandler(JSONException.class)
    public Result handleException(JSONException e) {
        log.error("json格式错误：", e);
        return Result.fail(ResultCode.JSON_VALID_ERROR.code(), ResultCode.JSON_VALID_ERROR.message());
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("发生未知异常：", e);
        return Result.fail(ResultCode.UNKONW.code(), ResultCode.UNKONW.message());
    }

}
