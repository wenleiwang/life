package com.wenwen.blog.service.learn.designpatterns.strategy.v4;

/**
 * 冒泡排序类
 * @author WangWenLei
 * @DATE: 2021/4/14
 **/
public class Sort<T> {
    public T[] compare(T[] data,Comparable<T> comparable) {
        // 外层循环
        for(int i = 0 ; i < data.length ; i++){
            // 内层循环
            for(int j = 0 ; j < data.length - 1 - i ; j++){
                // 前后比较
                if(comparable.compareTo(data,j,j + 1) > 0){
                    swap(data , j , j + 1);
                }
            }
        }
        return data;
    }

    /**
     * 数组内元素交换，把i0和i1的位置交换
     * @param data 数组
     * @param i0 交换位置1
     * @param i1 交换位置2
     */
    private void swap(T[] data, int i0, int i1){
        T i = data[i0];
        data[i0] = data[i1];
        data[i1] = i;
    }
}
