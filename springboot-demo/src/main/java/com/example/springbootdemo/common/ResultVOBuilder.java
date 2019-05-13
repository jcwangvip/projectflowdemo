package com.example.springbootdemo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * ResultVO构建类
 *
 * @author jiancheng
 * @date 2019-5-13
 */
public class ResultVOBuilder {
    private static final Logger log = LoggerFactory.getLogger(ResultVOBuilder.class);
    private final ResourceBundleMessageSource messageSource;

    @Autowired
    public ResultVOBuilder(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }
    private ResultVOBuilder() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames(new String[]{"errorMessage", "constantMessage"});
        messageSource.setUseCodeAsDefaultMessage(true);
        this.messageSource = messageSource;
    }


    public static <T> ResultVO<T> success(T t) {
        ResultVO<T> result = new ResultVO();
        result.setData(t);
        result.setSuccess(true);
        return result;
    }

    public static <T> ResultVO<T> failure(ResultVO<T> origin) {
        rollback();
        return origin;
    }

    public <T> ResultVO<T> failure(String errorCode, Object... errorArgs) {
        rollback();
        return this.failureWithoutTransaction(errorCode, errorArgs);
    }

    public <T> ResultVO<T> failureWithoutTransaction(String errorCode, Object... errorArgs) {
        ResultVO<T> result = new ResultVO();
        this.appendError(result, errorCode, errorArgs);
        result.setErrorCode(errorCode);
        result.setErrorArgs(errorArgs);
        result.setErrorMessage(((Error)result.getErrors().get(0)).getMessage());
        result.setSuccess(false);
        log.warn(result.toString());
        return result;
    }

    public <T> ResultVO<T> appendError(ResultVO<T> resultVO, String errorCode, Object... errorArgs) {
        if (resultVO == null) {
            return this.failure(errorCode, errorArgs);
        } else {
            Error error = new Error();
            error.setCode(errorCode);
            error.setArgs(errorArgs);
            error.setMessage(this.messageSource.getMessage(errorCode, errorArgs, LocaleContextHolder.getLocale()));
            resultVO.addError(error);
            return resultVO;
        }
    }


    private static void rollback() {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            try {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            } catch (NoTransactionException var1) {
                log.error("not in transaction");
            }
        }
    }

    /*private static void rollback(TransactionStatus transactionStatus) {
        if (transactionStatus != null) {
            transactionStatus.setRollbackOnly();
        } else {
            log.warn("transactionStatus is null cannot rollback");
        }
    }*/



}
