-[Velocity Spring Boot Project](https://github.com/alibaba/velocity-spring-boot-project/blob/master/README_CN.md)
-[velocity-spring-boot-sample](https://github.com/alibaba/velocity-spring-boot-project/blob/master/README_CN.md)
-

```
#set($filePath = $UrlHelperTool.getStaticFilePath())
$filePath的作用域只能在当前default.vm模板中，不能跳到其他模板
```