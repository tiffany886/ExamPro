### Error:java: 无效的源发行版: 13 
1. 检查Java版本，可以在命令行中执行以下命令来获取Java版本信息：`java -version`
2. 更改项目配置(pom.xml)
```xml
<properties>
    <java.version>版本号</java.version>
</properties>
```