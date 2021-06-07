package learn.algorithm.sort;

/**
 * @author WangWenLei
 * @DATE: 2021/5/25
 **/
public class ChooseSort {
    public void sort(Comparable [] a){
        for (int i = 0 ; i < a.length ; i++) {
            int min = i;
            for(int j = i+1 ; j < a.length ; j++){
                if(!less(a[min],a[j])) {
                    min = j;
                }
            }
            exch(a,i,min);
        }
    }

    public boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public void exch(Comparable [] a, int i , int j){
        Comparable t = a[i] ;
        a[i] = a[j];
        a[j] = t;
    }
}
