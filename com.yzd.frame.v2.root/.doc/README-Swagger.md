
### swagger 响应数据

```
list集合：
@ApiResponses( value = {@ApiResponse( code = 200, message = "success", response = LoginForm.class, responseContainer = "List" ) } )
单一对象：
@ApiResponses( value = {@ApiResponse( code = 200, message = "success", response = LoginForm.class ) } )
```

### [SpringBoot2 配置swagger2并统一加入认证参数](https://www.jianshu.com/p/7a24d202b395)