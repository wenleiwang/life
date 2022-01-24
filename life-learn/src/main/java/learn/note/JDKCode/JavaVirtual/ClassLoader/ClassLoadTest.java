package learn.note.JDKCode.JavaVirtual.ClassLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author WangWenLei
 * @DATE: 2021/3/4
 **/
public class ClassLoadTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoad = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
//                    String fileName  = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    String fileName  = name.substring(name.indexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null){
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj=myLoad.loadClass("learn.note.JDKCode.JavaVirtual.ClassLoader.ClassLoadTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoadTest);
    }
}
