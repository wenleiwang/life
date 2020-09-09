package ink.poesy.life.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor//有参构造
@NoArgsConstructor//无参构造
@ToString
@Accessors(chain = true)
public class User {
    private Long id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名",required = true)
    private String name;
    /**
     * 密码
     */
    @ApiModelProperty(value = "用户密码",required = true)
    @TableField(exist = false)
    private String password;

    private Integer age;

    private String email;
}
