package learn.designpatterns.strategypattern;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 表单提交的请求
 * @author WangWenLei
 * @DATE: 2021/7/20
 **/
@Getter
@Setter
public class FormSubmitRequest {
    /**
     * 提交类型
     */
    private String submitType;
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 表单提交的数据
     */
    private Map<String, Object> formInput;
}
