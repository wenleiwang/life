package ink.poesy.life.service.learn.springbootw.o1o6;

import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 当className中包含某个包名时，即当前加载类是某个包下面的类，就返回true，表示该类过滤，不放到spring容器中。
 * 如果我们在使用自定义（excludeFilters = @Filter(type = FilterType.CUSTOM, classes = {自己定义的类})）
 * @author WangWenLei
 * @DATE: 2020/10/30
 **/
public class MyTypeFilter implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        String className = classMetadata.getClassName();
        System.err.println("classname--->"+className);
        if(className.contains("ink.poesy.life.service")){
            System.out.println("exclude java file is "+className);
            return true;
        }
        return false;
    }
}
