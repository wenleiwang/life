//package learn.note.JDKCode.proxy.write;
//
//import javax.tools.JavaCompiler;
//import javax.tools.StandardJavaFileManager;
//import javax.tools.ToolProvider;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Method;
//
///**
// * 用来生成源代码的工具类
// * @author WangWenLei
// * @DATE: 2021/7/7
// **/
//public class GPProxy {
//    public static final String ln = "\r\n";
//
//    public static Object newProxyInstance(GPClassLoader classLoader, Class<?> [] interfaces, GpInvocationHandler h){
//        try {
//            // 动态生成源代码.java文件
//            String src = generateSrc(interfaces);
//
//            // java 文件输出磁盘
//            String filePath = GPProxy.class.getResource("").getPath();
//            File f = new File(filePath + "$Proxy0.java");
//
//            FileWriter fw = new FileWriter(f);
//            fw.write(src);
//            fw.flush();
//            fw.close();
//             // 把生成的 .java文件编译成。calss文件
//            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//            StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
//            Iterable iteralbel = manager.getJavaFileObjects(f);
//
//            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null,null, iteralbel);
//            task.call();
//            manager.close();
//
//            // 把编译成的 。class文件加载到jvm中
//            Class proxyClass = classLoader.findClass("$Proxy0");
//            Constructor c = proxyClass.getConstructor(GpInvocationHandler.class);
//            f.delete();
//
//            // 返回字节码重组有的新的的代理对象
//            return c.newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private static String generateSrc(Class<?>[] interfaces) {
//        StringBuffer sb = new StringBuffer();
//        sb.append("package learn.note.JDKCode.proxy.write;" + ln);
//        sb.append("import learn.note.JDKCode.proxy.write.Person;" + ln);
//        sb.append("import java.lang.reflect.*;" + ln);
//        sb.append("public calss $Porxy0 implements " + interfaces[0].getName() + "{" + ln);
//        sb.append("GpInvocationHandler h;" + ln);
//        sb.append("public $Proxy0(GpInvocationHandler h) { " + ln);
//        sb.append("this.h = h;");
//        sb.append("}" + ln);
//        for(Method m : interfaces[0].getMethods()){
//            Class<?> [] params = m.getParameterTypes();
//
//            StringBuffer paramNames = new StringBuffer();
//            StringBuffer paramValues = new StringBuffer();
//            StringBuffer paramClasses = new StringBuffer();
//
//            for(int i = 0 ; i < params.length ; i++){
//                Class clazz = params[i];
//                String type = clazz.getName();
//                String paramName = toLowerFirstCase(clazz.getSimpleName());
//                paramNames.append(type + " " + paramName);
//                paramValues.append(paramName);
//                paramClasses.append(clazz.getName() + ".class");
//
//                if(i > 0 && i < params.length - 1){
//                    paramNames.append(",");
//                    paramValues.append(",");
//                    paramClasses.append(",");
//                }
//            }
//            sb.append("public " + m.getReturnType().getName() + " " + m.getName() = "(" + paramNames.toString() + ") {" + ln);
//        }
//
//    }
//}
