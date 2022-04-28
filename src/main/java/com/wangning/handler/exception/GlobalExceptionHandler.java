package com.wangning.handler.exception;


import com.wangning.enums.ResultCode;
import com.wangning.handler.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName GlobalException
 * @Description TODO
 * @date 28/4/2022 下午2:29
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     * @param e
     */
    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public Result bizExceptionHandler(CustomException e) {
        logger.error("发生业务异常！原因是：{}", e.getMessage());
        return new Result(e.getCode(), e.getMessage() );
    }

    /**
     * 处理空指针的异常
     * @param e
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public Result exceptionHandler(NullPointerException e) {
        logger.error("发生空指针异常！原因是:", e);
        return new Result(ResultCode.NULL_POINTER.code(),ResultCode.NULL_POINTER.message());
    }

}