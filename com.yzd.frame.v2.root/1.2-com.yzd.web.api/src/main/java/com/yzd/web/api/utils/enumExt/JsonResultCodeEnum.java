package com.yzd.web.api.utils.enumExt;

/***
 * 错误代码
 * 使用接口组织枚举
 */
public interface JsonResultCodeEnum {
    enum SUCCESS implements JsonResultCodeEnum{
        OK(200,"SUCCESS");
        SUCCESS(Integer code,String message){
            this.code=code;
            this.message=message;
        }
        private Integer code;

        public Integer getCode() {
            return code;
        }
        private String message;

        public String getMessage() {
            return message;
        }
    }
    enum ERROR  implements JsonResultCodeEnum{
        Unauthorized(401," 未授权，head中authentication信息不对"),
        ForbiddenAccess(403,"用户没有登录，无访问权限"),
        InnerError(500,"服务器内部未知异常"),
        InvalidRequestParametersReturnStringError(1001,"请求参数不合法-返回错误信息"),
        InvalidRequestParametersReturnJsonError(1002,"请求参数不合法-返回JSON类型的字符串错误信息"),
        RepeatedSubmitRequest(1101,"操作正在执行，请不要重复提交请求"),
        AlreadyReceive(1102,"已领取"),
        NotFoundTokenFail(4100,"在Header中没有找到Token信息"),
        VerifyTokenFail(4101,"验证Token失败"),
        GetTokenFail(4102,"获取Token失败"),
        RefreshTokenFail(4103,"刷新Token失败");
        //
        ERROR(Integer code,String message){
            this.code=code;
            this.message=message;
        }
        private Integer code;

        public Integer getCode() {
            return code;
        }
        private String message;

        public String getMessage() {
            return message;
        }
    }
}
