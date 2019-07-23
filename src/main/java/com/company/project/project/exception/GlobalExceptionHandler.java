package com.company.project.project.exception;

import com.company.project.project.core.Result;
import com.company.project.project.core.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;


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

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("发生未知异常：", e);
        return Result.fail(ResultCode.UNKONW.code(), ResultCode.UNKONW.message());
    }

}
