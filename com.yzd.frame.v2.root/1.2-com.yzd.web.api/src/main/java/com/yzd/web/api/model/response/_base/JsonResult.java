package com.yzd.web.api.model.response._base;

/**
 * Created by zd.yao on 2017/3/21.
 */
public class JsonResult {
    public JsonResult() {
    }
    public JsonResult(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
