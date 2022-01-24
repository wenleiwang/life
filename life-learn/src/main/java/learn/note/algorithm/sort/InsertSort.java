package learn.note.algorithm.sort;

/**
 * 插入排序
 * @author WangWenLei
 * @DATE: 2021/5/25
 **/
public class InsertSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        for(int i = 0 ; i < a.length ; i++){
            for(int j = i ; j > 0; j--){
                if(!less(a[j-1],a[j])) exch(a,j-1,j);
            }
        }
    }

    @Override
    public boolean less(Comparable v, Comparable w) {
        // 小于为true
        return v.compareTo(w) < 0;
    }

    @Override
    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i] ;
        a[i] = a[j];
        a[j] = t;
    }
}
