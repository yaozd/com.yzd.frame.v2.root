package com.yzd.web.api.model.response._base;

/**
 * Created by zd.yao on 2017/3/21.
 */
public class JsonResult {
    public JsonResult() {
    }

    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
