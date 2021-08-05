package learn.algorithm.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 快速排序
 *  应用最广泛的排序算法，实现简单，适用于各种不同的输入数据且在一般应用中比其他排序算法那都要快的多
 *  最引人注目的特点包括它是原地排序（只需一个很小的辅助栈），且长度为N的数组排序所需的时间和NlgN成正比。
 * @author WangWenLei
 * @DATE: 2021/5/27
 **/
public class FastSort {
    public static void main(String[] args) {
        int [] data = new int[]{1,7,3,11,8,5,10,2,4,9,6};
        fastSort(data,0,data.length - 1);
        Arrays.stream(data).forEach(System.out::println);
    }

    public static void fastSort(int [] data,int low,int high){
        if(low >= high){
            return;
        }
        int pivot = data[low];
        int i = low;
        int j = high;
        while(i < j){
            // 因为 要 想左移动j，直到data[j] < pivot
            while(i < j && pivot < data[j]){
                j -- ;
            }
            if(i < j){
                data [i] = data[j];
                i++;
            }
            while(i < j && pivot > data[i]){
                i ++ ;
            }
            // 下面的if在第一次编写时丢了，导致少了一部分逻辑
            if(i < j){
                data [j] = data[i];
                j--;
            }
        }
        data[i] = pivot;
        fastSort(data,low,--i);
        // 这里错误的使用了 ++i，现在改成了++j。错误原因i在上面已经被减过了
        fastSort(data,++j,high);
    }
}
