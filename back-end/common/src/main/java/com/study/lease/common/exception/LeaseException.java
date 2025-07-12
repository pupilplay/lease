package com.study.lease.common.exception;

import com.study.lease.common.result.ResultCodeEnum;

/**
 * ClassName: LeaseException
 * Package: com.study.lease.common.exception
 * Description:
 *
 * @Author pupil
 * @Create 2025/4/30 17:29
 * @Version 1.0
 */
public class LeaseException extends RuntimeException{
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public LeaseException(Integer code, String message) {
        super(message);
        this.code=code;
    }
    public LeaseException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code=resultCodeEnum.getCode();
    }
}
