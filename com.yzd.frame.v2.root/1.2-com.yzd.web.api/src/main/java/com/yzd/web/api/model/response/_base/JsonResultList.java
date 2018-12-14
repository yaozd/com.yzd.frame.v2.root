package com.yzd.web.api.model.response._base;

import com.yzd.web.api.utils.enumExt.JsonResultCodeEnum;

import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */
public class JsonResultList<T> extends JsonResult {
    public JsonResultList() {
    }

    private JsonResultList(List<T> data) {
        super(JsonResultCodeEnum.SUCCESS.OK.getCode(),JsonResultCodeEnum.SUCCESS.OK.getMessage());
        this.setData(data);
    }

    private JsonResultList(List<T> data, int total) {
        super(JsonResultCodeEnum.SUCCESS.OK.getCode(),JsonResultCodeEnum.SUCCESS.OK.getMessage());
        this.setData(data);
        this.setTotal(total);
    }

    private List<T> data;
    private int total;

    public List<T> getData() {
        return data;
    }

    private void setData(List<T> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    private void setTotal(int total) {
        this.total = total;
    }

    public static <T> JsonResultList build(List<T> data){
        return new JsonResultList(data);
    }
    public static <T> JsonResultList build(List<T> data, int total){
        return new JsonResultList(data,total);
    }
}
