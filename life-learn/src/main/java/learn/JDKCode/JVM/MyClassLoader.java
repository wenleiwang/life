package learn.JDKCode.JVM;

/**
 * 自己定义类加载器
 * @author WangWenLei
 * @DATE: 2021/11/23
 **/
public class MyClassLoader extends ClassLoader {

    /**
     * 重写父类的 findClass 方法（父类没有具体实现，子类必须实现）
     * 其余方法都不用我们实现，因为JDK已经在loadClass方法中帮我们实现了ClassLoader搜索类的算法，当在loadClass方法中搜索不到类时，
     * loadClass方法就会调用findClass方法来搜索类，所以我们只需重写该方法即可。如没有特殊的要求，一般不建议重写loadClass搜索类的算法
     * @param name 需要加载的类名
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
