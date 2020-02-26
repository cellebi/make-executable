# Jar-Executor
## 简介
这是一个可以让你打包出来的jar包（cli 程序）变成二进制的可执行文件的gradle插件。
例如你的项目最终打包出来是app.jar，通过使用Jar-Executor插件，你可以根据app.jar来生成一个二进制可执行文件，例如app。
至此，你就可以通过执行命令./app替代java -jar app.jar来运行你的程序。

## 特点

- 简结，直接生成一个二进制可执行文件，无需继续繁琐的运行jar步骤
- 易用，结合gradle，只需简单配置build文件即可使用

## task

Jar-Executor包含了两个gradle任务

- makeJarExecutable
- prepareMakeExecutable

## 使用
- 安装

添加以下代码到你的`build.gradle`或者`build.gradle.kts`

 Groovy
 
```groovy
plugins {
  id "pub.cellebi.make-executable" version "0.0.1"
}
```
  Kotlin
  
```kotlin
plugins {
  id("pub.cellebi.make-executable") version "0.0.1"
}
```

- 配置

kotlin

```kotlin
makeExecutable {
    name = "app"
    options = arrayOf("-cp","lib")
}
```
其中name是你最终生成的可执行文件的名称，options是配置java命令的options，
例如上面例子配置了类路径为lib。


- 执行任务
```bash
gradle makeJarExecutable
```
最后文件将生成在build/dist文件夹下


