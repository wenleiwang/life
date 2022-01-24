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
public class OnlinePreviewSubmitHandler implements FormSubmitHandler<Serializable> {
    @Override
    public String getSubmitType() {
        return "online preview";
    }

    @Override
    public String handleSubmit(FormSubmitRequest request) {
        log.info("在线预览提交：userId={}, formInput={}", request.getUserId(), request.getFormInput());
        return "在线预览模式提交数据成功!";
    }
}

