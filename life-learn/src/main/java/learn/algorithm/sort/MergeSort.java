package learn.algorithm.sort;

/**
 * 归并排序
 *  将两个有序的数组归并成一个更大的有序数组。
 *  要将一个数组排序，可以先（递归地）将他分成两半分别排序，然后将结果归并起来。
 *  将看到归并排序最吸引人的性质是：他能够保证将任意长度为N的数组排序所需时间和NlogN成正比；
 *  缺点：他所需的额外空间和N成正比。
 * @author WangWenLei
 * @DATE: 2021/5/27
 **/
public class MergeSort {
    public static void main(String[] args) {
        int [] data = new int[]{2,2,3,1,5,8,9,65,3,12,4,5,9,4,3,2,1};
        mergeSort(data,data[0],data[data.length],new int[data.length]);
    }

    private static int mergeSort(int[] data, int low, int high, int[] ints) {
        if(low == high){
            return data[low];
        }
        // 计算中位数
        int middle = low + ((high - low) >> 2);
        mergeSort(data,low,middle-1,ints);
        mergeSort(data,middle,middle,ints);
        return  middle;
    }
}
