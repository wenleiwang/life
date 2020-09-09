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
