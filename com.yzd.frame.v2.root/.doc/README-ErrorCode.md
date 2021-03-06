## -注：操作成功-CODE=200，其他都为失败。

### -思路：通过错误异常的处理，来进行业务逻辑的处理与流程的中断操作

### -错误码分类
1. -返回数据所主要用于页面做数据反显
2. -返回数据主要用于页面弹出提示，在页面不做数据反显
3. -返回数据根据code码，在页面做相关业务逻辑处理


### -错误码对照表
### -错误码对照表
|NAME  | CODE  | MESSAGE|
|--------------|--------------|--------------|
|SUCCESS.OK  | 200 |SUCCESS  |
|ERROR.Unauthorized  | 401 |未授权，head中authentication信息不对  |
|ERROR.ForbiddenAccess  | 403 |用户没有登录，无访问权限  |
|ERROR.InnerError  | 500 |服务器内部未知异常  |
|ERROR.InvalidRequestParametersReturnStringError  | 1001 |请求参数不合法-返回错误信息 -暂时不使用-20181217-0945 |
|ERROR.InvalidRequestParametersReturnJsonError  | 1002 |请求参数不合法-返回JSON类型的字符串错误信息-返回数据所主要用于页面做数据反显  |
|ERROR.DataValidFail  | 1003 |数据有效性验证失败-返回数据主要用于页面弹出提示，在页面不做数据反显  |
|ERROR.RepeatedSubmitRequest  | 1101 |操作正在执行，请不要重复提交请求  |
|ERROR.AlreadyReceive  | 1102 |已领取（如：活动红包等）  |
|ERROR.NotFoundTokenFail  | 4100 |在Header中没有找到Token信息  |
|ERROR.VerifyTokenFail  | 4101 |验证Token信息失败  |
|ERROR.GetTokenFail  | 4102 |获取Token失败  |
|ERROR.RefreshTokenFail  | 4103 |刷新Token失败  |


### 参考：
- [shareSdk错误码对照表](https://blog.csdn.net/u010052279/article/details/50056423)-推荐byArvin-2018-12-14
- [云服务总线CSB>开发指南>错误代码](https://help.aliyun.com/document_detail/58610.html)-推荐byArvin-2018-12-14
- [IM SDK ErrorCode 定义](https://docs.jiguang.cn/jmessage/client/im_errorcode_android/)
- [Error code - 微博API](https://open.weibo.com/wiki/Error_code)
- [常见错误码及定义](https://blog.csdn.net/ycl295644/article/details/50627823)