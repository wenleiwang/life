package learn.note.springlearn.ConditionInstallConfig;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author WangWenLei
 * @DATE: 2021/11/19
 **/
public class ConditionalUseConfig implements Condition {
    /**
     * 确定条件是否匹配。
     * @param context 条件上下文
     * @param metadata 被检查的class或method的元数据
     * @return true如果条件匹配并且组件可以被注册，或false否决注释组件的注册
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        return "dev".equalsIgnoreCase(environment.getProperty("spring.profiles.active"));
    }
}
