package com.example.springbootdemo.common.utils;

import com.example.springbootdemo.common.ResultVO;
import com.example.springbootdemo.common.ResultVOBuilder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * 验证工具类
 *
 * @author jiancheng
 * @date 2019-5-14
 */
public class ValidateUtils {

    /**
     * 校验值对象是否符合规则
     *
     * @param resultVOBuilder
     * @param bindingResult
     * @param <T>
     * @return
     */
    public static <T> ResultVO<T> validate(ResultVOBuilder resultVOBuilder, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> filedErrors = bindingResult.getFieldErrors();
            for (FieldError filedError : filedErrors) {
                return resultVOBuilder.failure(filedError.getDefaultMessage());
            }
        }
        return ResultVOBuilder.success(null);
    }


}
