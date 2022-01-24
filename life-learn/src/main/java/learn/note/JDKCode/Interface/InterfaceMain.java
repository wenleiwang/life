package learn.note.JDKCode.Interface;

/**
 * 关于一个测试
 * 		List<MappedInterceptor> mappedInterceptors = new ArrayList<>(this.adaptedInterceptors.size());
 * 		for (HandlerInterceptor interceptor : this.adaptedInterceptors) {
 * 			if (interceptor instanceof MappedInterceptor) {
 * 				mappedInterceptors.add((MappedInterceptor) interceptor);
 *          }
 * 		}
 * 	我不信为啥 	HandlerInterceptor 类型 能强转 成 MappedInterceptor，
 * 	MappedInterceptor 是实现HandlerInterceptor的。
 * 	interceptor以前是个实现HandlerInterceptor的另一种对象的数据
 * @Author Wang WenLei
 * @Date 2021/11/25 21:57
 * @Version 1.0
 **/
public class InterfaceMain {
    public static void main(String[] args) {
        InterfaceTest test1 = new UseInterface1();
        test1.printName();
        UseInterface2 test2 = (UseInterface2)test1;
        test2.printName();
        // 果然不能转
        // 仔细一看 奥 人有个判断 if (interceptor instanceof MappedInterceptor)
        // 大意了 有闪
    }
}
