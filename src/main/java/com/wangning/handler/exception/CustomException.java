package com.wangning.handler.exception;

import com.wangning.enums.ResultCode;
import lombok.Data;

/**
 * @ClassName CustomException
 * @Description TODO
 * @date 28/4/2022 下午2:26
 * @Version 1.0
 */
@Data
public class CustomException extends RuntimeException {

    private Integer code;
    private String message;

    public CustomException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CustomException (ResultCode resultCode){
        this.setCode(resultCode.code());
        this.setMessage(resultCode.message());
    }

}