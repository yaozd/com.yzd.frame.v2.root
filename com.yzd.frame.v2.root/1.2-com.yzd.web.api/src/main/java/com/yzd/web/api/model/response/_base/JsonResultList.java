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

    private JsonResultList(List<T> data, Integer total) {
        super(JsonResultCodeEnum.SUCCESS.OK.getCode(),JsonResultCodeEnum.SUCCESS.OK.getMessage());
        this.setData(data);
        this.setTotal(total);
    }

    private List<T> data;
    private Integer total;

    public List<T> getData() {
        return data;
    }

    private void setData(List<T> data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    private void setTotal(Integer total) {
        this.total = total;
    }

    public static <T> JsonResultList build(List<T> data){
        return new JsonResultList(data);
    }
    public static <T> JsonResultList build(List<T> data, Integer total){
        return new JsonResultList(data,total);
    }
}
