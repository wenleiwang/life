package learn.note.designpatterns.strategypattern;

import java.io.Serializable;

/**
 * 表单提交处理器
 * @param <R>
 */
public interface FormSubmitHandler <R extends Serializable> {
    /**
     * 用来获取表单提交类型（即策略类型），用于根据客户端传递的参数直接获取到对应的策略实现；
     * @return 提交类型
     */
    String getSubmitType();

    /**
     * 处理表单提交请求
     * @param request
     * @return
     */
    String handleSubmit(FormSubmitRequest request);

}
