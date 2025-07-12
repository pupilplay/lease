package com.study.lease.common.exception;

import com.study.lease.common.result.Result;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

/**
 * ClassName: GlobalExceptionHandler
 * Package: com.study.lease.common.exception
 * Description:
 *
 * @Author pupil
 * @Create 2025/4/28 18:16
 * @Version 1.0
 */
@Hidden
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({SQLException.class})
    @ResponseBody
    public Result handle(Exception e) {
        return Result.fail();
    }

    @ExceptionHandler({LeaseException.class})
    @ResponseBody
    public Result handle(LeaseException e) {
        e.printStackTrace();
        return Result.fail(e.getCode(), e.getMessage());
    }
}
