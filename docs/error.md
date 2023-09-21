### Error:java: 无效的源发行版: 13 
1. 检查Java版本，可以在命令行中执行以下命令来获取Java版本信息：`java -version`

2. 更改项目配置(pom.xml)

```xml
<properties>
    <java.version>版本号</java.version>
</properties>
```

### Ambiguous mapping错误
1. Spring Boot应用程序中出现“Ambiguous mapping”错误时，这意味着Spring Boot无法确定要将请求映射到哪个控制器方法，因为有多个方法匹配相同的请求映射。

2. 解决办法：

    - 更改请求映射：修改控制器方法上的请求映射注解，使它们变得唯一。确保每个方法的请求映射是不同的，不会冲突。

    - 重命名控制器类或方法：重命名helloController或userController类或它们的方法，以确保没有命名冲突。

    - 指定显式顺序：您可以为控制器类或方法指定显式顺序，以确保它们被正确处理。这可以通过使用@Order注解或Ordered接口来实现。

