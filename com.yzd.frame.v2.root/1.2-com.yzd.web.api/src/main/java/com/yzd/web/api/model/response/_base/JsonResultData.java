package com.yzd.web.api.model.response._base;

/**
 * Created by Administrator on 2016/10/20.
 */

public class JsonResultData<T> extends JsonResult {
    public JsonResultData() {
    }

    public JsonResultData(T data) {
        this.setSuccess(true);
        this.setData(data);
    }

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
