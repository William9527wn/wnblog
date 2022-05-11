package com.wangning.handler;

/**
 * @ClassName Result
 * @Description TODO
 * @date 28/4/2022 下午2:07
 * @Version 1.0
 */
import java.io.Serializable;

import com.wangning.enums.ResultCode;
import lombok.Data;

/**
 * Created by zhumaer on 17/5/24.
 */
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = -3948389268046368059L;

    private Integer code;

    private String msg;

    private Object data;

    public Result() {}

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result failure(ResultCode resultCode) {
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }
    public static Result failure() {
        Result result = new Result();
        result.setResultCode(ResultCode.USER_LOGIN_ERROR);
        return result;
    }

    public static Result failure(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public void setResultCode(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
    }
}

