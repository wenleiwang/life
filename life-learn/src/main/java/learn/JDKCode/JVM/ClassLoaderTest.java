package learn.JDKCode.JVM;

/**
 *
 * @author WangWenLei
 * @DATE: 2021/11/23
 **/
public class ClassLoaderTest {
    public static void main(String[] args) {
        // null Bootstrap Loader是用C++语言写的，依java的观点来看，逻辑上并不存在Bootstrap Loader的类实体
        System.out.println(String.class.getClassLoader());
        // sun.misc.Launcher$ExtClassLoader@6e2c634b
        System.out.println(learn.JDKCode.JVM.ClassLoaderTest.class.getClassLoader().getParent());
    }
}
