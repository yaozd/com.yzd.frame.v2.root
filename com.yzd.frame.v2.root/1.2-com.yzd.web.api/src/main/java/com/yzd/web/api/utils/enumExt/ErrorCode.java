package com.yzd.web.api.utils.enumExt;

/***
 * 错误代码
 */
public enum ErrorCode {
    //参数验证失败
    ParamValidFail(1000);


    ErrorCode(int value){
        this.value=value;
    }
    private int value;
    public int getValue(){
        return this.value;
    }
}
