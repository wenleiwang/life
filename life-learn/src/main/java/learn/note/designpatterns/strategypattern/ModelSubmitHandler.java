package learn.note.designpatterns.strategypattern;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author WangWenLei
 * @DATE: 2021/7/20
 **/
@Slf4j
@Component
public class ModelSubmitHandler implements FormSubmitHandler<Serializable> {
    @Override
    public String getSubmitType() {
        return "model";
    }

    @Override
    public String handleSubmit(FormSubmitRequest request) {
        log.info("模型提交：userId={}，formInput={}",request.getUserId(),request.getFormInput());
        Long modelId = createModel(request);

        return "模型提交成功！";

    }

    private Long createModel(FormSubmitRequest request) { // 创建模型的逻辑
        return 123L;
    }
}
