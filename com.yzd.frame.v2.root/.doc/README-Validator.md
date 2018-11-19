-[Spring Boot 2.0.2 使用 hibernate validator](https://blog.csdn.net/u013107634/article/details/80639412)
-

```
import org.hibernate.validator.constraints.NotBlank;  已经过时了，点进入看
@deprecated use the standard {@link javax.validation.constraints.NotBlank} constraint instead
这句话提示我们过时了 要使用 
javax.validation.constraints.NotBlank 
```