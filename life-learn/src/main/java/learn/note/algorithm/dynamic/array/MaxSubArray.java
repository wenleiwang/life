package learn.note.algorithm.dynamic.array;

/**
 * 最大路径和
 * @author WangWenLei
 * @DATE: 2021/7/23
 **/
public class MaxSubArray {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int [] data = new int[len];
        for(int i = 0 ; i < len ; i ++){
            if(i == 0){
                data[i] = nums[i];
            }else{
                data[i] = Math.max(data[i-1]+nums[i] , nums[i]);
            }
        }
        int a = Integer.MIN_VALUE;
        for(int i = 0 ; i < len; i++){
            if(data[i] > a){
                a = data[i];
            }
        }
        return a;
    }
}
