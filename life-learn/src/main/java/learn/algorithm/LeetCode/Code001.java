package learn.algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author WangWenLei
 * @DATE: 2021/6/7
 **/
public class Code001 {
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0 ; i < nums.length ; i ++){
            for(int j = i ; j < nums.length ; j++){
                if((nums[i] + nums[j] == target) && (i != j)){
                    return new int[] {i,j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int [] nums = new int []{3,2,4};
        int target = 6;
        int[] ints = twoSum2(nums, target);
        for(int i = 0 ; i < ints.length ; i ++){
            System.out.println(ints[i]);
        }
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i ++){
            if(map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
