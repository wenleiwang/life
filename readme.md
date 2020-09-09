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
