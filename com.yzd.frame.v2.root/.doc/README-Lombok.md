
-[使用Lombok来优雅的编码](https://www.cnblogs.com/qnight/p/8997493.html)
-
```
在按快捷键 Ctrl + F12，可以查找到set,get,toString 方法。

注解
写点常用的，其余的 api 的打开 Jar 包一目了然

@Getter
@Setter
@ToString
@EqualsAndHashCode
构造函数
@AllArgsConstructor
会生成一个包含所有变量，同时如果变量使用了NotNull annotation ， 会进行是否为空的校验， 
全部参数的构造函数的自动生成，该注解的作用域也是只有在实体类上，参数的顺序与属性定义的顺序一致。

@NoArgsConstructor
无参构造函数

@RequiredArgsConstructor
会生成一个包含常量（final），和标识了@NotNull的变量 的构造方法。
@Data
我自己尝试了下，我们使用 @Data 注解就可以有下面几个注解的功能： @ToString、@Getter、@Setter、@EqualsAndHashCode、@NoArgsConstructor 。

注意的是，同时使用@Data 和 @AllArgsConstructor 后 ，默认的无参构造函数失效，如果需要它，要重新设置 @NoArgsConstructor
@Slf4j
//类上面注解了，直接调用 log 即可：
log.info(xxxx);
@Log
使用的是 java.util.logging.Logger ，直接使用 变量 log。

@Builder
bulder 模式构建对象。

@Cleanup
@Cleanup 
InputStream in = new FileInputStream(args[0]);
@Cleanup 
OutputStream out = new FileOutputStream(args[1]);
自动化关闭流，相当于 jdk1.7 种的 try with resource

val
类型推导。

 val example = new ArrayList<String>();
 example.add("Hello, World!");
对应的转换后代码就是：

 val example = new ArrayList<String>();
 example.add("Hello, World!");
@NonNull
public NonNullExample(@NonNull Person person) {
    this.name = person.getName();
 }
转换后就是：

public NonNullExample(@NonNull Person person) {
    if (person == null) {
      throw new NullPointerException("person");
    }
    this.name = person.getName();
 }
@SneakyThrows
翻译就是暗中抛出异常

当我们需要抛出异常，在当前方法上调用，不用显示的在方法名后面写 throw

@SneakyThrows(Exception.class)
@Synchronized
方法中所有的代码都加入到一个代码块中，默认静态方法使用的是全局锁，普通方法使用的是对象锁，当然也可以指定锁的对象。

private final Object lock = new Object();
@Synchronized("lock")
public void foo() {
    // Do something
}
个人认为这样的阅读起来比较麻烦，实际开发中往往将 synchronized 颗粒化到代码块中。

```