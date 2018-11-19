
### swagger 响应数据

```
list集合：
@ApiResponses( value = {@ApiResponse( code = 200, message = "success", response = LoginForm.class, responseContainer = "List" ) } )
单一对象：
@ApiResponses( value = {@ApiResponse( code = 200, message = "success", response = LoginForm.class ) } )
```