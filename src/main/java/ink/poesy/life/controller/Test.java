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
