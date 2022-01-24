package learn.note.designpatterns.strategy.v2;

/**
 * 冒泡排序类
 * @author WangWenLei
 * @DATE: 2021/4/14
 **/
public class Sort {
    public int[] compare(int[] data) {
        // 外层循环
        for(int i = 0 ; i < data.length ; i++){
            // 内层循环
            for(int j = 0 ; j < data.length - 1 - i ; j++){
                // 前后比较
                if(data[j] > data[j + 1]){
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
    private void swap(int [] data,int i0, int i1){
        int i = data[i0];
        data[i0] = data[i1];
        data[i1] = i;
    }

    public float[] compare(float[] data) {
        // 外层循环
        for(int i = 0 ; i < data.length ; i++){
            // 内层循环
            for(int j = 0 ; j < data.length - 1 - i ; j++){
                // 前后比较
                if(data[j] > data[j + 1]){
                    swap(data , j , j + 1);
                }
            }
        }
        return data;
    }
    /**
     * 浮点类型：数组内元素交换，把i0和i1的位置交换
     * @param data 数组
     * @param i0 交换位置1
     * @param i1 交换位置2
     */
    private void swap(float [] data,int i0, int i1){
        float i = data[i0];
        data[i0] = data[i1];
        data[i1] = i;
    }
}
