package com.yzd.web.api.model.response._base;

import com.yzd.web.api.utils.enumExt.JsonResultCodeEnum;

/**
 * Created by Administrator on 2016/10/20.
 */
public class JsonResultOk {
    public static final JsonResult SUCCESS=new JsonResult(JsonResultCodeEnum.SUCCESS.OK.getCode(),JsonResultCodeEnum.SUCCESS.OK.getMessage());
}
