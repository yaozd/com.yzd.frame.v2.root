package com.yzd.web.api.model.response._base;

import com.yzd.web.api.utils.enumExt.JsonResultCodeEnum;

/**
 * Created by Administrator on 2016/10/20.
 */

public class JsonResultData<T> extends JsonResult {
    public JsonResultData() {
    }

    private JsonResultData(T data) {
        super(JsonResultCodeEnum.SUCCESS.OK.getCode(),JsonResultCodeEnum.SUCCESS.OK.getMessage());
        this.setData(data);
    }

    private T data;

    public T getData() {
        return data;
    }

    private void setData(T data) {
        this.data = data;
    }

    public static <T> JsonResultData build(T data){
        return new JsonResultData(data);
    }
}
