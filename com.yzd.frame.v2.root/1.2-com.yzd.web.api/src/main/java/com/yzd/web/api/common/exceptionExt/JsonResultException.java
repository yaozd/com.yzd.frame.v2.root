package com.yzd.web.api.common.exceptionExt;

import com.yzd.web.api.model.response._base.JsonResult;

/***
 * JsonResultException
 * 这种异常大部分的结果是要前台做业务逻辑处理
 * -返回数据根据code码，在页面做相关业务逻辑处理
 */
public class JsonResultException extends RuntimeException {
    public JsonResultException(JsonResult result){
        this.result=result;
    }
    private JsonResult result;

    public JsonResult getResult() {
        return result;
    }

    public void setResult(JsonResult result) {
        this.result = result;
    }
}
