package learn.note.algorithm.sort;

/**
 * 希尔排序
 * 需要三层循环
 *  第一层：分组间隔逐渐变小
 *  第二层：插入排序外层循环用于控制排序进度
 *  第三层：插入排序比较换序
 * @author WangWenLei
 * @DATE: 2021/5/26
 **/
public class ShellSort implements Sort{
    @Override
    public void sort(Comparable[] a) {
        int len  = a.length;
        int h = 1;
        while (h < len /3) h = 3 * h + 1;
        while(h >= 1){
            for(int i = h ; i < len ; i++){
                for(int j = i ; j >= h && less(a[j],a[j-h]) ; j -= h ){
                    exch(a,j,j-h);
                }
            }
            h = h / 3;
        }
    }

    @Override
    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    @Override
    public void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
