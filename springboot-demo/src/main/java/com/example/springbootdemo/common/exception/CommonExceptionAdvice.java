package com.example.springbootdemo.common.exception;

import com.example.springbootdemo.common.ResultVO;
import com.example.springbootdemo.common.ResultVOBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.nio.file.AccessDeniedException;

/**
 * 全局异常处理
 *
 * @author jiancheng
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class CommonExceptionAdvice {

    @Autowired
    private ResultVOBuilder resultVOBuilder;

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultVO handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("缺少请求参数", e);
        return resultVOBuilder.failure("global.exception.required_parameter_is_not_present");
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultVO handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("参数解析失败", e);
        return resultVOBuilder.failure("global.exception.could_not_read_json");
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("参数验证失败", e);
        return resultVOBuilder.failure("global.exception.valid_error");
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ResultVO handleBindException(BindException e) {
        log.error("参数绑定失败", e);
        return resultVOBuilder.failure("global.exception.bind_error");
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultVO handleServiceException(ConstraintViolationException e) {
        log.error("参数验证失败", e);
        return resultVOBuilder.failure("global.exception.violation_error");
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public ResultVO handleServiceException(AccessDeniedException accessDeniedException) {
        log.warn("访问拒绝", accessDeniedException);
        return resultVOBuilder.failure("global.exception.access_deny");
    }


    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ResultVO handleValidationException(ValidationException e) {
        log.error("参数验证失败", e);
        return resultVOBuilder.failure("global.exception.validation_exception");
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultVO handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("不支持当前请求方法", e);
        return resultVOBuilder.failure("global.exception.request_method_not_supported");
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResultVO handleHttpMediaTypeNotSupportedException(Exception e) {
        log.error("不支持当前媒体类型", e);
        return resultVOBuilder.failure("global.exception.content_type_not_supported");
    }


    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResultVO handleException(Exception e) {
        log.error("服务器异常", e);
        return resultVOBuilder.failure("global.exception.500_error");
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ResultVO handleRuntimeException(Exception e) {
        log.error("服务器异常", e);
        return resultVOBuilder.failure("global.exception.500_error", e.getMessage());
    }

    /**
     * 操作数据库出现异常:名称重复，外键关联
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResultVO handleException(DataIntegrityViolationException e) {
        log.error("操作数据库出现异常:", e);
        return resultVOBuilder.failure("global.exception.database_error");
    }
}
