package com.yzd.web.api.model.response._base;

/**
 * Created by Administrator on 2016/10/20.
 */
public class JsonResultOk extends JsonResult {
    public JsonResultOk() {
        this.setSuccess(true);
    }

    public JsonResultOk(String msg) {
        this.setSuccess(true);
        this.setMsg(msg);
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
