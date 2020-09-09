[TOC](目录)

#Swagger
# 什么是Swagger

#SpringBoot如何使用Swagger
1. 首先添加依赖
```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.9.2</version>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
2. 提供一个Docket的Bean
即提供一个Swagger的配置类，首先使用@EnableSwagger2启用Swagger2
其次，配置一个Docket Bean，这个Bean配置映射路径和要扫描接口的位置，在apiInfo中是配置Swagger2网站信息
最后启动项目，访问http://localhost:8080/swagger-ui.html页面。
> 使用时注意吧Bean加入Spring
> 类上@Configuration注解
> 方法上@Bean

类详情
```java
package ink.poesy.life.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("ink.poesy.life.controller"))
                .build().apiInfo(apiInfo());

    }

    /**
     * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Owen User Swagger")
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();

    }
}
```
3. 启动后就可以使用了
4. 让我来测试一下
编写类如下
```java
package ink.poesy.life.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Owner use Swagger Test 类的描述")
@RestController
@RequestMapping("/test")
public class Test {
    @ApiOperation(value = "测试Swagger的接口的描述，备注",notes = "返回字符串test")
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
```
效果如下
![avatar](src/image/use-swagger-1.png)

## @ApiModelProperty()
 用于方法，字段； 表示对model属性的说明或者数据操作更改 
   > value–字段说明 
   > name–重写属性名字 
   > dataType–重写属性类型 
   > required–是否必填 
   > example–举例说明 
   > hidden–隐藏

使用效果
</br>
首先创建一个接收请求的controller，POST传入一个User对象
```java
package ink.poesy.life.controller;

import ink.poesy.life.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用于用户相关的请求")
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "展示用户信息",notes = "返回用户的信息")
    @PostMapping("/showUserInfo")
    public String showUserInfo(@RequestBody User user){
        return user.toString();
    }
}
```
创建user对象添加 @ApiModelProperty(value = "用户名",required = true)描述
```java
package ink.poesy.life.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User {
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名",required = true)
    private String name;
    /**
     * 密码
     */
    @ApiModelProperty(value = "用户密码",required = true)
    private String password;
}
```
效果图
![active](src/image/use-swagger-2.jpg)

---

# 对象接收
前后端传入参数时，字符对应不上使用@JsonProperty("bUserName")
来把该属性的名称序列化为另外一个名称
* JsonProperty是位于jackson包里面，
  搭配ObjectMapper().writeValueAsString(实体类)方法使用，将实体类转换成字符串。
* JSONField是位于fastjson包里面，
搭配JSON.toJSONString(实体类)方法使用，将实体类转换成json字符串。搭配JSON.parseObject(字符串,实体类.class)方法使用，将字符串转换成实体类。

---

# 使用logger.isInfoEnable()
简单来说，就是用isDebugEnabled方法判断下是能提升性能的。
（From: http://blog.sina.com.cn/s/blog_616b57310100f36s.html ）

 if (logger.isInfoEnabled()) {         
    logger.info("User " + userId + " is using app " + appId);     
 }
为什么要加上logger.isInfoEnabled()？原因有两点。
1. 直接使用logger.info("User " + userId + " is using app " + appId)来输出log，
也能够达到log级别为INFO或在INFO以下时才输出：
("User " + userId + " is using app " + appId)，
因为logger.info方法内部有判断输出级别的代码。
但是在进入logger.info函数之前，("User " + userId + " is using app " + appId) 
这个表达式已经通过运算拼接成了一个字符串；
而如果事先使用 if (logger.isInfoEnabled())进行判断，
那么当log级别在INFO以上时，就能省去上述的字符串操作，
在高并发和复杂log信息拼接的情况下，使用这种标准的方法输出log能够省去不小的系统开销。
另外，如果构造log信息的过程需要大量字符串操作，建议使用StringBuilder来完成字符串拼接。
2. ERROR及其以上级别的log信息是一定会被输出的，
所以只有logger.isDebugEnabled和logger.isInfoEnabled方法，
而没有logger.isErrorEnabled方法。

# 配置Slf4j
## springboot使用Slf4j的方法
1. 首先开启日志
```xml
    <!--        开启日志-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-logging</artifactId>
        <version>2.1.7.RELEASE</version>
        <scope>compile</scope>
    </dependency>
```

2. 添加xml在resource里
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--
    scan:当此属性设置为true时，配置文件如果发生改变，将会被重新加载，默认值为true。
    scanPeriod:设置监测配置文件是否有修改的时间间隔，如果没有给出时间单位，默认单位是毫秒。当scan为true时，此属性生效。默认的时间间隔为1分钟。
    debug:当此属性设置为true时，将打印出logback内部日志信息，实时查看logback运行状态。默认值为false。
-->
<configuration>

    <!-- 格式化输出：%date表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度 %msg：日志消息，%n是换行符-->
    <property name="LOG_PATTERN" value="%date{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n" />
    <!-- 定义日志存储的路径，不要配置相对路径 -->
<!--    <property name="FILE_PATH" value="E:/logs/demo.%d{yyyy-MM-dd}.%i.log" />-->

    <!-- 控制台输出日志 -->
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <!-- 按照上面配置的LOG_PATTERN来打印日志 -->
            <pattern>${LOG_PATTERN}</pattern>
        </encoder>
    </appender>

    <!--每天生成一个日志文件，保存15天的日志文件。rollingFile是用来切分文件的 -->
<!--    <appender name="FILE"-->
<!--              class="ch.qos.logback.core.rolling.RollingFileAppender">-->
<!--        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">-->
<!--            <fileNamePattern>${FILE_PATH}</fileNamePattern>-->
<!--            &lt;!&ndash; keep 15 days' worth of history &ndash;&gt;-->
<!--            <maxHistory>15</maxHistory>-->
<!--            <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">-->
<!--                &lt;!&ndash; 日志文件的最大大小 &ndash;&gt;-->
<!--                <maxFileSize>10MB</maxFileSize>-->
<!--            </timeBasedFileNamingAndTriggeringPolicy>-->
<!--        </rollingPolicy>-->

<!--        <encoder>-->
<!--            <pattern>${LOG_PATTERN}</pattern>-->
<!--        </encoder>-->
<!--    </appender>-->


    <!-- project default level -->
    <logger name="src" level="INFO" />

    <!-- 日志输出级别 常用的日志级别按照从高到低依次为：ERROR、WARN、INFO、DEBUG。 -->
    <root level="INFO">
        <appender-ref ref="CONSOLE" />
<!--        <appender-ref ref="FILE" />-->
    </root>
</configuration>
```
3. 在application.yml里配置日志
```yaml
## 日志配置
logging:
  config: src/main/resources/logback.xml
  # 数据库日志级别
  level:
    com.github.springbootmiaosha.dao: trace
```

4. 就可以启动使用了

# mybatis-plus的使用
查看mybatis-plus官方网站
## 构建数据表和数据库
```sql
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
```sql
DELETE FROM user;

INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@poesy.com'),
(2, 'Jack', 20, 'test2@poesy.com'),
(3, 'Tom', 28, 'test3@poesy.com'),
(4, 'Sandy', 21, 'test4@poesy.com'),
(5, 'Billie', 24, 'test5@poesy.com');
```
## 引入依赖
先添加mybatis-plus依赖
```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.1.0</version>
</dependency>
```
添加数据库连接池
添加数据库连接驱动
```xml
<!-- mysql数据库的驱动包 start -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.38</version>
</dependency>
```
```xml
<!-- druid -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.0.18</version>
</dependency>
```
## 配置数据库
```yaml
spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/poesy_life?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false
    username: root
    password: root
```
## 启动类上添加`@MapperScan("ink.poesy.life.dao")`注解
## 