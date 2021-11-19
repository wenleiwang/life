package learn.JDKCode.JavaVirtual.ClassLoader;

/**
 * @author WangWenLei
 * @DATE: 2021/11/18
 **/
public class ClassLoaderTest extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
