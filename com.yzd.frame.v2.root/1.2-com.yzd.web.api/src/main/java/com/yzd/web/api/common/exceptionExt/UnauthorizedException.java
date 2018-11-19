package com.yzd.web.api.common.exceptionExt;

/***
 * 没有权限信息
 */
public class UnauthorizedException extends RuntimeException {
    /**
     * 构造一个基本异常.
     *
     * @param message 信息描述
     */
    public UnauthorizedException(String message) {
        super(message);
    }
}
