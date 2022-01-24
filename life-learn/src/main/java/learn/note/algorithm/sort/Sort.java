package learn.note.algorithm.sort;

/**
 * 排序算法的通用方法
 * @author fang.com
 */
public interface Sort {
    void sort(Comparable [] a);
    boolean less(Comparable v,Comparable w);
    void exch(Comparable [] a , int i, int j);
}
