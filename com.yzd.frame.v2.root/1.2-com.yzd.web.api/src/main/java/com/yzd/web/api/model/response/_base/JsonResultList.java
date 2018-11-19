package com.yzd.web.api.model.response._base;

import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */
public class JsonResultList<T> extends JsonResult {
    public JsonResultList() {
    }

    public JsonResultList(List<T> data) {
        this.setSuccess(true);
        this.setData(data);
    }

    public JsonResultList(List<T> data, int total) {
        this.setSuccess(true);
        this.setData(data);
        this.setTotal(total);
    }

    private List<T> data;
    private int total;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
