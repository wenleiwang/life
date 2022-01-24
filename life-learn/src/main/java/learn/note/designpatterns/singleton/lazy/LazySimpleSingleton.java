package learn.note.designpatterns.singleton.lazy;

/**
 * 懒汉模式
 * @author WangWenLei
 * @DATE: 2021/7/5
 **/
public class LazySimpleSingleton {
    private static LazySimpleSingleton lazySimpleSingleton = null;
    private LazySimpleSingleton(){}
    public synchronized static LazySimpleSingleton getInstance(){
        if(lazySimpleSingleton == null){
            lazySimpleSingleton = new LazySimpleSingleton();
        }
        return lazySimpleSingleton;
    }
}
