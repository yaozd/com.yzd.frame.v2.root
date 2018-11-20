package com.yzd.common.token.enumExt;

public enum ErrorCodeJWT {
    ForbiddenAccess(403),//用户没有登录，无访问权限
    NotFoundTokenFail(4100),//没有找到Token信息在Header
    VerifyTokenFail(4101),//验证Token信息失败
    GetTokenFail(4102),//获取token失败
    RefreshTokenFail(4103);//刷新token失败

    ErrorCodeJWT(int value){
        this.value=value;
    }
    private int value;
    public int getValue(){
        return this.value;
    }
}
