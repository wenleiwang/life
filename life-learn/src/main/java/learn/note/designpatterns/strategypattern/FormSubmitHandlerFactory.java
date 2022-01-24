package learn.note.designpatterns.strategypattern;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WangWenLei
 * @DATE: 2021/7/20
 **/
@Component
public class FormSubmitHandlerFactory implements InitializingBean, ApplicationContextAware {
    private static final Map<String, FormSubmitHandler<Serializable>> FORM_SUBMIT_HANDLER_MAP = new HashMap<>();
    private ApplicationContext applicationContext;

    /**
     * 根据提交类型获取对应的处理器
     * @param submitType 提交类型
     * @throws Exception
     */
    public FormSubmitHandler<Serializable> gethandler(String submitType){
        return FORM_SUBMIT_HANDLER_MAP.get(submitType);
    }

    /**
     * 在属性注入完成后调用
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        applicationContext.getBeansOfType(FormSubmitHandler.class).values().forEach(
                handler -> FORM_SUBMIT_HANDLER_MAP.put(handler.getSubmitType(),handler)
        );
    }

    /**
     * 用来获取当前环境中的 ApplicationContext
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
